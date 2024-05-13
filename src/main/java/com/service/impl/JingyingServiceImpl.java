package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.JingyingDao;
import com.entity.JingyingEntity;
import com.service.JingyingService;
import com.entity.view.JingyingView;

/**
 * 经营 服务实现类
 * @author 
 * @since 2021-03-12
 */
@Service("jingyingService")
@Transactional
public class JingyingServiceImpl extends ServiceImpl<JingyingDao, JingyingEntity> implements JingyingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JingyingView> page =new Query<JingyingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
