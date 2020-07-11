package com.demo.core.db.service;

import com.demo.core.db.entity.ClassDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
public interface IClassDao extends IService<ClassDO> {

    /**
     * 查看班级列表
     *
     * @param teacherCode
     * @return
     */
    List<ClassDO> getClassDOList(String teacherCode);

    /**
     * 创建班级
     */
    boolean createClass(ClassDO classDO);

}
