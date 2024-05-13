package com.entity.model;

import com.entity.JingyingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 经营
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-12
 */
public class JingyingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String jingyingName;


    /**
     * 经营类型
     */
    private Integer jingyingTypes;


    /**
     * 详情
     */
    private String jingyingContent;


    /**
     * 金额
     */
    private Integer jingyingMoney;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：标题
	 */
    public String getJingyingName() {
        return jingyingName;
    }


    /**
	 * 设置：标题
	 */
    public void setJingyingName(String jingyingName) {
        this.jingyingName = jingyingName;
    }
    /**
	 * 获取：经营类型
	 */
    public Integer getJingyingTypes() {
        return jingyingTypes;
    }


    /**
	 * 设置：经营类型
	 */
    public void setJingyingTypes(Integer jingyingTypes) {
        this.jingyingTypes = jingyingTypes;
    }
    /**
	 * 获取：详情
	 */
    public String getJingyingContent() {
        return jingyingContent;
    }


    /**
	 * 设置：详情
	 */
    public void setJingyingContent(String jingyingContent) {
        this.jingyingContent = jingyingContent;
    }
    /**
	 * 获取：金额
	 */
    public Integer getJingyingMoney() {
        return jingyingMoney;
    }


    /**
	 * 设置：金额
	 */
    public void setJingyingMoney(Integer jingyingMoney) {
        this.jingyingMoney = jingyingMoney;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
