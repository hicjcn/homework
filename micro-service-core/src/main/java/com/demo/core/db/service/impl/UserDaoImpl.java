package com.demo.core.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.core.db.entity.UserDO;
import com.demo.core.db.mapper.UserDOMapper;
import com.demo.core.db.service.IUserDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.core.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
@Service
public class UserDaoImpl extends ServiceImpl<UserDOMapper, UserDO> implements IUserDao {


    @Override
    public void userRegistry(UserDO user) {
        if (user == null || StringUtils.isBlank(user.getUserCode())
                || StringUtils.isBlank(user.getPassword()) || user.getUserType() == null) {
            throw new BusinessException(null, "注册失败,用户信息缺失");
        }
        UserDO userDO = this.baseMapper.selectOne(new QueryWrapper<UserDO>().eq("user_code", user.getUserCode()));
        if (userDO != null) {
            throw new BusinessException(null, "该用户名已存在");
        }

        if (!this.save(user)) {
            throw new BusinessException(null, "注册失败");
        }
    }

    @Override
    public void login(UserDO user) {
        UserDO userDO = this.baseMapper.selectOne(
                new QueryWrapper<UserDO>()
                        .eq("user_code", user.getUserCode())
                        .eq("password", user.getPassword())
                        .eq("user_type", user.getUserType())
        );
        if (userDO == null) {
            throw new BusinessException(null, "用户名/密码错误");
        }
    }

    @Override
    public UserDO getUser(String code, int type) {
        return this.baseMapper.selectOne(
                new QueryWrapper<UserDO>()
                        .eq("user_code", code)
                        .eq("user_type", type)
        );
    }
}
