package com.des1nteresado.carmanager.controller;
import com.des1nteresado.carmanager.model.Car;
import com.des1nteresado.carmanager.service.CarService.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarController {
    private CarService carService;

    @Autowired(required = true)
    @Qualifier(value = "carService")
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String listCars(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("listCars", this.carService.listCars());

        return "cars";
    }

    @RequestMapping(value = "/cars/add", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("car") Car car) {
        if(car.getId() == 0) {
            carService.addCar(car);
        } else {
            carService.updateCar(car);
        }
        return "redirect:/cars";
    }

    @RequestMapping("/removeCar/{id}")
    public String removeCar(@PathVariable("id") int id) {
        carService.removeCar(id);

        return "redirect:/cars";
    }

    @RequestMapping("/editCar/{id}")
    public String editCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carService.getCarById(id));
        model.addAttribute("listCars", carService.listCars());

        return "cars";
    }

}