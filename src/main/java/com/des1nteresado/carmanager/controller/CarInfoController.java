package com.des1nteresado.carmanager.controller;

import com.des1nteresado.carmanager.model.CarInfo;
import com.des1nteresado.carmanager.service.CarInfoService.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarInfoController {
    private CarInfoService carInfoService;

    @Autowired(required = true)
    @Qualifier(value = "carInfoService")
    public void setCarInfoService(CarInfoService carInfoService) {
        this.carInfoService = carInfoService;
    }

    @RequestMapping(value = "cars-info", method = RequestMethod.GET)
    public String listCarsInfo(Model model) {
        model.addAttribute("carInfo", new CarInfo());
        model.addAttribute("listCarsInfo", this.carInfoService.listCarsInfo());

        return "cars-info";
    }

    @RequestMapping(value = "/cars-info/add", method = RequestMethod.POST)
    public String addCarInfo(@ModelAttribute("carInfo") CarInfo carInfo) {
        if (carInfo.getId() == 0) {
            carInfoService.addCarInfo(carInfo);
        } else {
            carInfoService.updateCarInfo(carInfo);
        }
        return "redirect:/cars-info";
    }

    @RequestMapping("/removeCarInfo/{id}")
    public String removeCarInfo(@PathVariable("id") int id) {
        carInfoService.removeCarInfo(id);

        return "redirect:/cars-info";
    }

    @RequestMapping("/editCarInfo/{id}")
    public String editCarInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("carInfo", carInfoService.getCarInfoById(id));
        model.addAttribute("listCarsInfo", carInfoService.listCarsInfo());

        return "cars-info";
    }


}
