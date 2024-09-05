package com.ayla.user.controller;

import com.ayla.user.config.SwaggerConfig;
import com.ayla.user.dto.UsersListDto;
import com.ayla.user.service.UserService;
import com.ayla.user.util.Consts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/v2")
@Validated
@Api(tags = SwaggerConfig.SWAGGER_TAG_ADMIN_USERS)
public class AdminUsersController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(AdminUsersController.class);

    /**
     * For a given numeric OEM ID, get the list of users.
     *
     * @param oemId - numeric OEM ID.
     * @param page - current page number.
     * @param perPage - Number of user records in a page.
     * @param orderBy - field to sort user records.
     * @param order - ASC or DESC.
     *
     * @return
     */
    @GetMapping("/oems/{oem_id}/users")
    @ApiOperation(value = "Get list of users for a given OEM ID.")
    public ResponseEntity<UsersListDto> getAllUsersByOemId(
            @PathVariable("oem_id") Integer oemId,
            @Min(value = Consts.MIN_PAGE_NUMBER,
                    message = "errors.params.page.invalid")
            @RequestParam(name = "page", defaultValue = "1") int page,
            @Min(value = Consts.MIN_PER_PAGE,
                    message = "errors.params.per_page.invalid")
            @Max(value = Consts.MAX_PER_PAGE,
                    message = "errors.params.per_page.invalid")
            @RequestParam(name = "per_page", defaultValue = "10") int perPage,
            @Pattern(regexp = Consts.USERS_SORT_VALIDATE_REGEX,
                    message = "errors.params.order_by.invalid")
            @RequestParam(name = "order_by", required = false) String orderBy,
            @Pattern(regexp = Consts.REGEXP_FOR_ORDER,
                    message = "errors.params.order.invalid")
            @RequestParam(name = "order", required = false) String order) {

        // TODO: Any validations required?

        UsersListDto usersListDto = userService.getUsersListDto(oemId, page, perPage, orderBy, order);
        return new ResponseEntity<>(usersListDto, HttpStatus.OK);
    }
}
