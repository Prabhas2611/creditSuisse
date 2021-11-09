package com.credit.suisse.creditSuisse.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.credit.suisse.creditSuisse.entity.LogEntity;
import com.credit.suisse.creditSuisse.model.LogData;

@Mapper(componentModel = "spring")
public interface DtoToEntity {

	@Mappings({ @Mapping(source = "logData.id", target = "eventId"), @Mapping(source = "logData.type", target = "type"),
			@Mapping(source = "logData.host", target = "host"),
			@Mapping(source = "eventDuration", target = "eventDuration"), @Mapping(target = "id", ignore = true),
			@Mapping(target = "alert", expression = "java(eventDuration > 4 ? true : false)") })
	LogEntity convertLogDataToLogEntity(LogData logData, Double eventDuration);
}
