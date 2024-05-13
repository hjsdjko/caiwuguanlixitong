package com.entity.view;

import com.entity.ZichanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 资产
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-12
 */
@TableName("zichan")
public class ZichanView extends ZichanEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 资产类型的值
		*/
		private String zichanValue;



	public ZichanView() {

	}

	public ZichanView(ZichanEntity zichanEntity) {
		try {
			BeanUtils.copyProperties(this, zichanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 资产类型的值
			*/
			public String getZichanValue() {
				return zichanValue;
			}
			/**
			* 设置： 资产类型的值
			*/
			public void setZichanValue(String zichanValue) {
				this.zichanValue = zichanValue;
			}








}
