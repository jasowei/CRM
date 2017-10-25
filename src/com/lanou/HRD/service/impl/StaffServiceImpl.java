package com.lanou.HRD.service.impl;

import com.lanou.HRD.dao.StaffDao;
import com.lanou.HRD.service.StaffService;

/**
 * Created by dllo on 17/10/25.
 */
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    @Override
    public boolean login(String name, String pwd) {
        return staffDao.login(name,pwd);
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
