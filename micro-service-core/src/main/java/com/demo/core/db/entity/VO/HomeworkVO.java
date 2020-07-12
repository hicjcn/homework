package com.demo.core.db.entity.VO;

import com.demo.core.db.entity.HomeworkDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HomeworkVO extends HomeworkDO {

    /**
     * 班级名称
     */
    private Integer className;

}
