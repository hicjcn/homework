package com.demo.core.db.service;

import com.demo.core.db.entity.ClassStudentDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.core.db.entity.VO.ClassStudentVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
public interface IClassStudentDao extends IService<ClassStudentDO> {

    /**
     * 申请加入课程
     *
     * @param classStudentDO
     */
    void applyForClass(ClassStudentDO classStudentDO);

    /**
     * 修改审批状态
     *
     * @param id
     * @param type
     */
    void changeStudentStatus(Integer id, Integer type);

    /**
     * 查看班级学生
     *
     * @param teacherCode
     * @param classId
     * @param type
     * @return
     */
    List<ClassStudentVO> getClassStudentList(String teacherCode, Integer classId, Integer type);

}
