package com.bw.mapper;

import com.bw.bean.House;
import com.bw.bean.Middle;
import com.bw.bean.Owner;

import java.util.List;
import java.util.Map;

public interface HouseMapper {

    List<House> select(Map<String, Object> map);

    int insertHouse(House house);

    List<Owner> query();

    int insertMiddle(Middle middle);

    int delHouse(int hid);
    int delMiddle(int hid);

    House find(int hid);

    int updateHouse(House house);
    int updateMiddle(Middle middle);

}
