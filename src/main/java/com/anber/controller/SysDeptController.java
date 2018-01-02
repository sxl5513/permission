package com.anber.controller;

import com.anber.common.JsonData;
import com.anber.dto.DeptLevelDto;
import com.anber.param.DeptParam;
import com.anber.service.ISysDeptService;
import com.anber.service.ISysTreeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sys/dept")
public class SysDeptController {

    @Resource
    private ISysDeptService iSysDeptService;
    @Resource
    private ISysTreeService iSysTreeService;

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveDept(DeptParam deptParam) {
        iSysDeptService.save(deptParam);
        return JsonData.success();
    }

    @RequestMapping("/tree.json")
    @ResponseBody
    public JsonData tree() {
        List<DeptLevelDto> dtoList = iSysTreeService.deptTree();
        return JsonData.success(dtoList);
    }
}
