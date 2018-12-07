package com.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.pojo.House;
import com.pojo.HouseDistrice;
import com.pojo.HouseStreet;
import com.pojo.HouseType;
import com.pojo.User;

public interface HouseListService {
	/**
	 * 查询房屋信息
	 * @return
	 */
	public Page<Object> getHouseWhere(Map<String, Object> map);
	/**
	 * 根据id查询房屋信息
	 * @param map
	 * @return
	 */
	public House getHouseById(Map<String, Object> map);
	/**
	 * 根据id删除房屋信息
	 * @param map
	 * @return
	 */
	public int deleteById(int id);
	/**
	 * 获取所有的区县
	 * @return
	 */
	public List<HouseDistrice> getAllDname();
	/**
	 * 根据区县id查询街道
	 * @param did
	 * @return
	 */
	public List<HouseStreet> getStreet(int did);
	/**
	 * 查询所有的房屋类型
	 * @return
	 */
	public List<HouseType> getType();
	/**
	 * 新增房屋信息
	 * @param house
	 * @return
	 */
	public int addHouse(House house);
	/**
	 * 修改房屋信息
	 * @param map
	 * @return
	 */
	public int updateHouse(House house);

}
