package com.lanou.HRD.dao.impl;

import com.lanou.HRD.dao.StaffDao;
import com.lanou.HRD.domain.Staff;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {
    @Override
    public boolean login(String name, String pwd) {
        String hql ="from Staff where loginName =na and loginPwd =psw";
        Map<String,Object> params = new HashMap();
        params.put("na",name);
        params.put("psw",pwd);

        return find(hql,params).size()>0;
    }
}
