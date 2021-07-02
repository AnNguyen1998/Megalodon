package com.web.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.web.demo.dto.UsersDtoAn;
import com.web.demo.entity.Users;
/**
 * 
 * @author An Nguyen, thanks to Tan
 *
 */
public class UserConverterAn {
	private ModelMapper mapper = new ModelMapper();
	
	private static UserConverterAn userConverter;
	
	private UserConverterAn() {};
	
	public static UserConverterAn getInstance() {
		if(userConverter == null) {
			userConverter = new UserConverterAn();
		}
		return userConverter;
	}
	
	public UsersDtoAn toUserDto(Users entity) {
		return mapper.map(entity, UsersDtoAn.class);
	}
	
	public List<UsersDtoAn> touserDtoList(List<Users> list) {
		return list
				.stream()
				.map(user -> { return toUserDto(user);})
				.collect(Collectors.toList());
	}
	
}
