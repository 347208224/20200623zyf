package com.aaa.zyf.controller;


import com.aaa.zyf.entity.Dept;
import com.aaa.zyf.entity.LayuiTable;
import com.aaa.zyf.service.DeptService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author zyf
 * @since 2020-06-23
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("toShowAllDeptPage")
    public String toShowAllDeptPage(Model model){
        List<Dept> deptList = deptService.selectList(null);
        model.addAttribute("username","zyf");
        model.addAttribute("deptList",deptList);
        return "dept/showAllDept";
    }

    @RequestMapping("/selectAllDeptAjax")
    @ResponseBody
    public LayuiTable selectAllDeptAjax(Integer page, Integer limit){
        LayuiTable layuiTable =new LayuiTable();
        Page myPage =new Page(page,limit);
        Page selectPage = deptService.selectPage(myPage,null);
        List records = selectPage.getRecords();
        layuiTable.setCode(0);
        layuiTable.setMsg("操作成功");
        int count = deptService.selectCount(null);
        layuiTable.setCount(count);
        layuiTable.setData(records);
        return layuiTable;


    }
}

