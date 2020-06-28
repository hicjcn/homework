package com.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.entity.SaleDO;
import com.demo.entity.vo.SaleVO;

public interface ISaleService {

    /**
     * 分页获取列表
     *
     * @param wareId
     * @param pageNo
     * @return
     */
    IPage<SaleVO> page(String wareId, Integer pageNo);

    /**
     * 创建或者保存
     * @param wareVO
     * @return
     */
    boolean save(SaleDO wareVO);

    /**
     * 删除
     * @param no
     */
    void delete(String no);
}
