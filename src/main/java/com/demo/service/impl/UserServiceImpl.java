package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.dao.IStaffDao;
import com.demo.entity.Constants;
import com.demo.entity.StaffDO;
import com.demo.entity.vo.StaffVO;
import com.demo.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IStaffDao staffDao;

    @Resource
    private HttpSession session;

    @Value("${config.default.password}")
    private String defaultPassword;


    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean login(String username, String password) {
        StaffDO staffDO = staffDao.getById(username);
        if (null == staffDO) {
            return false;
        }
        if (password.equals(staffDO.getPassword())) {
            session.setAttribute(Constants.USER, staffDO);
            return true;
        }
        return false;
    }

    /**
     * 修改密码
     *
     * @param username
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @Override
    public boolean resetPwd(String username, String oldPwd, String newPwd) {
        StaffDO staffDO = staffDao.getById(username);
        if (null == staffDO) {
            return false;
        }
        if (oldPwd.equals(staffDO.getPassword())) {
            staffDO.setPassword(newPwd);
            return staffDao.updateById(staffDO);
        }
        return false;
    }

    /**
     * 分页获取员工列表
     *
     * @param pageNo
     * @return
     */
    @Override
    public IPage<StaffDO> page(Integer pageNo) {
        IPage<StaffDO> page = new Page<>();
        if (null != pageNo) {
            page.setCurrent(pageNo);
        } else {
            page.setCurrent(1);
        }
        // 每页10条数据
        page.setSize(10);

        return staffDao.page(page, new QueryWrapper<>());
    }

    /**
     * 创建或者保存
     *
     * @param staffVO
     * @return
     */
    @Override
    public boolean save(StaffVO staffVO) {
        if (StringUtils.isNotEmpty(staffVO.getStaffID())) {
            // 查找是否存在该工号 补充密码
            StaffDO staffDaoById = staffDao.getById(staffVO.getStaffID());
            if (null != staffDaoById) {
                staffVO.setPassword(staffDaoById.getPassword());
            }
        } else {
            // 自动生成工号
            String staffId = generateStaffId(staffVO.getJobType(), staffVO.getStaffSex());
            staffVO.setStaffID(staffId);
        }

        if (StringUtils.isEmpty(staffVO.getPassword())) {
            staffVO.setPassword(defaultPassword);
        }
        return staffDao.saveOrUpdate(staffVO);

    }

    /**
     * 生成工号
     * @param jobType
     * @return
     */
    private String generateStaffId(int jobType, int sex) {
        int id = staffDao.getMaxIdByJobType(jobType);
        return "0" + jobType + (++id > 10 ? ("" + id) : ("0" + id)) + (sex == 0 ? "2" : "1");
    }

    /**
     * 删除
     *
     * @param no
     */
    @Override
    public void delete(String no) {
        staffDao.removeById(no);
    }
}
