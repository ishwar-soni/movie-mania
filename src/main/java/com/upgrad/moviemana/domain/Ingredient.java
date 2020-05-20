package com.upgrad.moviemana.domain;

import lombok.Data;

@Data
public class Ingredient {
	private final String id;
	private final String name;
	private final Type type;
	
	public static enum Type {
		GENRE, ACTOR, LANGUAGE, YEAR, INDUSTRY
	}
}
