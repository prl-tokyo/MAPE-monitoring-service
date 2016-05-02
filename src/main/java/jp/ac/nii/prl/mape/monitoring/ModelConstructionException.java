package jp.ac.nii.prl.mape.monitoring;

import org.springframework.web.client.RestClientException;

public class ModelConstructionException extends RestClientException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7817480889122093327L;

	public ModelConstructionException(String msg) {
		super(msg);
	}
	
	public ModelConstructionException(String msg, Throwable ex) {
		super(msg, ex);
	}

}
