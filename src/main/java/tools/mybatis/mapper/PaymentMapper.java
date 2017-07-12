package tools.mybatis.mapper;

import java.util.List;

import tools.mybatis.data.Payment;

public interface PaymentMapper {
	public List<Payment> findAll();
	public List<Payment> findAll(Payment p);
}
