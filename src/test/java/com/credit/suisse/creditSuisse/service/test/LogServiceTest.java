package com.credit.suisse.creditSuisse.service.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.credit.suisse.creditSuisse.entity.LogEntity;
import com.credit.suisse.creditSuisse.exception.DatabaseException;
import com.credit.suisse.creditSuisse.exception.LogException;
import com.credit.suisse.creditSuisse.mappers.DtoToEntity;
import com.credit.suisse.creditSuisse.mappers.EntityToDto;
import com.credit.suisse.creditSuisse.model.LogData;
import com.credit.suisse.creditSuisse.model.LogDataResponse;
import com.credit.suisse.creditSuisse.repository.LogRepository;
import com.credit.suisse.creditSuisse.service.LogService;

@SpringBootTest
public class LogServiceTest {

	@InjectMocks
	private LogService logService;

	@Mock
	private LogRepository logRepository;

	@Mock
	private DtoToEntity dtoToEntity;

	@Mock
	private EntityToDto entityToDto;

	@Test
	public void saveLogsTest() {
		LogEntity logEntity = new LogEntity();
		Mockito.when(dtoToEntity.convertLogDataToLogEntity(Mockito.any(), Mockito.anyDouble())).thenReturn(logEntity);
		LogDataResponse logDataResponse = new LogDataResponse(1, "scsmbstgrb", 4.0, "APPLICATION_LOG", "12345", false);
		Mockito.when(entityToDto.convertLogsEntityToLogsDataResponse(Mockito.anyList()))
				.thenReturn(Arrays.asList(logDataResponse));
		LogData logData = new LogData("scsmbstgrb", "STARTED", "APPLICATION_LOG", "12345", 1491377495212l);
		LogData logData2 = new LogData("scsmbstgrb", "FINISHED", "APPLICATION_LOG", "12345", 1491377495216l);
		List<LogData> logsData = new ArrayList<>();
		logsData.add(logData);
		logsData.add(logData2);
		logService.saveLogs(logsData);
	}

	@Test
	public void saveLogsTest2() {
		LogEntity logEntity = new LogEntity();
		Mockito.when(dtoToEntity.convertLogDataToLogEntity(Mockito.any(), Mockito.anyDouble())).thenReturn(logEntity);
		LogDataResponse logDataResponse = new LogDataResponse(1, "scsmbstgrb", 4.0, "APPLICATION_LOG", "12345", false);
		Mockito.when(entityToDto.convertLogsEntityToLogsDataResponse(Mockito.anyList()))
				.thenReturn(Arrays.asList(logDataResponse));
		LogData logData = new LogData("scsmbstgrb", "STARTED", "APPLICATION_LOG", "12345", 1491377495212l);
		LogData logData2 = new LogData("scsmbstgrb", "FINISHED", "APPLICATION_LOG", "12345", 1491377495216l);
		List<LogData> logsData = new ArrayList<>();
		logsData.add(logData2);
		logsData.add(logData);
		logService.saveLogs(logsData);
	}

	@Test
	public void saveLogsTestException() {
		LogEntity logEntity = new LogEntity();
		Mockito.when(dtoToEntity.convertLogDataToLogEntity(Mockito.any(), Mockito.anyDouble())).thenReturn(logEntity);
		Mockito.when(entityToDto.convertLogsEntityToLogsDataResponse(Mockito.anyList()))
				.thenThrow(DatabaseException.class);
		LogData logData = new LogData("scsmbstgrb", "STARTED", "APPLICATION_LOG", "12345", 1491377495212l);
		LogData logData2 = new LogData("scsmbstgrb", "FINISHED", "APPLICATION_LOG", "12345", 1491377495216l);
		List<LogData> logsData = new ArrayList<>();
		logsData.add(logData2);
		logsData.add(logData);
		Assertions.assertThrows(LogException.class, () -> logService.saveLogs(logsData));
	}
}
