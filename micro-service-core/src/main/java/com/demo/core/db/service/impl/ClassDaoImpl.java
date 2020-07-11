package com.demo.core.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.core.db.entity.ClassDO;
import com.demo.core.db.mapper.ClassDOMapper;
import com.demo.core.db.service.IClassDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
@Service
public class ClassDaoImpl extends ServiceImpl<ClassDOMapper, ClassDO> implements IClassDao {

    @Override
    public List<ClassDO> getClassDOList(Map<String, String> params) {
        String teacherCode = params.get("teacherCode");
        String className = params.get("className");
        return this.baseMapper.selectList(
                new QueryWrapper<ClassDO>()
                        .eq("teacher_code", teacherCode)
                        .like(StringUtils.isNotBlank(className), "class_name", className)
        );
    }

    @Override
    public boolean createClass(ClassDO classDO) {
        return this.save(classDO);
    }
}
