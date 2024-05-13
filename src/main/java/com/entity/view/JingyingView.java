package com.entity.view;

import com.entity.JingyingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 经营
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-12
 */
@TableName("jingying")
public class JingyingView extends JingyingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 经营类型的值
		*/
		private String jingyingValue;



	public JingyingView() {

	}

	public JingyingView(JingyingEntity jingyingEntity) {
		try {
			BeanUtils.copyProperties(this, jingyingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 经营类型的值
			*/
			public String getJingyingValue() {
				return jingyingValue;
			}
			/**
			* 设置： 经营类型的值
			*/
			public void setJingyingValue(String jingyingValue) {
				this.jingyingValue = jingyingValue;
			}








}
