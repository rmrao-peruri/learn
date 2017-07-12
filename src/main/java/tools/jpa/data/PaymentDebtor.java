package tools.jpa.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PaymentDebtor {
	@Column( name="dbtr_ac_id")
	private String acId;
	
	@Column( name="dbtr_name")
	private String name;
	
	public String getAcId() {
		return acId;
	}
	public void setAcId(String dbtrAcId) {
		this.acId = dbtrAcId;
	}
	public String getName() {
		return name;
	}
	public void setName(String dbtrName) {
		this.name = dbtrName;
	}

}
