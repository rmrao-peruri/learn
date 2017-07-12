package tools.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tools.jpa.data.Payment;
import tools.jpa.data.PaymentFull;
import tools.jpa.repo.PaymentFullRepository;
import tools.jpa.repo.PaymentRepository;

@Controller
@RequestMapping(value="/v1/pay-all")
public class PayFullService {
	@Autowired
	private PaymentFullRepository paymentFullRepository;

	@RequestMapping(method=RequestMethod.GET)
 	public @ResponseBody Iterable<PaymentFull> getAllPaymentsFull() {
		return paymentFullRepository.findAll();
	}

}
