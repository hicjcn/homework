package com.demo.core.db.entity.VO;

import com.demo.core.db.entity.HomeworkDO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class HomeworkVO extends HomeworkDO {

    /**
     * 班级名称
     */
    private Integer className;

}
