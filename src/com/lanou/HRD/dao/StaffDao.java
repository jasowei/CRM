package com.lanou.HRD.dao;

import com.lanou.HRD.domain.Staff;

/**
 * Created by dllo on 17/10/25.
 */
public interface StaffDao extends BaseDao<Staff> {

    boolean login(String name,String pwd);

}
