package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.dao.IBuyDao;
import com.demo.dao.IStaffDao;
import com.demo.dao.IWareDao;
import com.demo.entity.*;
import com.demo.entity.vo.BuyVO;
import com.demo.service.IBuyService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
public class BuyServiceImpl implements IBuyService {

    @Resource
    private IBuyDao buyDao;

    @Resource
    private IWareDao wareDao;

    @Resource
    private IStaffDao staffDao;

    @Resource
    private HttpSession httpSession;

    /**
     * 分页获取列表
     *
     *
     * @param wareId
     * @param pageNo
     * @return
     */
    @Override
    public IPage<BuyVO> page(String wareId, Integer pageNo) {
        IPage<BuyDO> page = new Page<>();
        if (null != pageNo) {
            page.setCurrent(pageNo);
        } else {
            page.setCurrent(1);
        }
        // 每页10条数据
        page.setSize(10);

        QueryWrapper<BuyDO> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(wareId)) {
            queryWrapper.eq("WareID", wareId);
        }

        IPage<BuyDO> buyDOIPage = buyDao.page(page, queryWrapper);

        // 补充商品名称
        List<WareDO> list = wareDao.list();
        Map<String, String> wareNameMap = list.stream().collect(Collectors.toMap(WareDO::getWareID, WareDO::getWareName));

        // 补充商品名称
        List<StaffDO> staffDOList = staffDao.list();
        Map<String, String> staffNameMap = staffDOList.stream().collect(Collectors.toMap(StaffDO::getStaffID, StaffDO::getStaffName));

        List<BuyDO> buyDOS = buyDOIPage.getRecords();
        List<BuyVO> buyVOS = Lists.newArrayList();
        buyDOS.forEach(buyDO -> {
            BuyVO buyVO = new BuyVO();
            BeanUtils.copyProperties(buyDO, buyVO);
            // 补充名称
            buyVO.setWareName(wareNameMap.getOrDefault(buyVO.getWareID(), "未知商品"));
            // 补充采购员名称
            buyVO.setBuyPersonName(staffNameMap.getOrDefault(buyVO.getBuyPerson(), "未知员工"));
            buyVOS.add(buyVO);
        });

        IPage<BuyVO> buyDOPage = new Page<>();
        buyDOPage.setPages(buyDOIPage.getPages());
        buyDOPage.setSize(buyDOIPage.getSize());
        buyDOPage.setCurrent(buyDOIPage.getCurrent());
        buyDOPage.setTotal(buyDOIPage.getTotal());
        buyDOPage.setRecords(buyVOS);

        return buyDOPage;

    }

    /**
     * 创建
     *
     * @return
     */
    @Override
    public boolean save(BuyDO buyDO) {
        if (StringUtils.isEmpty(buyDO.getBuyID())) {
            String id = generateBuyId();
            buyDO.setBuyID(id);
        }
        buyDO.setBuyDate(LocalDateTime.now());
        // 用户名
        StaffDO staffDO = (StaffDO) httpSession.getAttribute(Constants.USER);
        buyDO.setBuyPerson(staffDO.getStaffID());
        return buyDao.saveOrUpdate(buyDO);
    }

    private String generateBuyId() {
        // 默认仓库 01
        String warehouse = "01";
        // 日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String date = dateFormat.format(new Date(System.currentTimeMillis()));
        // 流水号
        int id = buyDao.getMaxIdByPartition(warehouse + date);
        // 保证四位
        String idStr = String.valueOf(++id);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4 - idStr.length(); i++) {
            builder.append("0");
        }
        builder.append(idStr);

        return warehouse + date + builder.toString();
    }

    /**
     * 删除
     *
     * @param no
     */
    @Override
    public void delete(String no) {
        buyDao.removeById(no);
    }
}
