package com.des1nteresado.carmanager.dao;

import com.des1nteresado.carmanager.model.UserInfo;

import java.util.List;

public interface UserInfoDao {
    void addUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    void removeUserInfo(int id);

    UserInfo getUserInfoById(int id);

    List<UserInfo> listUsersInfo();
}
