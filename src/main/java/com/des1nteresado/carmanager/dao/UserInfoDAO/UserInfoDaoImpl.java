package com.des1nteresado.carmanager.dao.UserInfoDAO;

import com.des1nteresado.carmanager.model.User;
import com.des1nteresado.carmanager.model.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    private SessionFactory sessionFactory;

    @Override
    public void addUserInfo(UserInfo userInfo) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, userInfo.getUser().getId());
        userInfo.setUser(user);
        session.persist(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, userInfo.getUser().getId());
        userInfo.setUser(user);
        session.update(userInfo);
    }

    @Override
    public void removeUserInfo(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserInfo UserInfo = (UserInfo) session.load(UserInfo.class, id);
        UserInfo.setUser(null);
        if (UserInfo != null) {
            session.delete(UserInfo);
        }
    }

    @Override
    public UserInfo getUserInfoById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserInfo userInfo = (UserInfo) session.load(UserInfo.class, id);
        return userInfo;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<UserInfo> listUsersInfo() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserInfo> usersInfoList = session.createQuery("from UserInfo").list();
        return usersInfoList;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
