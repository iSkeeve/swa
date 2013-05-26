package com.bunich.swa.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bunich.swa.domain.Business;

@Repository
public class BusinessDAOImpl implements BusinessDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addBusiness(Business business) {
        sessionFactory.getCurrentSession().save(business);
    }

    @SuppressWarnings("unchecked")
    public List<Business> listBusinessByDate(Date businessDate, String userName) {
        String hql = "from com.bunich.swa.domain.Business B where B.businessDate = :business_date " +
                "and B.userName = :user_name ORDER BY B.businessDate desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("business_date", businessDate);
        query.setParameter("user_name", userName);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Business> listBusiness(String userName) {
        String hql = "from com.bunich.swa.domain.Business B where B.userName = :user_name ORDER BY B.businessDate desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("user_name", userName);
        return query.list();
    }

    public void removeBusiness(Integer id) {
        Business business = (Business) sessionFactory.getCurrentSession().load(
                Business.class, id);
        if (null != business) {
            sessionFactory.getCurrentSession().delete(business);
        }
    }
}
