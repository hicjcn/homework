package com.demo.core.db.service;

import com.demo.core.db.entity.HomeworkStudentDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
public interface IHomeworkStudentDao extends IService<HomeworkStudentDO> {

    /**
     * 学生提交作业
     *
     * @param homeworkStudentDO
     * @param file
     */
    void submitHomework(HomeworkStudentDO homeworkStudentDO, MultipartFile file);

    /**
     *教师获取学生作业列表
     *
     * @param teacherCode
     * @param hId
     * @return
     */
    List<HomeworkStudentDO> getStudentHomeworkList(String teacherCode, Integer hId);

    /**
     * 打分
     *
     * @param teacherCode 
     * @param hsId
     * @param grade
     */
    void setHomeworkGrade(String teacherCode, Integer hsId, Float grade);

}
