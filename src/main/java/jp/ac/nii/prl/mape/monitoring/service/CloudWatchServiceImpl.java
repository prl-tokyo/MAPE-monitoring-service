package jp.ac.nii.prl.mape.monitoring.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.model.Datapoint;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;

@Service("cloudWatchService")
public class CloudWatchServiceImpl implements CloudWatchService {

	private AmazonCloudWatchClient cwClient;
	
	public CloudWatchServiceImpl() {
		cwClient = Region
				.getRegion(Regions.AP_NORTHEAST_1)
				.createClient(AmazonCloudWatchClient.class, null, null);
	}
	
	@Override
	public Double getLoad(String instId) {
		long offset = 1000 * 60 * 15; // 15 minutes
		GetMetricStatisticsRequest request = new GetMetricStatisticsRequest()
				.withStartTime(new Date(new Date().getTime() - offset))
				.withEndTime(new Date())
				.withNamespace("AWS/EC2")
				.withDimensions(new Dimension().withName("InstanceId").withValue(instId))
				.withPeriod(60*15)
				.withMetricName("CPUUtilization")
				.withStatistics("Average");
		
		GetMetricStatisticsResult result = cwClient.getMetricStatistics(request);
		
		System.out.println(result.toString());
		List<Datapoint> datapoints = result.getDatapoints();
		if (datapoints.isEmpty())
			return 0.0;
		return result.getDatapoints().get(0).getAverage();
	}
}
