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
	
	public String getPlatform() {
		return platform;
	}

	public String getAmi() {
		return ami;
	}

	public Long getId() {
		return id;
	}

	public String getInstID() {
		return instID;
	}

	public Integer getInstStatus() {
		return instStatus;
	}

	public String getInstType() {
		return instType;
	}

	public Double getLoad() {
		return load;
	}

	public Model getModel() {
		return model;
	}

	public String getSecurityGroupRef() {
		return securityGroupRef;
	}

	public Integer getState() {
		return state;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setAmi(String ami) {
		this.ami = ami;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInstID(String instID) {
		this.instID = instID;
	}

	public void setInstStatus(Integer instStatus) {
		this.instStatus = instStatus;
	}

	public void setInstType(String instType) {
		this.instType = instType;
	}

	public void setLoad(Double load) {
		this.load = load;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setSecurityGroupRef(String securityGroupRef) {
		this.securityGroupRef = securityGroupRef;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
	public void setTags(List<Tag> tags) {
	// TODO Auto-generated method stub
		this.tags =  tags;
	}
	
	public Date getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(Date launchTime) {
		this.launchTime = launchTime;
	}

	public Monitoring getMonitoring() {
		return monitoring;
	}

	public void setMonitoring(Monitoring monitoring) {
		this.monitoring = monitoring;
	}

	public Boolean getEbsOptimized() {
		return ebsOptimized;
	}

	public void setEbsOptimized(Boolean ebsOptimized) {
		this.ebsOptimized = ebsOptimized;
	}

	public String getRootDeviceName() {
		return rootDeviceName;
	}

	public void setRootDeviceName(String rootDeviceName) {
		this.rootDeviceName = rootDeviceName;
	}

	public Instance withRootDeviceName(String rootDeviceName){
		return this;
	}

	public Integer getAmiLaunchIndex() {
		return amiLaunchIndex;
	}

	public void setAmiLaunchIndex(Integer amiLaunchIndex) {
		this.amiLaunchIndex = amiLaunchIndex;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}
	
	public List<InstanceBlockDeviceMapping> getBlockDeviceMappings() {
		return blockDeviceMapping;
	}

	public void setBlockDeviceMapping(List<InstanceBlockDeviceMapping> blockDeviceMapping) {
		this.blockDeviceMapping = blockDeviceMapping;
	}

	public String getClientToken() {
		return clientToken;
	}

	public void setClientToken(String clientToken) {
		this.clientToken = clientToken;
	}

	public Boolean getEnaSupport() {
		return enaSupport;
	}

	public void setEnaSupport(Boolean enaSupport) {
		this.enaSupport = enaSupport;
	}

	public String getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	public IamInstanceProfile getIamInstanceProfile() {
		return iamInstanceProfile;
	}

	public void setIamInstanceProfile(IamInstanceProfile iamInstanceProfile) {
		this.iamInstanceProfile = iamInstanceProfile;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getKernelId() {
		return kernelId;
	}

	public void setKernelId(String kernelId) {
		this.kernelId = kernelId;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public List<InstanceNetworkInterface> getNetworkInterface() {
		return networkInterface;
	}

	public void setNetworkInterface(List<InstanceNetworkInterface> networkInterface) {
		this.networkInterface = networkInterface;
	}

	public Placement getPlacement() {
		return placement;
	}

	public void setPlacement(Placement placement) {
		this.placement = placement;
	}

}
