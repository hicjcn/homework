package com.demo.core.db.service;

import com.demo.core.db.entity.HomeworkDO;
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
public interface IHomeworkDao extends IService<HomeworkDO> {

    /**
     * 发布作业
     */
    void releaseHomework(HomeworkDO homeworkDO, MultipartFile file);

}
