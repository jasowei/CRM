package com.lanou.HRD.action;

import com.lanou.HRD.domain.Staff;
import com.lanou.HRD.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by dllo on 17/10/25.
 */
public class StaffAction extends ActionSupport implements ModelDriven<Staff>{

    private Staff staff;

    @Autowired
    @Qualifier("staffService")
    private StaffService staffService;

    /**
     * 登录
     * @return
     */
    public String login(){
//        if (staffService.login(staff.getLoginName(),staff.getLoginPwd())){
//            return SUCCESS;
//        }
//        addActionError("用户名或密码错误!");
        return SUCCESS;

    }

    /**
     * 针对登录验证
     */
    public void validateLogin() {
        if (StringUtils.isBlank(staff.getLoginName()) || StringUtils.isBlank(staff.getLoginPwd())){
            addActionError("用户名或密码不能为空,请填写!");
        }
    }

    @Override
    public Staff getModel() {
        staff = new Staff();
        return staff;
    }


    /**
     * get/set方法
     * @return
     */
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
