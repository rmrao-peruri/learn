package tools.jpa.data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="PaymentFull.findAll",
	    query=" SELECT a.payment_id, a.ccy, a.dbtr_name, a.dbtr_ac_id, "
	    		+ "    b.vpa AS vpa " 
	    		+ " FROM   payment a "
                + " LEFT OUTER JOIN payment_addl_dtl b"
                + " ON     b.payment_id = a.payment_id " ,
	    resultClass=tools.jpa.data.PaymentFull.class)

public class PaymentFull {
	@Id
	@Column( name="payment_id")
	private Integer id;
	
	private String ccy;
	
	@Embedded
	private PaymentDebtor dbtr;
	
	private String vpa;
	
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
	
	public String getVpa() {
		return vpa;
	}
	public void setVpa(String vpa) {
		this.vpa = vpa;
	}
}
