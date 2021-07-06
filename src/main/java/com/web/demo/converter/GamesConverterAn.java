package com.web.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.web.demo.dto.GamesDtoAn;
import com.web.demo.entity.Games;

public class GamesConverterAn {
	private ModelMapper mapper = new ModelMapper();
	private static GamesConverterAn gameConverter;
	
	private GamesConverterAn() {};
	
	public static GamesConverterAn getInstance() {
		if(gameConverter == null) {
			gameConverter = new GamesConverterAn();
		}
		return gameConverter;
	}
	
	public GamesDtoAn toUserDto(Games entity) {
		return mapper.map(entity, GamesDtoAn.class);
	}
	
	public List<GamesDtoAn> touserDtoList(List<Games> list) {
		return list
				.stream()
				.map(user -> { return toUserDto(user);})
				.collect(Collectors.toList());
	}
}
