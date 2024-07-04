package ac.su.paykiosk.repository;

import ac.su.paykiosk.domain.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
