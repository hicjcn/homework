package com.demo.core.db.service;

import com.demo.core.db.entity.HomeworkDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.core.db.entity.VO.HomeworkForStuVO;
import com.demo.core.db.entity.VO.HomeworkVO;
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
public interface IHomeworkDao extends IService<HomeworkDO> {

    /**
     * 发布作业
     *
     * @param homeworkDO
     * @param file
     */
    void releaseHomework(HomeworkDO homeworkDO, MultipartFile file);

    /**
     * 查看作业列表
     *
     * @param teacherCode
     * @param classId
     * @return
     */
    List<HomeworkVO> getHomeworkList(String teacherCode, Integer classId);

    /**
     * 查看作业列表（学生）
     *
     * @param studentCode
     * @param classId
     * @return
     */
    List<HomeworkForStuVO> getHomeworkListForStu(String studentCode, Integer classId);

}
