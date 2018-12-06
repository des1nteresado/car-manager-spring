package com.des1nteresado.carmanager.service.UserInfoService;

import com.des1nteresado.carmanager.dao.UserInfoDAO.UserInfoDao;
import com.des1nteresado.carmanager.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao;

    @Override
    @Transactional
    public void addUserInfo(UserInfo userInfo) {
        userInfoDao.addUserInfo(userInfo);
    }

    @Override
    @Transactional
    public void updateUserInfo(UserInfo userInfo) {
        userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    @Transactional
    public void removeUserInfo(int id) {
        userInfoDao.removeUserInfo(id);
    }

    @Override
    @Transactional
    public UserInfo getUserInfoById(int id) {
        return userInfoDao.getUserInfoById(id);
    }

    @Override
    @Transactional
    public List<UserInfo> listUsersInfo() {
        return userInfoDao.listUsersInfo();
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }
}
