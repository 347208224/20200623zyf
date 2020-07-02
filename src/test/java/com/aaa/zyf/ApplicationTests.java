package com.aaa.zyf;


import com.aaa.zyf.entity.Dept;
import com.aaa.zyf.service.DeptService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
public class ApplicationTests {
    @Autowired
    private DeptService deptService;
    @Test
    void contextLoads() {
        List<Dept> deptList = deptService.selectList(null);
        for (Dept dept : deptList) {
            System.out.println(dept.toString());
        }
    }
    @Test
    void saveDpet() {
        Dept dept = new Dept();
        dept.setDeptName("中情局");
        boolean insert = deptService.insert(dept);
        System.out.println(insert);
    }

    @Test
    void selectByCondition() {
        Wrapper wrapper = new EntityWrapper();
        wrapper.eq("dept_name","中情局" ).eq("order_num", 0);
        List<Dept> deptList = deptService.selectList(wrapper);
        for (Dept dept : deptList) {
            System.out.println(dept.toString());
        }
    }
}
