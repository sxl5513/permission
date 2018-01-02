package com.anber.service.impl;

import com.anber.dao.SysDeptMapper;
import com.anber.exception.ParamException;
import com.anber.model.SysDept;
import com.anber.param.DeptParam;
import com.anber.service.ISysDeptService;
import com.anber.util.BeanValidator;
import com.anber.util.LevelUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("iSysDeptService")
public class SysDeptServiceImpl implements ISysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;



    public void save(DeptParam deptParam) {
        //校验参数
        BeanValidator.check(deptParam);
        //在同一层级下不能存在相同名称的部门
        if (checkExsit(deptParam.getParentId(), deptParam.getName(), deptParam.getId())) {
            throw new ParamException("同一层级下存在相同名称的部门");
        }
        SysDept sysDept = SysDept.builder().name(deptParam.getName()).parentId(deptParam.getParentId()).seq(deptParam.getSeq())
                .remark(deptParam.getRemark()).build();

        sysDept.setLevel(LevelUtil.calculateLevel(getLevel(deptParam.getParentId()), deptParam.getParentId()));
        sysDept.setOperator("system"); //TODO:
        sysDept.setOperateIp("127.0.0.1"); //TODO:
        sysDept.setOperateTime(new Date());

        sysDeptMapper.insertSelective(sysDept);
    }

    private boolean checkExsit(Integer parentId, String deptName, Integer deptId) {
        return sysDeptMapper.checkByNameAndParentId(deptName, parentId, deptId) > 0;
    }

    private String getLevel(Integer deptId) {
        SysDept sysDept = sysDeptMapper.selectByPrimaryKey(deptId);
        if (sysDept == null) {
            return null;
        }
        return sysDept.getLevel();
    }

}
