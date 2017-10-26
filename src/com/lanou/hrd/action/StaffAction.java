package com.lanou.hrd.action;

import com.lanou.hrd.domain.Department;
import com.lanou.hrd.domain.Post;
import com.lanou.hrd.domain.Staff;
import com.lanou.hrd.service.DepartmentService;
import com.lanou.hrd.service.PostService;
import com.lanou.hrd.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

/**
 * Created by dllo on 17/10/25.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {

    private Staff staff;
    private String postID;
    private String depId;

    @Autowired
    @Qualifier("staffService")
    private StaffService staffService;
    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;
    @Autowired
    @Qualifier("postService")
    private PostService postService;


    private List<Department> departments;//查到的部门集合
    private String departid;//部门id,用来查找对应职务
    private Set<Post> posts;//根据部门id查到的职务集合
    private List<Staff> staffs;//查询到的所有员工
    private Staff staff1;

    /**
     * 登录
     *
     * @return
     */
    public String login() {
        if (staffService.login(staff.getLoginName(), staff.getLoginPwd())) {
            return SUCCESS;
        } else {
            addActionError("用户名或密码错误!");
            return INPUT;
        }

    }

    /**
     * 针对登录验证
     */
    public void validateLogin() {
        if (StringUtils.isBlank(staff.getLoginName()) || StringUtils.isBlank(staff.getLoginPwd())) {
            addActionError("用户名或密码不能为空,请填写!");
        }
    }

    /**
     * 添加员工
     *
     * @return
     */
    public String addStaff() {
        if (StringUtils.isBlank(staff.getLoginName()) || StringUtils.isBlank(staff.getLoginPwd())
                || staff.getOnDutyDate() == null || StringUtils.isBlank(staff.getStaffName())
                || StringUtils.isBlank(staff.getGender()) || postID.equals("-1")) {
            addActionError("请填写完整信息!");
            return INPUT;
        }
        Post post1 = postService.findById(postID);
        staff.setPost(post1);
        staffService.addStaff(staff);
        return SUCCESS;
    }

    /**
     * 编辑员工
     */
    public String editStaff() {
        staff1 = staffService.findById(staff.getStaffId(), Staff.class);
        departments = departmentService.findAllDept();
        System.out.println("要编辑的员工 : " + staff1);

        return SUCCESS;
    }

    public String updateStaff() {
        if (StringUtils.isBlank(staff.getLoginName()) || StringUtils.isBlank(staff.getLoginPwd())
                || staff.getOnDutyDate() == null || StringUtils.isBlank(staff.getStaffName())
                || StringUtils.isBlank(staff.getGender()) || postID.equals("-1")) {
            addActionError("请填写完整信息!");
            return INPUT;
        }
        System.out.println("要编辑员工id"+staff.getStaffId());
        Post post1 = postService.findById(postID);
        staff.setPost(post1);
        System.out.println("修改后员工 : "+staff);
        staffService.updateStaff(staff);
        return SUCCESS;
    }


    /**
     * 查询所有部门
     *
     * @return
     */
    public String findAllDept() {
        departments = departmentService.findAllDept();
        System.out.println("depts : " + departments);
        return SUCCESS;
    }

    /**
     * 根据部门id查职务
     *
     * @return
     */
    public String findPostByDeptId() {
        Department department1 = departmentService.findById(departid);
        posts = department1.getPosts();
        System.out.println("posts : " + posts);
        return SUCCESS;
    }


    /**
     * 条件查询
     * 显示所有员工
     *
     * @return
     */
    public String listStaff() {

        staffs = staffService.findAllStaff();
        System.out.println("所有员工 : " + staffs);
        return SUCCESS;
    }

    public String queryStaff() {
        staffs = staffService.findStaff(staff, depId, postID);
        return SUCCESS;
    }


    @Override
    public Staff getModel() {
        staff = new Staff();
        return staff;
    }


    /**
     * get/set方法
     *
     * @return
     */


    public String getPostID() {
        return postID;
    }


    public void setPostID(String postID) {
        this.postID = postID;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getDepartid() {
        return departid;
    }

    public void setDepartid(String departid) {
        this.departid = departid;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {

        this.staff = staff;
    }


    public Staff getStaff1() {
        return staff1;
    }

    public void setStaff1(Staff staff1) {
        this.staff1 = staff1;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }
}
