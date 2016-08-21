package jp.ac.nii.prl.mape.monitoring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instance {

	@GeneratedValue
	@Id
	@JsonIgnore
	private Long id;
	
	private String instID;
	
	private String instType;
	
	private String ami;
	
	private Integer state;
	
	private Integer instStatus;
	
	private String securityGroupRef;
	
	private String platform;
	
	@OneToMany(mappedBy="instance")
	private List<Tag> tags;
	
	private Date launchTime;
	private Boolean ebsOptimized;
	
	@OneToOne
	private Monitoring monitoring;
	
	@JsonIgnore
	private String rootDeviceName;
	
	private Integer amiLaunchIndex;
	
	private Double load;
	
	private Integer instResponseTime;
	
	private String architecture;

	@OneToMany(mappedBy="instance")
	private List<InstanceBlockDeviceMapping> blockDeviceMapping;

	private String clientToken;

	private Boolean enaSupport;
	
	private String hypervisor;

	@OneToOne
	private IamInstanceProfile iamInstanceProfile;
	
	private String imageId;
	
	private String kernelId;
	
	private String keyName;
	
	@OneToMany(mappedBy="instance")
	private List<InstanceNetworkInterface> networkInterface;
	
	@OneToOne
	private Placement placement;
	
	@JsonIgnore
	@ManyToOne
	private Model model;

	public String getAmi() {
		return ami;
	}
	
	public Integer getAmiLaunchIndex() {
		return amiLaunchIndex;
	}

	
	public String getArchitecture() {
		return architecture;
	}
	
	public List<InstanceBlockDeviceMapping> getBlockDeviceMapping() {
		return blockDeviceMapping;
	}

	public List<InstanceBlockDeviceMapping> getBlockDeviceMappings() {
		return blockDeviceMapping;
	}

	public String getClientToken() {
		return clientToken;
	}

	public Boolean getEbsOptimized() {
		return ebsOptimized;
	}

	public Boolean getEnaSupport() {
		return enaSupport;
	}

	public String getHypervisor() {
		return hypervisor;
	}

	public IamInstanceProfile getIamInstanceProfile() {
		return iamInstanceProfile;
	}

	public Long getId() {
		return id;
	}

	public String getImageId() {
		return imageId;
	}

	public String getInstID() {
		return instID;
	}
	
	public Integer getInstResponseTime() {
		return instResponseTime;
	}
	
	public Integer getInstStatus() {
		return instStatus;
	}

	public String getInstType() {
		return instType;
	}

	public String getKernelId() {
		return kernelId;
	}

	public String getKeyName() {
		return keyName;
	}

	public Date getLaunchTime() {
		return launchTime;
	}

	public Double getLoad() {
		return load;
	}

	public Model getModel() {
		return model;
	}

	public Monitoring getMonitoring() {
		return monitoring;
	}

	public List<InstanceNetworkInterface> getNetworkInterface() {
		return networkInterface;
	}
	
	public Placement getPlacement() {
		return placement;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public String getRootDeviceName() {
		return rootDeviceName;
	}

	public String getSecurityGroupRef() {
		return securityGroupRef;
	}

	public Integer getState() {
		return state;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setAmi(String ami) {
		this.ami = ami;
	}

	public void setAmiLaunchIndex(Integer amiLaunchIndex) {
		this.amiLaunchIndex = amiLaunchIndex;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public void setBlockDeviceMapping(List<InstanceBlockDeviceMapping> blockDeviceMapping) {
		this.blockDeviceMapping = blockDeviceMapping;
	}

	public void setClientToken(String clientToken) {
		this.clientToken = clientToken;
	}

	public void setEbsOptimized(Boolean ebsOptimized) {
		this.ebsOptimized = ebsOptimized;
	}

	public void setEnaSupport(Boolean enaSupport) {
		this.enaSupport = enaSupport;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	public void setIamInstanceProfile(IamInstanceProfile iamInstanceProfile) {
		this.iamInstanceProfile = iamInstanceProfile;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void setInstID(String instID) {
		this.instID = instID;
	}

	public void setInstResponseTime(Integer instResponseTime) {
		this.instResponseTime = instResponseTime;
	}

	public void setInstStatus(Integer instStatus) {
		this.instStatus = instStatus;
	}

	public void setInstType(String instType) {
		this.instType = instType;
	}

	public void setKernelId(String kernelId) {
		this.kernelId = kernelId;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public void setLaunchTime(Date launchTime) {
		this.launchTime = launchTime;
	}

	public void setLoad(Double load) {
		this.load = load;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setMonitoring(Monitoring monitoring) {
		this.monitoring = monitoring;
	}

	public void setNetworkInterface(List<InstanceNetworkInterface> networkInterface) {
		this.networkInterface = networkInterface;
	}

	public void setPlacement(Placement placement) {
		this.placement = placement;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public void setRootDeviceName(String rootDeviceName) {
		this.rootDeviceName = rootDeviceName;
	}

	public void setSecurityGroupRef(String securityGroupRef) {
		this.securityGroupRef = securityGroupRef;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setTags(List<Tag> tags) {
		this.tags =  tags;
	}

	public Instance withRootDeviceName(String rootDeviceName){
		return this;
	}

}
