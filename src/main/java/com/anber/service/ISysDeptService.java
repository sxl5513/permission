package com.anber.service;

import com.anber.param.DeptParam;

public interface ISysDeptService {

    /**
     * 添加部门信息
     * @param deptParam 待部门信息的参数对象
     */
    void save(DeptParam deptParam);
}
