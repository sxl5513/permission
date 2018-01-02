package com.anber.dto;

import com.anber.model.SysDept;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
public class DeptLevelDto extends SysDept {

    private List<DeptLevelDto> dtoList = Lists.newArrayList();

    public static DeptLevelDto adapt(SysDept dept) {
        DeptLevelDto dto = new DeptLevelDto();
        BeanUtils.copyProperties(dept, dto); //将SysDept对象中的属性copy到DeptLevelDto
        return dto;
    }
}
