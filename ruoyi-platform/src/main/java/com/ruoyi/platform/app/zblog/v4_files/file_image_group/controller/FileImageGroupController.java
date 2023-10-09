package com.ruoyi.platform.app.zblog.v4_files.file_image_group.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.platform.app.zblog.v4_files.file_image.domain.FileImage;
import com.ruoyi.platform.app.zblog.v4_files.file_image.mapper.FileImageMapper;
import com.ruoyi.platform.app.zblog.v4_files.file_image_group.mapper.FileImageGroupMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.platform.app.zblog.v4_files.file_image_group.domain.FileImageGroup;
//import com.ruoyi.platform.app.zblog.v4_files.file_image_group.service.IFileImageGroupService;
import com.ruoyi.platform.app.zblog.v4_files.file_image_group.service.impl.FileImageGroupServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * file_image_groupController
 *
 * @author mylady
 * @date 2023-10-07
 */
@RestController
@RequestMapping("/file_image_group/file_image_group")
public class FileImageGroupController extends BaseController {

    @Autowired
    private FileImageGroupServiceImpl fileImageGroupService;
    //private IFileImageGroupService fileImageGroupService;

    @Autowired
    private FileImageMapper fileImageMapper;

    @Autowired
    private FileImageGroupMapper fileImageGroupMapper;

    /**
     * 查询file_image_group列表
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:list')")
    @GetMapping("/list")
    public TableDataInfo list(FileImageGroup fileImageGroup) {
        startPage();
        // List<FileImageGroup> list = fileImageGroupService.selectFileImageGroupList(fileImageGroup);
        List<Map<String, Objects>> maps = fileImageGroupMapper.query_file_group_list(fileImageGroup);
        return getDataTable(maps);
    }

    /**
     * 导出file_image_group列表
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:export')")
    @Log(title = "导出file_image_group", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileImageGroup fileImageGroup) {
        List<FileImageGroup> list = fileImageGroupService.selectFileImageGroupList(fileImageGroup);
        ExcelUtil<FileImageGroup> util = new ExcelUtil<FileImageGroup>(FileImageGroup.class);
        util.exportExcel(response, list, "file_image_group数据");
    }

    /**
     * 获取file_image_group详细信息
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(fileImageGroupService.selectFileImageGroupById(id));
    }

    /**
     * 新增file_image_group
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:add')")
    @Log(title = "新增file_image_group", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FileImageGroup fileImageGroup) {
        return toAjax(fileImageGroupService.insertFileImageGroup(fileImageGroup));
    }

    /**
     * 修改file_image_group
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:edit')")
    @Log(title = "修改file_image_group", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FileImageGroup dto) {
        // logger.info("路由, 传递dto对象打印: {}", dto);
        AjaxResult ajax = new AjaxResult();

        StringBuilder sb = new StringBuilder();
        //检测是否允许修改,
        //查询图片list, 是否有使用的group_id
        Long groupId = dto.getGroupId();
        if(ObjectUtil.isNotEmpty(groupId)){
            //先查询原先老旧数据
            FileImageGroup fileImageGroup = fileImageGroupMapper.selectFileImageGroupById(dto.getId());
            // logger.info("查询fileImage: {}", fileImageGroup);
            //但旧数据group_id 与 新数据不一致
            if (!Objects.equals(fileImageGroup.getGroupId(), groupId)){
                //查询当前要修改数据的 group_id 是否存在图片
                List<FileImage> fileImages = fileImageMapper.selectFileImageList_v2(fileImageGroup.getGroupId());
                int countNum = fileImages.size();

                logger.info("查询数量: {}", countNum);
                if(countNum >= 1){
                    // return AjaxResult.error("当前组id存在使用图片, 不允许修改");
                    dto.setGroupId(null);
                    sb.append("当前组id存在使用图片,不允许修改,");
                }
            }
        }
        int i = fileImageGroupService.updateFileImageGroup(dto);

        sb.append("修字段成功").append(i);
        ajax.put("msg", sb.toString());
        return ajax;
    }

    /**
     * 删除file_image_group
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:remove')")
    @Log(title = "删除file_image_group", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        //删除检查
        for(long db_id : ids){
            //查询当前对象
            FileImageGroup groupDao = fileImageGroupMapper.selectFileImageGroupById(db_id);
            List<FileImage> maps = fileImageMapper.selectFileImageList_v2(groupDao.getGroupId());

            logger.info("图片组大小: {}", maps.size());
            if (ObjectUtil.isNotEmpty(maps) && maps.size() >= 1) {
                return AjaxResult.error("当前图片组存在文件数据, 不允许删除.");
            }
        }

        return toAjax(fileImageGroupService.deleteFileImageGroupByIds(ids));
    }

}
