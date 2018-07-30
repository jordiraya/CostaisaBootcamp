package com.costaisa.bootcamp.converters;

public interface ModelConverter<T,D> {	

	T toDto(D domain);
	D toDomain(T dto);

}
