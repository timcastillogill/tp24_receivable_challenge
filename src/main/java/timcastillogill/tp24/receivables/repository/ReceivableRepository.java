package timcastillogill.tp24.receivables.repository;

import timcastillogill.tp24.receivables.models.Receivable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivableRepository extends JpaRepository<Receivable, Long> {
}
