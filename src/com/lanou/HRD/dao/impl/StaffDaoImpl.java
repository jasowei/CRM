package com.lanou.HRD.dao.impl;

import com.lanou.HRD.dao.StaffDao;
import com.lanou.HRD.domain.Staff;

/**
 * Created by dllo on 17/10/25.
 */
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {
    @Override
    public boolean login(String name, String pwd) {
        return false;
    }
}
