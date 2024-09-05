package com.ayla.user.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Consts {

    // Pagination
    public static final int MAX_PER_PAGE = 100;
    public static final int MIN_PAGE_NUMBER = 1;
    public static final int MIN_PER_PAGE = 5;
    public static final int DEFAULT_PER_PAGE = 10;

    // Sorting fields
    public static final String USERS_SORT_VALIDATE_REGEX = "^(uuid)$";
    public static final String REGEXP_FOR_ORDER = "^(ASC|DESC|asc|desc)$";

    public static final String COMMA = ",";
}
