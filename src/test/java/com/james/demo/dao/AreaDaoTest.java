package com.james.demo.dao;

import com.james.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by James_hu on 2018/6/1
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areaList=areaDao.queryArea();
        //System.out.println(areaList);

        assertEquals(2,areaList.size());
     }

    @Test
    public void queryAreaById() {
        Area area=areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
    }

    @Test
    @Ignore
    public void updateArea() {
    }

    @Test
    @Ignore
    public void deleteArea() {
    }
}