package com.entity.vo;

import com.entity.JingyingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 经营
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-12
 */
@TableName("jingying")
public class JingyingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 标题
     */

    @TableField(value = "jingying_name")
    private String jingyingName;


    /**
     * 经营类型
     */

    @TableField(value = "jingying_types")
    private Integer jingyingTypes;


    /**
     * 详情
     */

    @TableField(value = "jingying_content")
    private String jingyingContent;


    /**
     * 金额
     */

    @TableField(value = "jingying_money")
    private Integer jingyingMoney;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：标题
	 */
    public String getJingyingName() {
        return jingyingName;
    }


    /**
	 * 获取：标题
	 */

    public void setJingyingName(String jingyingName) {
        this.jingyingName = jingyingName;
    }
    /**
	 * 设置：经营类型
	 */
    public Integer getJingyingTypes() {
        return jingyingTypes;
    }


    /**
	 * 获取：经营类型
	 */

    public void setJingyingTypes(Integer jingyingTypes) {
        this.jingyingTypes = jingyingTypes;
    }
    /**
	 * 设置：详情
	 */
    public String getJingyingContent() {
        return jingyingContent;
    }


    /**
	 * 获取：详情
	 */

    public void setJingyingContent(String jingyingContent) {
        this.jingyingContent = jingyingContent;
    }
    /**
	 * 设置：金额
	 */
    public Integer getJingyingMoney() {
        return jingyingMoney;
    }


    /**
	 * 获取：金额
	 */

    public void setJingyingMoney(Integer jingyingMoney) {
        this.jingyingMoney = jingyingMoney;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
