package com.protean.openfinance.exception;

import com.bazaarvoice.jolt.JsonUtils;
import com.nsdl.beckn.api.model.common.Error;
import com.nsdl.beckn.api.model.common.NackResponseModel;
import com.nsdl.beckn.common.exception.ApplicationException;
import com.nsdl.beckn.common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.concurrent.TimeoutException;

import static com.nsdl.beckn.common.constant.ApplicationConstant.PIPE;
import static com.nsdl.beckn.common.exception.ErrorCode.AUTH_FAILED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String BODY_ERRO_RESPONSE = "Something went wrong";


	@ExceptionHandler(value = {Throwable.class, RuntimeException.class})
	protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
		log.info("The excpetion caught is:", ex);

		HttpHeaders headers = new HttpHeaders();

		if (ex instanceof ApplicationException) {
			log.error("The error is of type ApplicationException");
			ApplicationException appEx = (ApplicationException) ex;
			if (AUTH_FAILED.getCode() == appEx.getErrorCode().getCode()) {
				log.error("Auth failed");
				return handleExceptionInternal(ex, AUTH_FAILED.getMessage(), headers, UNAUTHORIZED, request);
			}

			String errorMessage = buildErrorMessage(ex);
			Error error = new Error();
			error.setMessage(errorMessage);

			NackResponseModel nackResponseModel = new NackResponseModel();
			nackResponseModel.setError(error);

			log.info("error message to return is {}", errorMessage);
			return handleExceptionInternal(ex, nackResponseModel, headers, HttpStatus.BAD_REQUEST, request);
		}
		if (ex instanceof WebClientRequestException) {
			log.error("The error is of type WebClientRequestException");
			WebClientRequestException requestExp = (WebClientRequestException) ex;
			return handleExceptionInternal(ex, requestExp.getMessage(), headers, INTERNAL_SERVER_ERROR, request);
		}
		if (ex instanceof WebClientResponseException) {
			log.error("The error is of type WebClientResponseException");
			WebClientResponseException responseExp = (WebClientResponseException) ex;
			return handleExceptionInternal(ex, responseExp.getMessage(), headers, responseExp.getStatusCode(), request);
		}
		if (ex instanceof TimeoutException) {
			log.error("The error is of type TimeoutException");
			TimeoutException timeoutExp = (TimeoutException) ex;
			return handleExceptionInternal(ex, timeoutExp.getMessage(), headers, HttpStatus.REQUEST_TIMEOUT, request);
		}
		if (ex instanceof AccessDeniedException) {
			log.error("The error is of type AccessDeniedException");
			AccessDeniedException accessDeniedExp = (AccessDeniedException) ex;
			return handleExceptionInternal(ex, accessDeniedExp.getMessage(), headers, HttpStatus.UNAUTHORIZED, request);
		}

		if (ex instanceof LenderException) {
			log.error("The error is of type LenderException");
			LenderException lenderException = (LenderException) ex;
			return new ResponseEntity(lenderException.getError(), headers, INTERNAL_SERVER_ERROR);
		}

		if (ex instanceof RequestValidationException) {
			log.error("The error is of type RequestValidationException");
			RequestValidationException requestValidationException = (RequestValidationException) ex;
			return new ResponseEntity(requestValidationException.getError(), headers, HttpStatus.BAD_REQUEST);
		}

		log.error("Generic error will be thrown");
		return handleExceptionInternal(ex, ex.getMessage(), headers, INTERNAL_SERVER_ERROR, request);
	}

	private String buildErrorMessage(Exception ex) {
		if (NumberUtils.isDigits(ex.getMessage())) {
			ErrorCode errorCode = ((ApplicationException) ex).getErrorCode();
			return errorCode.getCode() + PIPE + errorCode.getMessage();
		}
		return ex.getMessage();
	}

}