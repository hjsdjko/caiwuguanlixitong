package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingyingEntity;
import java.util.Map;

/**
 * 经营 服务类
 * @author 
 * @since 2021-03-12
 */
public interface JingyingService extends IService<JingyingEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}