package com.demo.core.db.entity.VO;

import com.demo.core.db.entity.HomeworkDO;
import lombok.Data;

@Data
public class HomeworkVO extends HomeworkDO {

    /**
     * 班级名称
     */
    private Integer className;

}
