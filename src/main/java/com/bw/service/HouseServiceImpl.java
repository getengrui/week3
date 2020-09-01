package com.bw.service;

import com.bw.bean.House;
import com.bw.bean.Middle;
import com.bw.bean.Owner;
import com.bw.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService{

    @Resource
    private HouseMapper mapper;


    public List<House> select(Map<String, Object> map) {
        return mapper.select(map);
    }

    public int insertHouse(House house) {
        return mapper.insertHouse(house);
    }

    public List<Owner> query() {
        return mapper.query();
    }

    public int insertMiddle(Middle middle) {
        return mapper.insertMiddle(middle);
    }

    public int delHouse(int hid) {
        return mapper.delHouse(hid);
    }

    public int delMiddle(int hid) {
        return mapper.delMiddle(hid);
    }

    public int updateHouse(House house) {
        return mapper.updateHouse(house);
    }

    public int updateMiddle(Middle middle) {
        return mapper.updateMiddle(middle);
    }

    public House find(int hid) {
        return mapper.find(hid);
    }
}
