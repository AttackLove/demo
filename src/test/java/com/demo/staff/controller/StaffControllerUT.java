/** 
 * All rights Reserved, Designed By MiGu
 * Copyright(C)  2018
 * Company       MiGu  Co., Ltd.
 */
package com.demo.staff.controller;

import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.alibaba.fastjson.JSONObject;
import com.demo.staff.bean.Staff;
import com.demo.staff.service.StaffService;

/**
 *单元测试，不生成真实数据
 * 项目名称:咪咕合管
 * 包名称:  com.demo.controller
 * 类名称:  StaffControllerTest
 * 类描述:  TODO〈类详细描述〉
 * 创建人:  huliujie
 * 创建时间:2018年8月14日 下午2:03:34
 * 版本：   V1.0.0
*/
// @RunWith(SpringRunner.class)
// @WebMvcTest(StaffController.class)
// 注解方式上下两种都可以，具体的测试案例不受影响 ，不会真实启动servlet环境
// @RunWith(SpringRunner.class)
// @SpringBootTest(classes = DemoStart.class)
// @AutoConfigureMockMvc
public class StaffControllerUT {

    @Autowired
    private MockMvc mockMvc;

    // StaffController依赖于staffService， 如果未Mock ，会真实调用service,生成数据
    @MockBean
    private StaffService staffService;

    // 作用是伪造一个mvc的环境
    //
    // 其方法使用:
    //
    // perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
    // get:声明发送一个get请求的方法。MockHttpServletRequestBuilder get(String urlTemplate, Object...
    // urlVariables)：根据uri模板和uri变量值得到一个GET请求方式的。另外提供了其他的请求的方法，如：post、put、delete等。
    // param：添加request的参数，如上面发送请求的时候带上了了pcode = root的参数。假如使用需要发送json数据格式的时将不能使用这种方式，可见后面被@ResponseBody注解参数的解决方法
    // andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确（对返回的数据进行的判断）；
    // andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台（对返回的数据进行的判断）；
    // andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理（对返回的数据进行的判断）
   // @Test
    public void testAdd() throws Exception {
        Staff staff = new Staff();
        staff.setUsername("牛哥");
        staff.setAge(18);
        String requestBody = JSONObject.toJSONString(staff);
        MvcResult result = mockMvc
                .perform(post("/staff/add").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isOk()).andReturn();
        // result.getResponse() 获取response对象，可以对获取的对象结果进行assert判断
        System.out.println("add结果==" + result.getResponse().getContentAsString());
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
        System.out.println("update结果==" + result.getResponse().getContentAsString());
    }

    // @Test
    public void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(get("/staff/delete").param("userId", "1")).andExpect(status().isOk())
                .andReturn();
        System.out.println("delete结果==" + result.getResponse().getContentAsString());

    }

    // @Test
    public void testFind() throws Exception {
        Staff staff = new Staff();
        staff.setUserid("1");
        staff.setUsername("牛哥");
        String requestBody = JSONObject.toJSONString(staff);
        // 设置当调用外部方法获得的期望值,传入的参数可以指定，可以使用match匹配
        // any() 代表可为任意对象和 null,类似的还有anyString,anyInt,anyset....
        Mockito.when(staffService.findStaff(any())).thenReturn(staff);
        MvcResult result = mockMvc
                .perform(post("/staff/find").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isOk()).andReturn();
        System.out.println("find结果==" + result.getResponse().getContentAsString());
    }
}
