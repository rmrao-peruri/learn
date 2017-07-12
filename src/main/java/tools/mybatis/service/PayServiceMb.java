package tools.mybatis.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tools.mybatis.data.Payment;
import tools.mybatis.mapper.PaymentMapper;

@Controller
@RequestMapping(value="/v1/pay-mybatis")
public class PayServiceMb {
	@Autowired
	private PaymentMapper paymentMapper;
	
	@Autowired
	private Map<String, SqlSessionFactory> allSqlSessionFactory ;

	@RequestMapping(method=RequestMethod.GET)
 	public @ResponseBody Iterable<Payment> getAllPaymentsFull() {
		return paymentMapper.findAll();
	}

	@RequestMapping(value="/{paymentId}", method=RequestMethod.GET)
 	public @ResponseBody Iterable<Payment> getPayment(
 	    @PathVariable Integer paymentId) {
		Payment p = new Payment();
		p.setId(paymentId);
		return paymentMapper.findAll(p);
	}

	@RequestMapping(value="/sg", method=RequestMethod.GET)
 	public @ResponseBody Iterable<Payment> getAllPaymentsFullSg() {
		return paymentMapper.findAll();
	}
	@RequestMapping(value="/my", method=RequestMethod.GET)
 	public @ResponseBody Iterable<Payment> getAllPaymentsFullMy() {
		return paymentMapper.findAll();
	}
}
