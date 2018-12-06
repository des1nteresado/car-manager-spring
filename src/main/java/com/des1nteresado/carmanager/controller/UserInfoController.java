package com.des1nteresado.carmanager.controller;

import com.des1nteresado.carmanager.model.UserInfo;
import com.des1nteresado.carmanager.service.UserInfoService.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserInfoController {
    private UserInfoService userInfoService;

    @Autowired(required = true)
    @Qualifier(value = "userInfoService")
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @RequestMapping(value = "users-info", method = RequestMethod.GET)
    public String listUsersInfo(Model model) {
        model.addAttribute("userInfo", new UserInfo());
        model.addAttribute("listUsersInfo", this.userInfoService.listUsersInfo());

        return "users-info";
    }

    @RequestMapping(value = "/users-info/add", method = RequestMethod.POST)
    public String addUserInfo(@ModelAttribute("userInfo") UserInfo userInfo) {
        if (userInfo.getId() == 0) {
            userInfoService.addUserInfo(userInfo);
        } else {
            userInfoService.updateUserInfo(userInfo);
        }
        return "redirect:/users-info";
    }

    @RequestMapping("/removeUserInfo/{id}")
    public String removeUserInfo(@PathVariable("id") int id) {
        userInfoService.removeUserInfo(id);
        return "redirect:/users-info";
    }

    @RequestMapping("/editUserInfo/{id}")
    public String editUserInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("userInfo", userInfoService.getUserInfoById(id));
        model.addAttribute("listUsersInfo", userInfoService.listUsersInfo());

        return "users-info";
    }

}
