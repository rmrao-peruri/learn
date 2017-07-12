package tools.mybatis.data;

import tools.mybatis.data.PaymentDebtor;

public class Payment {
	private Integer id;
	
	private String ccy;
	
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
