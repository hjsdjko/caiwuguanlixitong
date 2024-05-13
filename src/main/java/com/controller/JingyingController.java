package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JingyingEntity;

import com.service.JingyingService;
import com.entity.view.JingyingView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 经营
 * 后端接口
 * @author
 * @email
 * @date 2021-03-12
*/
@RestController
@Controller
@RequestMapping("/jingying")
public class JingyingController {
    private static final Logger logger = LoggerFactory.getLogger(JingyingController.class);

    @Autowired
    private JingyingService jingyingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = jingyingService.queryPage(params);

        //字典表数据转换
        List<JingyingView> list =(List<JingyingView>)page.getList();
        for(JingyingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JingyingEntity jingying = jingyingService.selectById(id);
        if(jingying !=null){
            //entity转view
            JingyingView view = new JingyingView();
            BeanUtils.copyProperties( jingying , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JingyingEntity jingying, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jingying:{}",this.getClass().getName(),jingying.toString());
        Wrapper<JingyingEntity> queryWrapper = new EntityWrapper<JingyingEntity>()
            .eq("jingying_name", jingying.getJingyingName())
            .eq("jingying_types", jingying.getJingyingTypes())
            .eq("jingying_content", jingying.getJingyingContent())
            .eq("jingying_money", jingying.getJingyingMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingyingEntity jingyingEntity = jingyingService.selectOne(queryWrapper);
        if(jingyingEntity==null){
            jingying.setInsertTime(new Date());
            jingying.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      jingying.set
        //  }
            jingyingService.insert(jingying);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JingyingEntity jingying, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jingying:{}",this.getClass().getName(),jingying.toString());
        //根据字段查询是否有相同数据
        Wrapper<JingyingEntity> queryWrapper = new EntityWrapper<JingyingEntity>()
            .notIn("id",jingying.getId())
            .eq("jingying_name", jingying.getJingyingName())
            .eq("jingying_types", jingying.getJingyingTypes())
            .eq("jingying_content", jingying.getJingyingContent())
            .eq("jingying_money", jingying.getJingyingMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingyingEntity jingyingEntity = jingyingService.selectOne(queryWrapper);
        if(jingyingEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jingying.set
            //  }
            jingyingService.updateById(jingying);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jingyingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

