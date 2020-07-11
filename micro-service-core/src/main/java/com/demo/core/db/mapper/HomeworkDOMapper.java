package com.demo.core.db.mapper;

import com.demo.core.db.entity.HomeworkDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.core.db.entity.VO.HomeworkVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
public interface HomeworkDOMapper extends BaseMapper<HomeworkDO> {

    /**
     * 查看作业列表
     *
     * @param teacherCode
     * @param className
     * @return
     */
    List<HomeworkVO> getHomeworkList(@Param("teacherCode") String teacherCode, @Param("className") String className);

}
