package com.demo.core.db.service.impl;

import com.demo.core.db.entity.ClassDO;
import com.demo.core.db.entity.HomeworkDO;
import com.demo.core.db.entity.VO.HomeworkVO;
import com.demo.core.db.mapper.HomeworkDOMapper;
import com.demo.core.db.service.IClassDao;
import com.demo.core.db.service.IHomeworkDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.core.exception.BusinessException;
import com.demo.core.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
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
public class HomeworkDaoImpl extends ServiceImpl<HomeworkDOMapper, HomeworkDO> implements IHomeworkDao {

    @Resource
    private IClassDao iClassDao;

    @Override
    public void releaseHomework(HomeworkDO homeworkDO, MultipartFile file) {
        ClassDO classDO = iClassDao.getClassByIdAndCode(homeworkDO.getTeacherCode(), homeworkDO.getClassId());
        if (classDO == null) {
            throw new BusinessException(null, "该课程不存在或无权发布此课程作业");
        }

        if (file != null) {
            try {
                String fileName = FileUtil.upload(file);
                homeworkDO.setFileName(fileName);
            } catch (Exception e) {
                throw new BusinessException(null, "文件保存异常");
            }
        }

        homeworkDO.setCreateTime(LocalDateTime.now());

        this.saveOrUpdate(homeworkDO);

    }

    @Override
    public List<HomeworkVO> getHomeworkList(String teacherCode, String className) {
        return this.baseMapper.getHomeworkList(teacherCode, className);
    }
}
