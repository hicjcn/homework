package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.dao.IWareDao;
import com.demo.entity.StaffDO;
import com.demo.entity.WareDO;
import com.demo.entity.vo.WareVO;
import com.demo.service.IWareService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WareServiceImpl implements IWareService {

    @Resource
    private IWareDao wareDao;

    /**
     * 分页获取列表
     *
     * @param pageNo
     * @return
     */
    @Override
    public IPage<WareDO> page(Integer pageNo) {
        IPage<WareDO> page = new Page<>();
        if (null != pageNo) {
            page.setCurrent(pageNo);
        } else {
            page.setCurrent(1);
        }
        // 每页10条数据
        page.setSize(10);

        return wareDao.page(page, new QueryWrapper<>());
    }

    /**
     * 创建或者保存
     *
     * @param wareVO
     * @return
     */
    @Override
    public boolean save(WareVO wareVO) {
        if (StringUtils.isEmpty(wareVO.getWareID())) {
            // 自动生成编号
            String staffId = generateWareId(wareVO.getWareType());
            wareVO.setWareID(staffId);
        }
        return wareDao.saveOrUpdate(wareVO);
    }

    private String generateWareId(int wareType) {
        int id = wareDao.getMaxIdByWareType(wareType);
        // 保证六位
        String idStr = String.valueOf(++id);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6 - idStr.length(); i++) {
            builder.append("0");
        }
        builder.append(idStr);
        return wareType + builder.toString();
    }

    /**
     * 删除
     *
     * @param no
     */
    @Override
    public void delete(String no) {
        wareDao.removeById(no);
    }

    /**
     * 获取全部商品
     *
     * @return
     */
    @Override
    public List<WareDO> list() {
        return wareDao.list();
    }
}
