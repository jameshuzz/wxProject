package com.james.demo.web;

import com.james.demo.common.handler.GlobalExceptionHandler;
import com.james.demo.entity.Area;
import com.james.demo.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by James_hu on 2018/6/5
 **/
@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaController.class);

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    private Map<String, Object> listArea() {
        LOGGER.info("查询区域列表");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList", list);
        return modelMap;
    }

    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(Integer areaId) {
        LOGGER.info("查询区域信息");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Area area = areaService.getAreaList(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    private Map<String, Object> addAarea(@RequestBody Area area) {
        LOGGER.info("添加区域信息");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.addArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestBody Area area) {
        LOGGER.info("修改区域信息");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.modifyArea(area));
        return modelMap;
    }


    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    private Map<String, Object> removeArea(Integer areaId) {
        LOGGER.info("删除区域信息");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }
}
