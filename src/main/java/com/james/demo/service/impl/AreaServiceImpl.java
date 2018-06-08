package com.james.demo.service.impl;

import com.james.demo.dao.AreaDao;
import com.james.demo.entity.Area;
import com.james.demo.service.AreaService;
import com.james.demo.common.util.BSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by James_hu on 2018/6/5
 **/
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaList(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    BSUtil.isTrue(false, "插入区域信息失败！");
                }
        } else {
            BSUtil.isTrue(false, "区域信息不能为空！");
        }
        return  false;
    }

    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaId() != null && !"".equals(area.getAreaId())) {
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    BSUtil.isTrue(false, "修改区域信息失败！");
                }
            } catch (Exception e) {
                BSUtil.isTrue(false, "修改区域信息失败！");
            }
        } else {
            BSUtil.isTrue(false, "区域信息不能为空！");
        }
        return  false;
    }
    @Transactional
    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    BSUtil.isTrue(false, "删除区域信息失败！");
                }
            } catch (Exception e) {
                BSUtil.isTrue(false, "删除区域信息失败！");
            }
        } else {
            BSUtil.isTrue(false, "区域信息不能为空！");
        }
        return false;
    }
}
