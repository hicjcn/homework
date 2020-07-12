package com.demo.core.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.core.db.entity.ClassStudentDO;
import com.demo.core.db.entity.HomeworkDO;
import com.demo.core.db.entity.HomeworkStudentDO;
import com.demo.core.db.entity.UserDO;
import com.demo.core.db.mapper.HomeworkStudentDOMapper;
import com.demo.core.db.service.IClassStudentDao;
import com.demo.core.db.service.IHomeworkDao;
import com.demo.core.db.service.IHomeworkStudentDao;
import com.demo.core.db.service.IUserDao;
import com.demo.core.exception.BusinessException;
import com.demo.core.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
@Service
public class HomeworkStudentDaoImpl extends ServiceImpl<HomeworkStudentDOMapper, HomeworkStudentDO> implements IHomeworkStudentDao {

    @Resource
    private IHomeworkDao iHomeworkDao;
    @Resource
    private IClassStudentDao iClassStudentDao;
    @Resource
    private IUserDao iUserDao;

    @Override
    public void submitHomework(HomeworkStudentDO homeworkStudentDO, MultipartFile file) {
        if (homeworkStudentDO == null || homeworkStudentDO.getHId() == null) {
            throw new BusinessException(null, "非法操作");
        }

        // 校验学生是否可提交该作业
        String studentCode = homeworkStudentDO.getStudentCode();
        HomeworkDO homeworkDO = iHomeworkDao. getById(homeworkStudentDO.getHId());
        ClassStudentDO classStudentDO = iClassStudentDao.getRelByIdAndCode(homeworkDO.getClassId(), studentCode);
        if (classStudentDO == null) {
            throw new BusinessException(null, "无权提交该作业");
        }

        // 校对时间
        LocalDateTime subTime = LocalDateTime.now();
        if (homeworkDO.getDeadline().isAfter(subTime)) {
            throw new BusinessException(null, "超过截至时间");
        }

        UserDO user = iUserDao.getUser(studentCode, 2);
        if (user == null) {
            throw new BusinessException(null, "该学生不存在");
        }
        homeworkStudentDO.setStudentName(user.getName());

        // 保存文件
        if (file != null) {
            try {
                String fileName = FileUtil.upload(file);
                homeworkStudentDO.setHsFileName(fileName);
            } catch (Exception e) {
                throw new BusinessException(null, "文件保存异常");
            }
        }

        this.saveOrUpdate(homeworkStudentDO);

    }
}
