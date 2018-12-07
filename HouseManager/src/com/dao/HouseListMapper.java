package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pojo.House;
import com.pojo.HouseDistrice;
import com.pojo.HouseStreet;
import com.pojo.HouseType;
import com.pojo.User;
@Repository
public interface HouseListMapper {
	/**
	 * 查询房屋信息
	 * @return
	 */
	@Autowired
	public List<House> getHouseWhere(Map<String, Object> map);
	/**
	 * 根据id查询房屋信息
	 * @param map
	 * @return
	 */
	@Autowired
	public House getHouseById(Map<String, Object> map);
	/**
	 * 根据id删除房屋信息
	 * @param map
	 * @return
	 */
	@Autowired
	public int deleteById(int id);
	/**
	 * 修改房屋信息
	 * @param map
	 * @return
	 */
	@Autowired
	public int updateHouse(House house);
	/**
	 * 获取所有的区县
	 * @return
	 */
	@Autowired
	public List<HouseDistrice> getAllDname();
	/**
	 * 根据区县id查询街道
	 * @param did
	 * @return
	 */
	@Autowired
	public List<HouseStreet> getStreet(int did);
	/**
	 * 查询所有的房屋类型
	 * @return
	 */
	@Autowired
	public List<HouseType> getType();
	/**
	 * 新增房屋信息
	 * @param house
	 * @return
	 */
	@Autowired
	public int addHouse(House house);
	
}
