package com.demo.stu.mapper;

import com.demo.stu.entity.StudentDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.stu.entity.vo.CourseScoreVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-02
 */
public interface StudentDOMapper extends BaseMapper<StudentDO> {

    /**
     * 根据学生获取课程成绩列表
     *
     * @param stuNo
     * @return
     */
    List<CourseScoreVO> getCourseScoresByStu(@Param("stuNo") String stuNo);
}
