package jp.ac.nii.prl.mape.monitoring.service;

public interface CloudWatchService {

	/**
	 * Gets the CPU utilisation for an instance
	 * @param instId the instance id
	 * @return CPU utilisation (0 <= x <= 1)
	 */
	Double getLoad(String instId);

}