package jp.ac.nii.prl.mape.monitoring.service;

import org.springframework.stereotype.Service;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;

@Service("cloudWatchService")
public class CloudWatchServiceImpl implements CloudWatchService {

	private AmazonCloudWatchClient cwClient;
	
	public CloudWatchServiceImpl() {
		cwClient = Region
				.getRegion(Regions.AP_NORTHEAST_1)
				.createClient(AmazonCloudWatchClient.class, null, null);
	}
}
