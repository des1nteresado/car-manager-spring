package com.des1nteresado.carmanager.service.UserInfoService;

import com.des1nteresado.carmanager.model.User;
import com.des1nteresado.carmanager.model.UserInfo;

import java.util.List;

public interface UserInfoService {
    void addUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    void removeUserInfo(int id);

    UserInfo getUserInfoById(int id);

    List<UserInfo> listUsersInfo();
}
