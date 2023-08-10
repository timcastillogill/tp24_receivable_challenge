package timcastillogill.tp24.receivables.repository;

import org.springframework.data.jpa.repository.Query;
import timcastillogill.tp24.receivables.models.Receivable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivableRepository extends JpaRepository<Receivable, Long> {

	@Query("SELECT SUM(r.openingValue) FROM Receivable r WHERE r.closedDate IS NULL")
	Double sumOpenInvoiceValue();


	@Query("SELECT SUM(r.openingValue) FROM Receivable r WHERE r.closedDate IS NOT NULL")
	Double sumClosedInvoiceValue();
}
