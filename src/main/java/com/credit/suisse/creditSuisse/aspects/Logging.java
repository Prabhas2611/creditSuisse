package com.credit.suisse.creditSuisse.aspects;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
	
	private static final Logger logger = Logger.getLogger(Level.INFO.getName());

	@Around("execution (* com.credit.suisse.creditSuisse..*(..))")
	public Object logMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		logger.info("In class " + className + " entering mthod " + methodName);
		Object result = joinPoint.proceed();
		logger.info("In class " + className + " exiting mthod " + methodName);
		return result;
	}
}
