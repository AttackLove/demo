/** 
 * All rights Reserved, Designed By MiGu
 * Copyright(C)  2018
 * Company       MiGu  Co., Ltd.
 */
package com.demo.staff.dao;

import org.apache.ibatis.annotations.Mapper;

import com.demo.staff.bean.Staff;

/**
 * TODO〈一句话类描述〉
 * 项目名称:咪咕合管
 * 包名称:  com.demo.dao
 * 类名称:  StuffDao
 * 类描述:  TODO〈类详细描述〉
 * 创建人:  huliujie
 * 创建时间:2018年8月13日 下午4:24:10
 * 版本：   V1.0.0
*/
@Mapper
public interface StaffDao {

    void insert(Staff staff);

    int delete(String usersid);

    void update(Staff staff);

    Staff findStaff(Staff staff);

}
