package com.demo.core.db.service;

import com.demo.core.db.entity.ClassStudentDO;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * @param
     */
    void applyForClass(ClassStudentDO classStudentDO);

    /**
     * 修改审批状态
     */
    void changeStudentStatus(Integer id, Integer type);



}
