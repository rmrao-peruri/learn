package tools.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tools.jpa.data.Payment;
import tools.jpa.data.PaymentFull;
import tools.jpa.repo.PaymentRepository;

@Controller
@RequestMapping(value="/v1")
public class PayService {
	@Autowired
	private PaymentRepository paymentRepository;

	@RequestMapping(value="/pay", method=RequestMethod.GET)
 	public @ResponseBody Iterable<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}
}
