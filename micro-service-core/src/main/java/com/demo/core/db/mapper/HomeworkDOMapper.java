package com.demo.core.db.mapper;

import com.demo.core.db.entity.HomeworkDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.core.db.entity.VO.HomeworkForStuVO;
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
     * @param classId
     * @return
     */
    List<HomeworkVO> getHomeworkList(@Param("teacherCode") String teacherCode, @Param("classId") Integer classId);

    /**
     * 查看作业列表(学生)
     *
     * @param studentCode
     * @param classId
     * @return
     */
    List<HomeworkForStuVO> getHomeworkListForStu(@Param("studentCode") String studentCode, @Param("classId") Integer classId);

}
