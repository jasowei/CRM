package com.lanou.hrd.dao;

import com.lanou.hrd.domain.Staff;

/**
 * Created by dllo on 17/10/25.
 */
public interface StaffDao extends BaseDao<Staff> {

    boolean login(String name,String pwd);

}
