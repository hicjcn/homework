package com.demo.core.db.mapper;

import com.demo.core.db.entity.ClassStudentDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.core.db.entity.VO.ClassStudentVO;
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
public interface ClassStudentDOMapper extends BaseMapper<ClassStudentDO> {

    /**
     * 获取课程下的学生（状态）
     */
    List<ClassStudentVO> getClassStudentList(@Param("classId") Integer classId, @Param("status") Integer status);

}
