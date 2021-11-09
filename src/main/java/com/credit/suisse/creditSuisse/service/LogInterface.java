package com.credit.suisse.creditSuisse.service;

import java.util.List;

import com.credit.suisse.creditSuisse.entity.LogEntity;
import com.credit.suisse.creditSuisse.model.LogData;
import com.credit.suisse.creditSuisse.model.LogDataResponse;

public interface LogInterface {

	List<LogDataResponse> saveLogs(List<LogData> logsData);
	
	List<LogEntity> getAllLogs();

}
