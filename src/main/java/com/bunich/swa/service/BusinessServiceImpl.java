package com.bunich.swa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bunich.swa.dao.BusinessDAO;
import com.bunich.swa.domain.Business;

@Repository
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessDAO businesstDAO;

    @Override
    @Transactional
    public void addBusiness(Business business) {
        businesstDAO.addBusiness(business);

    }

    @Override
    @Transactional
    public List<Business> listBusinessByDate(Date businessDate, String userName) {
        return businesstDAO.listBusinessByDate(businessDate, userName);
    }

    @Override
    @Transactional
    public List<Business> listBusiness(String userName) {
        return businesstDAO.listBusiness(userName);
    }

    @Override
    @Transactional
    public void removeBusiness(Integer id) {
        businesstDAO.removeBusiness(id);
    }

}
