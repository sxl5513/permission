package com.anber.dao;

import com.anber.model.SysDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);

    int checkByNameAndParentId(@Param("deptName") String deptName, @Param("parentId") Integer parentId, @Param("id") Integer id);

    List<SysDept> getAllDept();
}