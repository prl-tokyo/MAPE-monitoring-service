package jp.ac.nii.prl.mape.monitoring.service;

import org.springframework.stereotype.Service;

import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;

@Service("cloudWatchService")
public class CloudWatchServiceImpl implements CloudWatchService {

	private AmazonCloudWatchClient cwClient;
	
	public CloudWatchServiceImpl() {
		
	}
}
