package com.ayla.user.service;

import com.ayla.user.dto.UsersListDto;
import com.ayla.user.util.QueryUtil;
import com.ayla.user.model.User;
import com.ayla.user.repository.UserRepository;
import com.ayla.user.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UsersListDto getUsersListDto(int oemId, int page, int perPage, String orderBy, String order) {
        page = page <= 0 ? 0 : page - 1;
        perPage = (perPage <= 0 || perPage > Consts.MAX_PER_PAGE) ? Consts.DEFAULT_PER_PAGE : perPage;

        Pageable pageable = PageRequest.of(
                page, perPage, QueryUtil.handleSort(orderBy == null ? "id" : orderBy, order));
        List<User> pageUsers = userRepository.findUsersByOemId(oemId, pageable);

        // TODO: Fetch total count of users
         int total = 0; // userRepository.queryUsersCount(oemId);
        return new UsersListDto(pageUsers, total, page + 1, perPage);
    }
}
