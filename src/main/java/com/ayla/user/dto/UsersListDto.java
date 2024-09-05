package com.ayla.user.dto;

import com.ayla.user.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Data
public class UsersListDto {

    @JsonProperty("previous_page")
    private Integer previousPage;
    @JsonProperty("next_page")
    private Integer nextPage;
    @JsonProperty("current_page_number")
    private int currentPageNumber;
    @JsonProperty("start_count_on_page")
    private int startCountOnPage;

    private int total;
    private List<User> users;

    public UsersListDto(List<User> users, int total, int page, int perPage) {
        this.previousPage = page == 1 ? null : page - 1;
        this.nextPage = page * perPage <= total ? page + 1 : null;
        this.currentPageNumber = page;
        this.startCountOnPage = (page - 1) * perPage + 1;
        this.total = total;
        this.users = users;
    }
}
