package com.demo.core.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.core.db.entity.ClassDO;
import com.demo.core.db.entity.UserDO;
import com.demo.core.db.mapper.ClassDOMapper;
import com.demo.core.db.service.IClassDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.core.db.service.IUserDao;
import com.demo.core.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
    private IUserDao iUserDao;

    @Override
    public List<ClassDO> getClassDOList(String teacherCode) {
        return this.baseMapper.selectList(
                new QueryWrapper<ClassDO>()
                        .eq(StringUtils.isNotBlank(teacherCode),"teacher_code", teacherCode)
        );
    }

    @Override
    public boolean createClass(ClassDO classDO) {

        UserDO user = iUserDao.getUser(classDO.getTeacherCode(), 1);
        if (user == null) {
            throw new BusinessException(null, "该教师不存在");
        }

        classDO.setTeacherName(user.getName());
        return this.save(classDO);
    }

    @Override
    public ClassDO getClassByIdAndCode(String teacherCode, Integer classId) {
        return this.baseMapper.selectOne(
                new QueryWrapper<ClassDO>()
                        .eq("teacher_code", teacherCode)
                        .eq("class_id", classId)
        );
    }
}
