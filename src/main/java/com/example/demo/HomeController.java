package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("/")
    public String homepage()
    {
        return "homepage";
    }

    @RequestMapping("/list")
    public String listFlight(Model model){
        model.addAttribute("flights", flightRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String flightForm(Model model){
        model.addAttribute("flight", new Flight());
        return "flightForm";
    }

    @PostMapping("/process")
    public String processForm(@Valid Flight flight, BindingResult result)
    {
        if(result.hasErrors()){
            return "flightForm";
        }
        flightRepository.save(flight);
        return "redirect:/";
    }

    @RequestMapping("/detail/{flightNum}")
    public String showFlight(@PathVariable("flightNum") long flightNum, Model model)
    {
        model.addAttribute("flight", flightRepository.findById(flightNum).get());
        return "showFlight";
    }

    @RequestMapping("/update/{flightNum}")
    public String updateFlight(@PathVariable("flightNum") long flightNum, Model model){
        model.addAttribute("flight", flightRepository.findById(flightNum).get());
        return "flightForm";
    }

    @RequestMapping("/delete/{flightNum}")
    public String deleteFlight(@PathVariable("flightNum") long flightNum)
    {
        flightRepository.deleteById(flightNum);
        return "redirect:/";
    }

    @PostMapping("/searchFlight")
    public String search(Model model, @RequestParam("searchString") String search)
    {
        model.addAttribute("flights", flightRepository.findByArrivingAirportContainingIgnoreCaseOrDepartingAirportContainingIgnoreCaseOrDateDepartContainingIgnoreCaseOrPriceIsContainingIgnoreCase(search, search, search, search));
        return "searchFlight";
    }
}
