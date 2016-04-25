package jp.ac.nii.prl.mape.monitoring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.SecurityGroup;

@Service("ec2Service")
public class EC2ServiceImpl implements EC2Service {
	
	private AmazonEC2Client ec2Client;
	private Filter filter;
	private DescribeInstancesRequest request;
	private DescribeSecurityGroupsRequest sgRequest;
	
	public EC2ServiceImpl() {
		ec2Client = Region
				.getRegion(Regions.AP_NORTHEAST_1)
				.createClient(AmazonEC2Client.class, null, null);
		List<String> tagValues = new ArrayList<>();
		tagValues.add("CloudBX");
		filter = new Filter("tag:Experiment", tagValues);
		request = new DescribeInstancesRequest();
		sgRequest = new DescribeSecurityGroupsRequest();
	}
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.monitoring.service.EC2Service#getInstances()
	 */
	@Override
	public List<Instance> getInstances() {
		List<Reservation> reservations = ec2Client
				.describeInstances(request.withFilters(filter))
				.getReservations();
		List<Instance> instances = new ArrayList<Instance>();
		for (Reservation reservation:reservations) {
			instances.addAll(reservation.getInstances());
		}
		return instances;
	}
	
	@Override
	public List<SecurityGroup> getSecurityGroups() {
		return ec2Client.describeSecurityGroups(sgRequest.withFilters(filter)).getSecurityGroups();
	}
}
