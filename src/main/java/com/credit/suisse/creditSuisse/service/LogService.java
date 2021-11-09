package com.credit.suisse.creditSuisse.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.credit.suisse.creditSuisse.constants.State;
import com.credit.suisse.creditSuisse.entity.LogEntity;
import com.credit.suisse.creditSuisse.exception.DatabaseException;
import com.credit.suisse.creditSuisse.exception.LogException;
import com.credit.suisse.creditSuisse.mappers.DtoToEntity;
import com.credit.suisse.creditSuisse.mappers.EntityToDto;
import com.credit.suisse.creditSuisse.model.LogData;
import com.credit.suisse.creditSuisse.model.LogDataResponse;
import com.credit.suisse.creditSuisse.repository.LogRepository;

@Service
public class LogService implements LogInterface {

	@Autowired
	private LogRepository logRepository;

	@Autowired
	private DtoToEntity dtoToEntity;
	
	@Autowired
	private EntityToDto entityToDto;

	@Override
	public List<LogDataResponse> saveLogs(List<LogData> logsData) {
		try {
			List<LogEntity> logsEntity = new ArrayList<>();
			Set<String> ids = new HashSet<>();
			for (LogData logData : logsData) {
				if (!ids.contains(logData.getId())) {
					ids.add(logData.getId());
					Double eventDuration = calculateEventDuration(logData, logsData);
					LogEntity logEntity = dtoToEntity.convertLogDataToLogEntity(logData, eventDuration);
					logsEntity.add(logEntity);
				}
			}
			logRepository.saveAll(logsEntity);
			return entityToDto.convertLogsEntityToLogsDataResponse(logsEntity);
		} catch (DatabaseException exception) {
			throw new LogException();
		}
	}

	private Double calculateEventDuration(LogData logData, List<LogData> logsData) {
		Double eventDuration = null;
		if (logData.getState().equals(State.STARTED.name())) {
			Long startTimestamp = logData.getTimestamp();
			Optional<LogData> logDta = logsData.stream()
					.filter(log -> log.getId().equals(logData.getId()) && log.getState().equals(State.FINISHED.name()))
					.findFirst();
			if (logDta.isPresent()) {
				Long endTimestamp = logDta.get().getTimestamp();
				eventDuration = (double) (endTimestamp - startTimestamp);
			}
		} else if (logData.getState().equals(State.FINISHED.name())) {
			Long endTimestamp = logData.getTimestamp();
			Optional<LogData> logDta = logsData.stream()
					.filter(log -> log.getId().equals(logData.getId()) && log.getState().equals(State.STARTED.name()))
					.findFirst();
			if (logDta.isPresent()) {
				Long startTimestamp = logDta.get().getTimestamp();
				eventDuration = (double) (endTimestamp - startTimestamp);
			}
		}
		return eventDuration;
	}

	@Override
	public List<LogEntity> getAllLogs() {
		return logRepository.findAll();
	}

}
