package com.demo.stu.service.impl;

import com.demo.stu.entity.ManagerDO;
import com.demo.stu.entity.StudentDO;
import com.demo.stu.entity.TeacherDO;
import com.demo.stu.entity.enumcode.UserType;
import com.demo.stu.exception.BusinessException;
import com.demo.stu.service.IManagerService;
import com.demo.stu.service.IStudentService;
import com.demo.stu.service.ITeacherService;
import com.demo.stu.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IManagerService managerService;


    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param type
     * @return
     */
    @Override
    public boolean login(String username, String password, UserType type) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new BusinessException(null, "账号或密码为空");
        }

        return true;
//        boolean res = false;
//
//        switch (type.value()) {
//            case 0:
//                StudentDO student = studentService.getStudentById(username);
//                if (student != null && password.equals(student.getPassword())) {
//                    res = true;
//                }
//                break;
//            case 1:
//                TeacherDO teacher = teacherService.getTeacherById(username);
//                if (teacher != null && password.equals(teacher.getPassword())) {
//                    res = true;
//                }
//                break;
//            case 2:
//                ManagerDO manager = managerService.getManagerByUserName(username);
//                if (manager != null && password.equals(manager.getPassword())) {
//                    res = true;
//                }
//                break;
//            default:
//                throw new BusinessException(null, "该账号类型不存在");
//        }
//
//        return res;
    }

    @Override
    public boolean resetPwd(String stuNo, String oldPwd, String newPwd, UserType type) {
        if (StringUtils.isAnyEmpty(oldPwd, newPwd)) {
            throw new BusinessException(null, "新/旧密码不应为空");
        }

        boolean res = false;

        switch (type.value()) {
            case 0:
                StudentDO student = studentService.getStudentById(stuNo);
                if (student != null && oldPwd.equals(student.getPassword())) {
                    student.setPassword(newPwd);
                    res = studentService.update(student);
                }
                break;
            case 1:
                TeacherDO teacher = teacherService.getTeacherById(stuNo);
                if (teacher != null && oldPwd.equals(teacher.getPassword())) {
                    teacher.setPassword(newPwd);
                    res = teacherService.update(teacher);
                }
                break;
            case 2:
                ManagerDO manager = managerService.getManagerByUserName(stuNo);
                if (manager != null && oldPwd.equals(manager.getPassword())) {
                    manager.setPassword(newPwd);
                    res = managerService.update(manager);
                }
                break;
            default:
                throw new BusinessException(null, "该账号类型不存在");
        }

        return res;
    }
}
