package com.ruoyi.platform.app.files.file_image.domain;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/29 23:53
 * @Description:
 */
public class FileImageGroupDto {

    private static final long serialVersionUID = 1L;

    private List<Integer> ids;

    private int group_id;


    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    @Override
    public String toString() {
        return "FileImageGroupDto{" +
                "ids=" + ids +
                ", group_id=" + group_id +
                '}';
    }
}
