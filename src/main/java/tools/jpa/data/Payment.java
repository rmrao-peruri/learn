package tools.jpa.data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
public class Payment {
	@Id
	@Column( name="payment_id")
	private Integer id;
	
	@Column( name="CCY")
	private String ccy;
	
	@Embedded
	private PaymentDebtor dbtr;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public PaymentDebtor getDbtr() {
		return dbtr;
	}
	public void setDbtr(PaymentDebtor dbtr) {
		this.dbtr = dbtr;
	}
}
