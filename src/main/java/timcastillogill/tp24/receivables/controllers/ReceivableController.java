package timcastillogill.tp24.receivables.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import timcastillogill.tp24.receivables.models.Receivable;
import timcastillogill.tp24.receivables.repository.ReceivableRepository;

import java.util.List;

@RestController
public class ReceivableController {
	@Autowired
	final ReceivableRepository receivableRepository;

	public ReceivableController(ReceivableRepository receivableRepository) {
		this.receivableRepository = receivableRepository;
	}

	@PostMapping("/receivables")
	public ResponseEntity<String> storeRecievables(@RequestBody List<Receivable> payload) {
		receivableRepository.saveAll(payload);

		return ResponseEntity.ok("Recievables data stored successfully");
	}
}
