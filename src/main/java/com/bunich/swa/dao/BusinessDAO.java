package com.bunich.swa.dao;

import java.util.Date;
import java.util.List;

import com.bunich.swa.domain.Business;

public interface BusinessDAO {

    public void addBusiness(Business business);

    public List<Business> listBusinessByDate(Date businessDate, String userName);

    public List<Business> listBusiness(String userName);

    public void removeBusiness(Integer id);

}
