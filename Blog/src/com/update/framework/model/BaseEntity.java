package com.update.framework.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.apache.struts2.json.annotations.JSON;


/**
 * @author cw
 * @date 2016年11月1日
 * @vsersion 1.0
 * DOTO 实体基础类
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 5415197983685667754L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Version
    private int version;
    /**
     * 创建时间
     */
    
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateDate;
    
    /**
     * 删除标记:false未删除，true已删除, 默认未删除
     */
    private Boolean isDelete = false;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        if (createDate == null) {
            createDate = new Date();
        }
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public boolean logicEquals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseEntity other = (BaseEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    public BaseEntity logicClone(Object obj) {
        BaseEntity clone = new BaseEntity();
        clone.setId(this.getId());
        return clone;
    }
}
