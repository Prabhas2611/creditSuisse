package com.credit.suisse.creditSuisse.mappers;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import com.credit.suisse.creditSuisse.entity.LogEntity;
import com.credit.suisse.creditSuisse.model.LogDataResponse;

@Mapper(componentModel = "spring")
public interface EntityToDto {

	@IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
	List<LogDataResponse> convertLogsEntityToLogsDataResponse(List<LogEntity> logsEntity);
}
