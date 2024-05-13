package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZichanEntity;
import java.util.Map;

/**
 * 资产 服务类
 * @author 
 * @since 2021-03-12
 */
public interface ZichanService extends IService<ZichanEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}