/** 
 * All rights Reserved, Designed By MiGu
 * Copyright(C)  2018
 * Company       MiGu  Co., Ltd.
 */
package com.demo.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.triology.versionname.VersionNames;

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
public class VersionController {

	private static final String VERSION_NAME = VersionNames.getVersionNameFromProperties();

    @RequestMapping(value = "/version")
    public String getVersion() {
        return VERSION_NAME;

    }

}
