package com.ayla.user.util;

import com.ayla.user.util.Consts;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import java.util.Locale;

@NoArgsConstructor
public final class QueryUtil {
    public static Sort handleSort(String orderBy, String order) {
        Sort.Direction direction = Sort.Direction.DESC;
        if (StringUtils.isBlank(orderBy)) {
            return JpaSort.unsorted();
        }
        if ("ASC".equalsIgnoreCase(order)) {
            direction = Sort.Direction.ASC;
        }
        return JpaSort.unsafe(direction, handleOrderBy(orderBy));
    }

    private static String[] handleOrderBy(String orderBy) {
        if (orderBy.startsWith(Consts.COMMA)) {
            orderBy = orderBy.substring(1);
        }
        if (orderBy.endsWith(Consts.COMMA)) {
            orderBy = orderBy.substring(0, orderBy.length() - 1);
        }
        orderBy = orderBy.toLowerCase(Locale.getDefault());
        StringBuilder sb = new StringBuilder();
        String[] inputArray = orderBy.split(Consts.COMMA);
        String[] results = new String[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            sb.delete(0, sb.length());
            sb.append(inputArray[i].trim());
            int index;
            while ((index = sb.indexOf("_")) >= 0) {
                sb.replace(index, index + 1, "");
                String target = sb.substring(index, index + 1);
                sb.replace(index, index + 1, target.toUpperCase(Locale.getDefault()));
            }
            results[i] = sb.toString();
        }

        return results;
    }
}
