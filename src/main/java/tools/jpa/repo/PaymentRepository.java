package tools.jpa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import tools.jpa.data.Payment;

@Transactional(isolation = Isolation.READ_COMMITTED)
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
