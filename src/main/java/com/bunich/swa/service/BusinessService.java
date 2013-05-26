package com.bunich.swa.service;

import java.util.Date;
import java.util.List;

import com.bunich.swa.domain.Business;

public interface BusinessService {

    public void addBusiness(Business business);

    public List<Business> listBusinessByDate(Date businessDate, String userName);

    public List<Business> listBusiness(String userName);

    public void removeBusiness(Integer id);

}
