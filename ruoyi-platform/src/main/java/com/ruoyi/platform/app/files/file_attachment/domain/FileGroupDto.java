package com.ruoyi.platform.app.files.file_attachment.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/29 23:40
 * @Description:
 */
public class FileGroupDto {

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
        return "FileGroupDto{" +
                "ids=" + ids +
                ", group_id='" + group_id + '\'' +
                '}';
    }
}
