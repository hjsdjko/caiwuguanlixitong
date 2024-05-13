package com.dao;

import com.entity.JingyingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JingyingView;

/**
 * 经营 Dao 接口
 *
 * @author 
 * @since 2021-03-12
 */
public interface JingyingDao extends BaseMapper<JingyingEntity> {

   List<JingyingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
