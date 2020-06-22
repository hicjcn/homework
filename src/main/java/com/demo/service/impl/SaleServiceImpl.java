package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.dao.ISaleDao;
import com.demo.dao.IWareDao;
import com.demo.entity.SaleDO;
import com.demo.entity.WareDO;
import com.demo.entity.vo.SaleVO;
import com.demo.service.ISaleService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements ISaleService {

    @Resource
    private ISaleDao saleDao;

    @Resource
    private IWareDao wareDao;

    /**
     * 分页获取列表
     *
     * @param pageNo
     * @return
     */
    @Override
    public IPage<SaleVO> page(Integer pageNo) {
        IPage<SaleDO> page = new Page<>();
        if (null != pageNo) {
            page.setCurrent(pageNo);
        } else {
            page.setCurrent(1);
        }
        // 每页10条数据
        page.setSize(10);

        IPage<SaleDO> saleDOIPage = saleDao.page(page, new QueryWrapper<>());

        // 补充商品名称
        List<WareDO> list = wareDao.list();
        Map<String, String> wareNameMap = list.stream().collect(Collectors.toMap(WareDO::getWareID, WareDO::getWareName));

        List<SaleDO> saleDOList = saleDOIPage.getRecords();
        List<SaleVO> saleVOList = Lists.newArrayList();
        saleDOList.forEach(saleDO -> {
            SaleVO saleVO = new SaleVO();
            BeanUtils.copyProperties(saleDO, saleVO);
            // 补充名称
            saleVO.setWareName(wareNameMap.getOrDefault(saleVO.getWareID(), "未知商品"));
            saleVOList.add(saleVO);
        });

        IPage<SaleVO> saleVOIPage = new Page<>();
        saleVOIPage.setPages(saleDOIPage.getPages());
        saleVOIPage.setSize(saleDOIPage.getSize());
        saleVOIPage.setCurrent(saleDOIPage.getCurrent());
        saleVOIPage.setTotal(saleDOIPage.getTotal());
        saleVOIPage.setRecords(saleVOList);

        return saleVOIPage;

    }

    /**
     * 创建
     *
     * @return
     */
    @Override
    public boolean save(SaleDO saleDO) {
        if (StringUtils.isEmpty(saleDO.getSaleID())) {
            String id = generateSaleId();
            saleDO.setSaleID(id);
        }
        saleDO.setSaleDate(LocalDateTime.now());
        return saleDao.saveOrUpdate(saleDO);
    }

    private String generateSaleId() {
        // 默认仓库 01
        String warehouse = "01";
        //入库日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String date = dateFormat.format(new Date(System.currentTimeMillis()));
        // 流水号
        int id = saleDao.getMaxIdByPartition(warehouse + date);
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
        saleDao.removeById(no);
    }
}
