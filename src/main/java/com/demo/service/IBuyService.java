package com.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.entity.BuyDO;
import com.demo.entity.vo.BuyVO;

public interface IBuyService {

    /**
     * 分页获取列表
     *
     * @param wareId
     * @param pageNo
     * @return
     */
    IPage<BuyVO> page(String wareId, Integer pageNo);

    /**
     * 创建或者保存
     * @param buyDO
     * @return
     */
    boolean save(BuyDO buyDO);

    /**
     * 删除
     * @param no
     */
    void delete(String no);
}
