/** 
 * All rights Reserved, Designed By MiGu
 * Copyright(C)  2018
 * Company       MiGu  Co., Ltd.
 */
package com.demo.staff.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.staff.bean.Staff;
import com.demo.staff.dao.StaffDao;

/**
 * TODO〈一句话类描述〉
 * 项目名称:咪咕合管
 * 包名称:  com.demo.service
 * 类名称:  StaffService
 * 类描述:  TODO〈类详细描述〉
 * 创建人:  huliujie
 * 创建时间:2018年8月13日 下午4:37:19
 * 版本：   V1.0.0
*/
@Service
public class StaffService {

    @Autowired
    private StaffDao staffDao;

    public void saveStaff(Staff staff) {
        String userid = UUID.randomUUID().toString().replace("-", "");
        staff.setUserid(userid);
        staffDao.insert(staff);
    }

    public int deleteStaff(String userId) {
        return staffDao.delete(userId);
    }

    public void updateStaff(Staff staff) {
        staffDao.update(staff);
    }

    public Staff findStaff(Staff staff) {
        Staff result = staffDao.findStaff(staff);
        // 其他业务处理
        result.setAge(result.getAge() + 2);
        return result;
    }

}
