package com.bw.controller;

import com.bw.bean.House;
import com.bw.bean.Middle;
import com.bw.bean.Owner;
import com.bw.service.HouseService;
import com.bw.utils.FileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author getengrui
 */
@SuppressWarnings("ALL")
@Controller
public class MyController {

    @Resource
    private HouseService service;

    @RequestMapping("list")
    public String select(Model model, String purpose, String name, @RequestParam(defaultValue = "1") int pageNum) {
        if (purpose == null) {
            purpose = "0";
        }
        PageHelper.startPage(pageNum, 2);
        Map<String, Object> map = new HashMap<String, Object>(10);
        map.put("name", name);
        map.put("purpose", Integer.parseInt(purpose));
        List<House> list = service.select(map);
        PageInfo<House> plist = new PageInfo<House>(list);
        model.addAttribute("plist", plist);
        return "list";
    }

    @RequestMapping("query")
    @ResponseBody
    public List<Owner> query() {
        List<Owner> list = service.query();
        return list;
    }

    @RequestMapping("add")
    public String add(@RequestParam("file") MultipartFile file, House house, Integer[] oid) throws IOException {
        String upload = FileUtils.upload(file);
        house.setPic(upload);
        service.insertHouse(house);
        for (Integer o : oid
        ) {
            Middle middle = new Middle();
            middle.setOid(o);
            middle.setHid(house.getHid());
            service.insertMiddle(middle);
        }
        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(MultipartFile file, House house, Integer[] oid) throws IOException {
        String upload = FileUtils.upload(file);
        house.setPic(upload);
        service.updateHouse(house);
        for (Integer o : oid
        ) {
            Middle middle = new Middle();
            middle.setOid(o);
            middle.setHid(house.getHid());
            service.updateMiddle(middle);
        }
        return "redirect:list";
    }

    @RequestMapping("del")
    public String del(int hid) {
        service.delHouse(hid);
        service.delMiddle(hid);
        return "redirect:list";
    }

    @RequestMapping("lookImg")
    public void lookImg(String path, HttpServletRequest request, HttpServletResponse response) {
        FileUtils.lookImg(path, request, response);
    }

    @RequestMapping("find")
    public String find(int hid, Model model) {
        House house = service.find(hid);
        model.addAttribute("house", house);
        return "update";
    }
}
