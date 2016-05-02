package jp.ac.nii.prl.mape.monitoring.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.regions.Region;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.SecurityGroup;

import jp.ac.nii.prl.mape.monitoring.MonitorConfiguration;

@Service("ec2Service")
public class EC2ServiceImpl implements EC2Service {
	
	private AmazonEC2Client ec2Client;
	private Filter filter;
	private DescribeInstancesRequest request;
	private DescribeSecurityGroupsRequest sgRequest;
	
	@Autowired
	private MonitorConfiguration configuration;
	
	public EC2ServiceImpl() {
		
	}
	
	@PostConstruct
	public void Configure() {
		ec2Client = Region
				.getRegion(configuration.getRegion())
				.createClient(AmazonEC2Client.class, null, null);
		List<String> tagValues = new ArrayList<>();
		tagValues.add(configuration.getTagValue());
		filter = new Filter(configuration.getTagKey(), tagValues);
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
	
	/*
	 * (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.monitoring.service.EC2Service#getSecurityGroups()
	 */
	@Override
	public List<SecurityGroup> getSecurityGroups() {
		return ec2Client.describeSecurityGroups(sgRequest.withFilters(filter)).getSecurityGroups();
	}
}
