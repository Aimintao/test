package code.heitao.test.entity;

import code.heitao.small.framework.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Aimin
 * @Title: Customer
 * @ProjectName lightFrame架构
 * @Description: 客户
 * @date 2018/6/19 15:57
 */
@Data
public class Customer extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 2469401135474924268L;
    /**
     * ID
     */
    private long id;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 备注
     */
    private String remark;

}
