package tools.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import tools.jpa.data.PaymentFull;

public interface PaymentFullRepository extends ReadOnlyRepository<PaymentFull, Long> {
	@Query(nativeQuery = true)
	public List<PaymentFull> findAll() ;

}
