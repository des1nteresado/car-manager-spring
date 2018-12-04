package com.des1nteresado.carmanager.dao;

import com.des1nteresado.carmanager.model.User;
import com.des1nteresado.carmanager.model.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoDaoImpl.class);

    private SessionFactory sessionFactory;

    @Override
    public void addUserInfo(UserInfo userInfo) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, userInfo.getUser().getId());
        userInfo.setUser(user);
        session.persist(userInfo);
        logger.info("UserInfo successfully saved. UserInfo details: " + userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, userInfo.getUser().getId());
        userInfo.setUser(user);
        session.update(userInfo);
        logger.info("UserInfo successfully update. UserInfo details: " + userInfo);
    }

    @Override
    public void removeUserInfo(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserInfo UserInfo = (UserInfo) session.load(UserInfo.class, id);
        UserInfo.setUser(null);
        if (UserInfo != null) {
            session.delete(UserInfo);
        }
        logger.info("UserInfo successfully removed. UserInfo details: " + UserInfo);
    }

    @Override
    public UserInfo getUserInfoById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserInfo userInfo = (UserInfo) session.load(UserInfo.class, id);
        logger.info("UserInfo successfully loaded. UserInfo details: " + userInfo);
        return userInfo;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<UserInfo> listUsersInfo() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserInfo> usersInfoList = session.createQuery("from UserInfo").list();

        for(UserInfo userInfo : usersInfoList) {
            logger.info("UserInfo list: " + userInfo);
        }
        return usersInfoList;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
