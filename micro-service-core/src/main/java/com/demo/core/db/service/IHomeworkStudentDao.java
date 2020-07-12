package com.demo.core.db.service;

import com.demo.core.db.entity.HomeworkStudentDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

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
     */
    void submitHomework(HomeworkStudentDO homeworkStudentDO, MultipartFile file);

}
