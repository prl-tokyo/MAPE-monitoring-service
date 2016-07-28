package jp.ac.nii.prl.mape.monitoring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	public long id;
	private String key;
	private String value;
	
	@ManyToOne
	private Instance instance;
	
	public Instance getInstance() {
		return instance;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	}

	public String getKey(){
		return key;
	}
	
	public String getValue(){
		return value;
	}
	
	public void setKey(String key){
	   this.key = key;
	}
	
	public void setValue(String value){
		this.value = value;
	}
}



