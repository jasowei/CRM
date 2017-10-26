package com.lanou.hrd.service;

import com.lanou.hrd.domain.Staff;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public interface StaffService {

    boolean login(String name,String pwd);

    void addStaff(Staff staff);

    List<Staff> findAllStaff();

    List<Staff> findStaff(Staff staff, String depId, String postID);

    Staff findById(Serializable id, Class<Staff> tClass);

    void updateStaff(Staff staff);
}
