package code.heitao.small.framework.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Aimin
 * @Title: BaseEntity
 * @ProjectName lightFrame架构
 * @Description: 基础entity
 * @date 2018/6/14 17:23
 */
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = -2896305863563636012L;
    /**
     * PK ID
     */
    //private Long id;

    /**
     * 操作人
     */
    private String creator;
    /**
     * 操作时间
     */
    private Date gmtCreated;
    /**
     * 最后修改人
     */
    private String modifier;
    /**
     * 最后修改时间
     */
    private Date gmtModified;
    /**
     * N正常-Y删除
     */
    private String isDeleted;

    /**
     * 每页条数
     */
    private int limit        = 20;

    /**
     * 起始条数
     */
    private int start        = 0;
    /**
     * 是否需要 分页
     */
    boolean     isNeedPaging = true;

    public boolean isNeedPaging() {
        return isNeedPaging;
    }

    public void setIsNeedPaging(boolean isNeedPaging) {
        this.isNeedPaging = isNeedPaging;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

   /* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}
