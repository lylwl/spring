package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class House {
	private int hmid;
	private int uid;
	private int sid;
	private int htid;
	private int price;
	private String topic;
	private String contents;
	private String htime;
	private String area;
	private HouseDistrice dis;
	private HouseStreet str;
	private HouseType type;
	private User user;
}
