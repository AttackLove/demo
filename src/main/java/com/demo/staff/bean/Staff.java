/** 
 * All rights Reserved, Designed By MiGu
 * Copyright(C)  2018
 * Company       MiGu  Co., Ltd.
 */
package com.demo.staff.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * TODO〈一句话类描述〉
 * 项目名称:咪咕合管
 * 包名称:  com.demo.bean
 * 类名称:  Stuff
 * 类描述:  TODO〈类详细描述〉
 * 创建人:  huliujie
 * 创建时间:2018年8月13日 下午4:12:32
 * 版本：   V1.0.0
*/
// 编译环节自动get,set方法
@Data
public class Staff {

    String userid;
    @NotNull
    String username;
    int age;
    Date createTime;
}
