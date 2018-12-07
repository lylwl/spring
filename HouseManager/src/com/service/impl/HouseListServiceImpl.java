package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HouseListMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pojo.House;
import com.pojo.HouseDistrice;
import com.pojo.HouseStreet;
import com.pojo.HouseType;
import com.service.HouseListService;
@Service
public class HouseListServiceImpl implements HouseListService{
	@Autowired
	private HouseListMapper HouList;

	@Override
	public Page<Object> getHouseWhere(Map<String, Object> map) {
		int index=(int) map.get("index");
		int size=(int) map.get("size");
		Page<Object> page=PageHelper.startPage(index, size);
		HouList.getHouseWhere(map);
		return page;
	}

	@Override
	public House getHouseById(Map<String, Object> map) {
		return HouList.getHouseById(map);
	}

	@Override
	public int deleteById(int id) {
		int num=-1;
		
			num=HouList.deleteById(id);
		
		return num;
	}

	@Override
	public List<HouseDistrice> getAllDname() {
		return HouList.getAllDname();
	}

	@Override
	public List<HouseStreet> getStreet(int did) {
		return HouList.getStreet(did);
	}

	@Override
	public List<HouseType> getType() {
		return HouList.getType();
	}

	@Override
	public int addHouse(House house) {
		int num=-1;
		try {
			num=HouList.addHouse(house);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int updateHouse(House house) {
		int num=-1;
		try {
			num=HouList.updateHouse(house);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

}
