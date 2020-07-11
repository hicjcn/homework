package com.demo.core.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.core.db.entity.ClassDO;
import com.demo.core.db.entity.ClassStudentDO;
import com.demo.core.db.entity.VO.ClassStudentVO;
import com.demo.core.db.mapper.ClassStudentDOMapper;
import com.demo.core.db.service.IClassDao;
import com.demo.core.db.service.IClassStudentDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
@Service
public class ClassStudentDaoImpl extends ServiceImpl<ClassStudentDOMapper, ClassStudentDO> implements IClassStudentDao {

    @Resource
    private IClassDao iClassDao;

    @Override
    public void applyForClass(ClassStudentDO classStudentDO) {
        if (classStudentDO == null ) {
            throw new BusinessException(null, "申请信息不存在");
        }

        classStudentDO.setStatus(1);

        ClassStudentDO applyInfo = this.baseMapper.selectOne(
                new QueryWrapper<ClassStudentDO>()
                        .eq("class_id", classStudentDO.getClassId())
                        .eq("student_code", classStudentDO.getStudentCode())
        );

        if (applyInfo == null) {
            this.save(classStudentDO);
        }else {
            switch (applyInfo.getStatus()) {
                case 0:
                    throw new BusinessException(null, "已加入该课程");
                case 1:
                    throw new BusinessException(null, "加入该课程的申请已在审核中，请耐心等待");
                case 2:
                    applyInfo.setStatus(1);
                    this.updateById(applyInfo);
                    break;
                default:
                    throw new BusinessException(null, "非法操作");
            }
        }
    }

    @Override
    public void changeStudentStatus(Integer id, Integer type) {
        if (id == null || type == null) {
            throw new BusinessException(null, "非法操作");
        }

        ClassStudentDO applyInfo = this.getById(id);
        if (applyInfo == null) {
            throw new BusinessException(null, "该申请不存在");
        }

        applyInfo.setStatus(type);
        this.updateById(applyInfo);

    }

    @Override
    public List<ClassStudentVO> getClassStudentList(String teacherCode, Integer classId, Integer type) {
        ClassDO classDO = iClassDao.getClassByIdAndCode(teacherCode, classId);
        if (classDO == null) {
            throw new BusinessException(null, "该课程不存在或无权访问");
        }

        return this.baseMapper.getClassStudentList(classId, type);
    }
}
