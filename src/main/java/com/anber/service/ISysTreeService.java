package com.anber.service;

import com.anber.dto.DeptLevelDto;

import java.util.List;

public interface ISysTreeService {

    /**
     * 获取部门树
     * @return 返回部门树
     */
    List<DeptLevelDto> deptTree();
}
