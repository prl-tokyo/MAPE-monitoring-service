package jp.ac.nii.prl.mape.monitoring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestErrorHandler {

	@ExceptionHandler(ModelConstructionException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public void handleModelConstructionException(ModelConstructionException ex) {
		
	}
}
