/** 
 * All rights Reserved, Designed By MiGu
 * Copyright(C)  2018
 * Company       MiGu  Co., Ltd.
 */
package com.demo.staff.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.staff.bean.Staff;
import com.demo.staff.dao.StaffDao;

/**
 * TODO〈一句话类描述〉
 * 项目名称:咪咕合管
 * 包名称:  com.demo.service
 * 类名称:  StaffServiceMockTest
 * 类描述:  TODO〈类详细描述〉
 * 创建人:  huliujie
 * 创建时间:2018年8月15日 下午2:12:51
 * 版本：   V1.0.0
*/
// mock测试速度快，只验证方法本身的逻辑，对其依赖的方法不做测试
@RunWith(SpringJUnit4ClassRunner.class)
public class StaffServiceUT {

    @InjectMocks
    private StaffService staffService;

    @Mock
    private StaffDao staffDao;

    @Test
    public void testInsert() {
        // void的方法设置nothing结果
        doNothing().when(staffDao).insert(any());
        Staff staff = new Staff();
        staff.setUserid("1");
        staff.setUsername("abc");
        staff.setAge(18);
        staffService.saveStaff(staff);
        // 验证是否staffDao的insert方法是否被staffService调用了一次,且只有一次
        verify(staffDao).insert(any());
    }

    @Test
    public void testUpdate() {
        // void的方法设置nothing结果
        doNothing().when(staffDao).update(any());
        Staff staff = new Staff();
        staff.setUserid("1");
        staff.setUsername("abc");
        staff.setAge(22);
        staffService.updateStaff(staff);
        // 验证是否staffDao的insert方法是否被staffService调用了一次,且只有一次
        verify(staffDao).update(any());
    }

    @Test
    public void tesDelete() {
        // void的方法设置nothing结果
        Mockito.when(staffDao.delete(any())).thenReturn(1);
        int count = staffService.deleteStaff("1");
        // 验证是否staffDao的insert方法是否被staffService调用了一次,且只有一次
        verify(staffDao).delete(any());
        assertEquals(1, count);
    }

    @Test
    public void testFind() {
        Staff staff = new Staff();
        staff.setUserid("1");
        staff.setUsername("abc");
        staff.setAge(18);
        // 设置预期调用其他方法返回结果，只验证被验证方法的逻辑
        Mockito.when(staffDao.findStaff(any())).thenReturn(staff);
        Staff result = staffService.findStaff(staff);
        // 判断业务逻辑处理完后，结果是否符合预期值
        assertEquals(20, result.getAge()); // 断言是否相等
        assertNotNull(result.getUsername());// 断言不能为空，为空报错
        // assertNull(result.getUsername());//判断为空，不为空报错
        // 判断实际代码是否调用了dao的find方法一次
        verify(staffDao).findStaff(any());
    }
}
