package com.ant.ttf.domain.users.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.ant.ttf.domain.users.dto.response.UserDashboardInfoDTO;
import com.ant.ttf.domain.users.entity.Users;

@Mapper
public interface UsersMapper {
	Optional<Users> findUserByUserEmail(String email);
    Optional<Users> findByUserId(Long userId);
    Users findUserInfoByPk(String userPk);
}
