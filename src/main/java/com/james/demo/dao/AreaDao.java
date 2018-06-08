package com.james.demo.dao;

import com.james.demo.entity.Area;

import java.util.List;

/**
 * Created by James_hu on 2018/6/1
 **/
public interface AreaDao {
    /**
     * 列出区域列表
     * @return
     */
     List<Area> queryArea();
    /**
     * 根据Id列出具体区域
     * @return
     */
     Area queryAreaById(int areaId);
    /**
     * 插入区域信息
     * @return
     */
     int insertArea(Area area);
    /**
     * 修改区域信息
     * @return
     */
     int updateArea(Area area);
    /**
     * 删除区域信息
     * @return
     */
     int deleteArea(int areaId);
}
