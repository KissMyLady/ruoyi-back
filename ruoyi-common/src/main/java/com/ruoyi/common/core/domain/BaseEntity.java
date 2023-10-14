package com.ruoyi.common.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Entity基类
 *
 * @author ruoyi
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 搜索值
     */
    @JsonIgnore
    private String searchValue;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    //密钥token or 关键词查询
    private String key;

    //md5校验值
    private String md5;

    //时间戳
    private String timeStamp;

    //嵌套对象
    private AjaxResult ajaxResult;

    //数据行的权限
    private List<Integer> deptAuthList;
    private List<Integer> ids;

    //分页
    private Integer pageNum = 1;

    private Integer pageSize = 20;

    private Integer total = 1;

    private String sortStr;  //排序

    private String isAsc = "desc";  //正序-倒序 desc acs
    /**
     * 请求参数
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> params;

    @Override
    public String toString() {
        return "BaseEntity{" +
                "searchValue='" + searchValue + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", key='" + key + '\'' +
                ", md5='" + md5 + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", ajaxResult=" + ajaxResult +
                ", deptAuthList=" + deptAuthList +
                ", ids=" + ids +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", sortStr='" + sortStr + '\'' +
                ", isAsc='" + isAsc + '\'' +
                ", params=" + params +
                '}';
    }

    public String getIsAsc() {
        return isAsc;
    }

    public void setIsAsc(String isAsc) {
        this.isAsc = isAsc;
    }

    public String getSortStr() {
        return sortStr;
    }

    public void setSortStr(String sortStr) {
        this.sortStr = sortStr;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getDeptAuthList() {
        return deptAuthList;
    }

    public void setDeptAuthList(List<Integer> deptAuthList) {
        this.deptAuthList = deptAuthList;
    }

    public AjaxResult getAjaxResult() {
        return ajaxResult;
    }

    public void setAjaxResult(AjaxResult ajaxResult) {
        this.ajaxResult = ajaxResult;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
