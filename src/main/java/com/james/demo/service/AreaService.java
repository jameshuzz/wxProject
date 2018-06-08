package com.james.demo.service;

import com.james.demo.entity.Area;

import java.util.List;

/**
 * Created by James_hu on 2018/6/5
 **/
public interface AreaService {

    List<Area> getAreaList();

    Area getAreaList(int areaId);

    boolean addArea(Area area);

    boolean modifyArea(Area area);

    boolean deleteArea(int areaId);
}
