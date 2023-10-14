package com.ruoyi.platform.app.files.file_attachment_group.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import org.aspectj.weaver.loadtime.Aj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.files.file_attachment_group.mapper.FileAttachmentGroupMapper;
import com.ruoyi.platform.app.files.file_attachment_group.domain.FileAttachmentGroup;
import com.ruoyi.platform.app.files.file_attachment_group.service.IFileAttachmentGroupService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 附件分组Service业务层处理
 *
 * @author mylady
 * @date 2023-10-14
 */
@Service
public class FileAttachmentGroupServiceImpl implements IFileAttachmentGroupService {

    private static final Logger logger = LoggerFactory.getLogger(FileAttachmentGroupServiceImpl.class);

    @Autowired
    private FileAttachmentGroupMapper fileAttachmentGroupMapper;

    /**
     * 查询附件分组
     *
     * @param id 附件分组主键
     * @return 附件分组
     */
    @Override
    public FileAttachmentGroup selectFileAttachmentGroupById(Long id) {
        return fileAttachmentGroupMapper.selectFileAttachmentGroupById(id);
    }

    /**
     * 查询附件分组列表
     *
     * @param fileAttachmentGroup 附件分组
     * @return 附件分组
     */
    @Override
    public List<FileAttachmentGroup> selectFileAttachmentGroupList(FileAttachmentGroup fileAttachmentGroup) {
        return fileAttachmentGroupMapper.selectFileAttachmentGroupList(fileAttachmentGroup);
    }

    /**
     * 查询列表, SQL分页查询
     */
    @Override
    public TableDataInfo queryFileAttachmentGroupList_BySQL(FileAttachmentGroup dto) {
        Integer page = dto.getPageNum();
        if (page <= 0 || page == null) {
            page = 1;
        }
        Integer pageSize = dto.getPageSize();
        page = (page - 1) * pageSize;
        dto.setPageNum(page);

        //sql排序字符串
        if (!ObjectUtil.isEmpty(dto.getSortStr())) {
            //如果不为空, 判断字符串是否合法
            String sortStr = dto.getSortStr();
            logger.info("如果排序字符串不为空, 判断是否合法: {}" , sortStr);
        }

        AjaxResult ajax = new AjaxResult();
        TableDataInfo tableDataInfo = new TableDataInfo();

        try {
            //查询列表
            //List<Map<String, Objects>> mapList = fileAttachmentGroupMapper.queryFileAttachmentGroupList_BySQL(dto);
            //tableDataInfo.setContent(mapList);
            tableDataInfo.setMsg("查询成功");
            tableDataInfo.setCode(200);

            //ajax.setContent(mapList);
            //ajax.put("msg1" , "查询列表成功 "+ mapList.toString());
        }
        catch (Exception e){
            logger.error("操作失败, 原因是: {}", ""+e);
        }
        try {
            //查询总数
            int countTotal = fileAttachmentGroupMapper.queryFileAttachmentGroupList_count(dto);
            tableDataInfo.setTotal(countTotal);
            ajax.put("total" , countTotal);
            ajax.put("msg2" , "查询总数成功");
            ajax.put("code" , 200);
        } catch (Exception e) {
            ajax.put("msg" , "查询失败");
            ajax.put("error" , "原因" + e.toString());
            ajax.put("code" , 500);
            logger.warn("sql查询表错误, 原因是: {}" , e.toString());
            tableDataInfo.setCode(500);
        }
        return tableDataInfo;
    }


    /**
     * 新增附件分组
     *
     * @param fileAttachmentGroup 附件分组
     * @return 结果
     */
    @Override
    public int insertFileAttachmentGroup(FileAttachmentGroup fileAttachmentGroup) {
        fileAttachmentGroup.setCreateTime(DateUtils.getNowDate());
        return fileAttachmentGroupMapper.insertFileAttachmentGroup(fileAttachmentGroup);
    }

    /**
     * 修改附件分组
     *
     * @param fileAttachmentGroup 附件分组
     * @return 结果
     */
    @Override
    public int updateFileAttachmentGroup(FileAttachmentGroup fileAttachmentGroup) {
        fileAttachmentGroup.setUpdateTime(DateUtils.getNowDate());
        return fileAttachmentGroupMapper.updateFileAttachmentGroup(fileAttachmentGroup);
    }

    /**
     * 批量删除附件分组
     *
     * @param ids 需要删除的附件分组主键
     * @return 结果
     */
    @Override
    public int deleteFileAttachmentGroupByIds(Long[] ids) {
        return fileAttachmentGroupMapper.deleteFileAttachmentGroupByIds(ids);
    }

    /**
     * 删除附件分组信息
     *
     * @param id 附件分组主键
     * @return 结果
     */
    @Override
    public int deleteFileAttachmentGroupById(Long id) {
        return fileAttachmentGroupMapper.deleteFileAttachmentGroupById(id);
    }
}
