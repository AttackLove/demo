/** 
 * All rights Reserved, Designed By MiGu
 * Copyright(C)  2018
 * Company       MiGu  Co., Ltd.
 */
package com.demo.staff.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.demo.DemoStart;
import com.demo.common.CommonResponse;
import com.demo.staff.bean.Staff;
import com.demo.staff.bean.StaffInfoResp;

/**
 * 集成测试，会生成真实数据 ，在内存数据库h2
 * 项目名称:咪咕合管
 * 包名称:  com.demo.controller
 * 类名称:  StaffControllerIntegrationTest
 * 创建人:  huliujie
 * 创建时间:2018年8月15日 下午3:00:32
 * 版本：   V1.0.0
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoStart.class)
public class StaffControllerIT {

    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext webApplicationConnect;

    @Before // 在测试开始前初始化工作
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationConnect).build();
    }

    // @Test
    // @Transactional
    // @Rollback(true) // 回滚数据
    public void testAdd() throws Exception {
        Staff staff = new Staff();
        staff.setUsername("牛哥");
        staff.setAge(18);
        String requestBody = JSONObject.toJSONString(staff);
        MvcResult result = mockMvc
                .perform(post("/staff/add").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isOk()).andReturn();
        // result.getResponse() 获取response对象，可以对获取的对象结果进行assert判断
        CommonResponse resp = JSONObject.parseObject(result.getResponse().getContentAsString(), CommonResponse.class);
        // 断言结果是否达到预期值
        // System.out.println("add结果==" + result.getResponse().getContentAsString());
        assertEquals("1", resp.getResult().getResultCode());

    }

    // @Test
    public void testUpdate() throws Exception {
        Staff staff = new Staff();
        staff.setUserid("1");
        staff.setUsername("牛哥");
        String requestBody = JSONObject.toJSONString(staff);
        MvcResult result = mockMvc
                .perform(post("/staff/update").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isOk()).andReturn();
        CommonResponse resp = JSONObject.parseObject(result.getResponse().getContentAsString(), CommonResponse.class);
        // System.out.println("update结果==" + result.getResponse().getContentAsString());
        assertEquals("1", resp.getResult().getResultCode());
    }

    /**
     * 删除的的数据是test/resources/test.sql 预制的测试数据
     * @throws Exception
     * @return void
     * @throws  [违例类型] [违例说明]
     */
    @Test
    public void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(get("/staff/delete").param("userid", "2")).andExpect(status().isOk())
                .andReturn();
        // System.out.println("delete结果==" + result.getResponse().getContentAsString());
        CommonResponse resp = JSONObject.parseObject(result.getResponse().getContentAsString(), CommonResponse.class);
        assertEquals("1", resp.getResult().getResultCode());
        assertEquals(1, resp.getData());
    }

    /**
     * 查询的的数据是test/resources/test.sql 预制的测试数据
     * @throws Exception
     * @return void
     * @throws  [违例类型] [违例说明]
     */
    // @Test
    public void testFind() throws Exception {
        Staff staff = new Staff();
        staff.setUserid("1");
        String requestBody = JSONObject.toJSONString(staff);
        MvcResult result = mockMvc
                .perform(post("/staff/find").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isOk()).andReturn();
        StaffInfoResp resp = JSONObject.parseObject(result.getResponse().getContentAsString(), StaffInfoResp.class);
        // System.out.println("find结果==" + result.getResponse().getContentAsString());
        assertEquals("1", resp.getResult().getResultCode());
        assertEquals("牛哥", resp.getData().getUsername());
        assertEquals(20, resp.getData().getAge());

    }
}
