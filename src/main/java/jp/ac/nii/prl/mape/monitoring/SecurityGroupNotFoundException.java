package jp.ac.nii.prl.mape.monitoring;

public class SecurityGroupNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -948466578630002132L;
	
	public SecurityGroupNotFoundException() {
		super();
	}
	
	public SecurityGroupNotFoundException(String message) {
		super(message);
	}

}
