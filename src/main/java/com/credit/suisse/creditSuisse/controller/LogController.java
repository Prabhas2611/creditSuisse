package com.credit.suisse.creditSuisse.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.credit.suisse.creditSuisse.entity.LogEntity;
import com.credit.suisse.creditSuisse.exception.LogException;
import com.credit.suisse.creditSuisse.model.LogData;
import com.credit.suisse.creditSuisse.model.LogDataResponse;
import com.credit.suisse.creditSuisse.service.LogInterface;
import com.google.gson.Gson;

@RestController
public class LogController {

	@Autowired
	private LogInterface logInterface;

	@SuppressWarnings({ "resource", "unchecked" })
	@PostMapping(value = "/save")
	public List<LogDataResponse> saveLogs(@RequestBody() String logFilePath) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(logFilePath));
			Gson gson = new Gson();
			List<LogData> logsData = new ArrayList<>();
			Iterator<String> iterator = reader.lines().iterator();
			while (iterator.hasNext()) {
				LogData logData = gson.fromJson((String) iterator.next(), LogData.class);
				logsData.add(logData);
			}
			return logInterface.saveLogs(logsData);
		} catch (IOException ioException) {
			throw new LogException(logFilePath, logFilePath);
		}
	}

	@GetMapping(value = "/all")
	public List<LogEntity> getAllLogs() {
		return logInterface.getAllLogs();
	}
}
