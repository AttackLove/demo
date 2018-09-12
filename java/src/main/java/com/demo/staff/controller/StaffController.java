/** 
 * All rights Reserved, Designed By MiGu
 * Copyright(C)  2018
 * Company       MiGu  Co., Ltd.
 */
package com.demo.staff.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.common.CommonResponse;
import com.demo.common.Result;
import com.demo.staff.bean.Staff;
import com.demo.staff.bean.StaffInfoResp;
import com.demo.staff.service.StaffService;

/**
 * TODO〈一句话类描述〉
 * 项目名称:咪咕合管
 * 包名称:  com.demo.controller
 * 类名称:  StaffController
 * 类描述:  TODO〈类详细描述〉
 * 创建人:  huliujie
 * 创建时间:2018年8月13日 下午4:42:15
 * 版本：   V1.0.0
*/
@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/staff/add", method = RequestMethod.POST)
    public CommonResponse addStaff(@RequestBody @Valid Staff staff) {
        CommonResponse resp = new CommonResponse();
        if (staff.getAge() <= 0) {
            resp.setResult(Result.error("年龄必须大于0"));
            return resp;
        }
        staffService.saveStaff(staff);

        return resp;

    }

    @RequestMapping(value = "/staff/delete", method = RequestMethod.GET)
    public CommonResponse deleteStaff(@RequestParam String userid) {
        int count = staffService.deleteStaff(userid);
        CommonResponse resp = new CommonResponse();
        resp.setData(count);
        return resp;
    }

    @RequestMapping(value = "/staff/update", method = RequestMethod.POST)
    public CommonResponse updateStaff(@RequestBody @Valid Staff staff) {
        staffService.updateStaff(staff);
        CommonResponse resp = new CommonResponse();
        return resp;
    }

    @RequestMapping(value = "/staff/find", method = RequestMethod.POST)
    public StaffInfoResp findStaff(@RequestBody Staff staff) {
        Staff result = staffService.findStaff(staff);
        StaffInfoResp resp = new StaffInfoResp();
        resp.setData(result);
        return resp;
    }

}
