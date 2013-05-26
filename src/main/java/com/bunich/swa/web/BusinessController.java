package com.bunich.swa.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bunich.swa.domain.Business;
import com.bunich.swa.service.BusinessService;

@Controller
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @RequestMapping("/index")
    public String listBusiness(ModelMap map) {

        map.put("business", new Business());
        map.put("businessList", businessService.listBusiness(getUserName()));

        return "business";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String listBusinessByDate(Map<String, Object> map, @RequestParam("businessDate") String businessDate) {
        if (convertStringToDate(businessDate) == null) {
            return "redirect:/index";
        }
        map.put("businessByDate", new Business());
        map.put("businessByDateList", businessService.listBusinessByDate(convertStringToDate(businessDate), getUserName()));

        return "businessByDate";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBusiness(@RequestParam("businessDate") String date, @RequestParam("description") String description) {
        if (convertStringToDate(date) == null) {
            return "redirect:/index";
        }
        Business business = new Business();
        business.setUserName(getUserName());
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        business.setBusinessDate(convertStringToDate(date));


        business.setDescription(description);

        businessService.addBusiness(business);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{businessId}")
    public String deleteBusiness(@PathVariable("businessId") Integer businessId) {

        businessService.removeBusiness(businessId);

        return "redirect:/index";
    }

    private String getUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        return userDetails.getUsername();


    }

    private Date convertStringToDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
