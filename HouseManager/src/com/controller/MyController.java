package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.pojo.House;
import com.pojo.HouseDistrice;
import com.pojo.HouseType;
import com.pojo.User;
import com.service.HouseListService;
import com.service.HouseUserService;
import com.service.impl.HouseListServiceImpl;
import com.service.impl.HouseUserServiceImpl;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion.Setting;

@Controller
@SessionAttributes(types=User.class,names="users")
public class MyController {
	@Autowired
	private HouseUserService houSer = new HouseUserServiceImpl();
	@Autowired
	private HouseListService listSer=new HouseListServiceImpl();
/**
 * 登录
 * @param u
 * @return
 */
	@RequestMapping("/login")
	
	public ModelAndView login(User u,ModelAndView mav,HttpSession session) {
		User user = houSer.login(u.getUserName(), u.getPassWord());
		if(user!=null) {
			mav.addObject("user", user);
			mav.setViewName("forward:/getHouse?index1=1"); 
		}else {
			mav.setViewName("login");
		}
		return mav;
	}
	/**
	 * 查询房屋信息    在页面加载时显示
	 * @param userName
	 * @param mav
	 * @return
	 */
	@RequestMapping("/getHouse")
	public ModelAndView getHouse(@RequestParam String userName,@RequestParam Integer index1,ModelAndView mav) {
		//根据姓名查询房屋
		Map<String, Object> map= new HashMap<String, Object>();
		Integer index=1;
		if(index1!=null&&!index1.equals("")) {
			index=index1;
		}
		map.put("userName", userName);
		map.put("index", index);
		map.put("size", 2);
		
		//房屋
		Page<Object> list=listSer.getHouseWhere(map);
		mav.addObject("houseList", list);
		//房屋类型
		List<HouseType> lisType=listSer.getType();
		mav.addObject("getType", lisType);
		//区县
		List<HouseDistrice> lisDis=listSer.getAllDname();
		mav.addObject("getDname", lisDis);
		
		mav.setViewName("list");
		
		return mav;
	}
	/**
	 * 修改--------根据id查询一条房屋信息
	 * @param userName
	 * @param hmid
	 * @param mav
	 * @return
	 */
	@RequestMapping("/getHouseById")
	public ModelAndView getHouseById(int hmid,ModelAndView mav) {
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("hmid", hmid);
		House house=listSer.getHouseById(map);
		mav.addObject("hseById", house);
		getType(mav);
		mav.setViewName("update");
		return mav;
	}
	
	/**
	 * 查询所有的房屋类型和区县街道
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getType(ModelAndView mav){
		List<HouseType> lisType=listSer.getType();
		mav.addObject("getType", lisType);
		
		List<HouseDistrice> lisDis=listSer.getAllDname();
		mav.addObject("getDname", lisDis);
	}
	/**
	 * 执行修改
	 * @param h
	 * @param mav
	 * @return
	 */
	@RequestMapping("/upd")
	public ModelAndView upd(House h,ModelAndView mav) {
		int row=listSer.updateHouse(h);
		if(row>0) {
			mav.setViewName("forward:/getHouse");
		}
		return mav;
	}
	/**
	 * 查询发布页面的下拉列表
	 * @param mav
	 * @return
	 */
	@RequestMapping("/selHouse")
	public ModelAndView upd(ModelAndView mav) {
		getType(mav);
		mav.setViewName("fabu");
		return mav;
	}
	/**
	 * 新增房屋
	 * @param mav
	 * @return
	 */
	@RequestMapping("/addHouse")
	public ModelAndView addHouse(House h,ModelAndView mav) {
		int row=listSer.addHouse(h);
		if(row>0) {
			mav.setViewName("forward:/getHouse");
		}
		return mav;
	}
	@RequestMapping("/selWhere")
	public ModelAndView selWhere(House h,String moneny,String floorage,ModelAndView mav){
		int psum=0;
		int pnum=0;
		String price=moneny;
		if(price!=null && price.length()>0&&!price.equals("0")) {
			String[] p = price.split("-");
			for (int i = 0; i < p.length; i++) {
				if(p[i]!=null) {
					psum=Integer.parseInt(p[0]);
					pnum=Integer.parseInt(p[1]);
				}
			}
		}
		
		
	
	
		int asum=0;
		int anum=0;
		String area=floorage;
		if(area!=null && price.length()>0 && !area.equals("0")) {
			String[] a = area.split("-");
			for (int i = 0; i < a.length; i++) {
				if(a[i]!=null) {
					asum=Integer.parseInt(a[0]);
					anum=Integer.parseInt(a[1]);  
				}
			}
		
		}
		
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("topic", h.getTopic());
		map.put("htid", h.getHtid());
		map.put("sid", h.getSid());
		map.put("price", psum);
		map.put("pnum", pnum);
		map.put("area", asum);
		map.put("anum", anum);
		map.put("did", h.getDis().getDid());
		map.put("username",h.getUser().getUserName());
		
		
		Page<Object> list=listSer.getHouseWhere(map);
		mav.addObject("houseList", list);
		
		getType(mav);
		
		mav.setViewName("list");
		
		return mav;
	}
	
}
