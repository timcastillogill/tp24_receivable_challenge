package timcastillogill.tp24.receivables.models;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import timcastillogill.tp24.receivables.repository.ReceivableRepository;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReceivableShould {

	@Autowired
	private ReceivableRepository receivableRepository;

	@Test
	@Transactional
	public void given_a_payload_of_one_receivable_it_should_add_data_to_the_receivable_table() {
		Receivable apple_receivable = new Receivable(
				"123456",
				"GBP",
				"23/01/2020",
				1234.56,
				1234.56,
				"23/02/2020",
				null,
				true,
				"Apple",
				"asdfsadf",
				"5 Farringdon",
				"New Walk",
				"London",
				null,
				null,
				"UK",
				null
		);
		receivableRepository.save(apple_receivable);
		Receivable savedReceivable = receivableRepository.getOne(1L);
		assertThat(savedReceivable).isNotNull();
		assertThat(savedReceivable.getReference()).isEqualTo("123456");
		assertThat(savedReceivable.getDebtorName()).isEqualTo("Apple");
	}

	@Test
	@Transactional
	public void given_a_payload_of_two_receivables_it_should_add_data_to_the_receivable_table() {
		Receivable apple_receivable = new Receivable(
				"123456",
				"GBP",
				"23/01/2020",
				1234.56,
				1234.56,
				"23/02/2020",
				null,
				true,
				"Apple",
				"Apple_Ref",
				"5 Farringdon",
				"New Walk",
				"London",
				null,
				null,
				"UK",
				null
		);

		Receivable google_receivable = new Receivable(
				"23456",
				"USD",
				"23/01/2020",
				200.00,
				100.00,
				"23/02/2020",
				null,
				true,
				"Google",
				"Google_Ref",
				"5 Noddy",
				"New Walk",
				"London",
				null,
				null,
				"USA",
				null
		);
		receivableRepository.save(google_receivable);
		receivableRepository.save(apple_receivable);
		Receivable googleSavedReceivable = receivableRepository.getOne(2L);
		assertThat(googleSavedReceivable).isNotNull();
		assertThat(googleSavedReceivable.getReference()).isEqualTo("23456");
		assertThat(googleSavedReceivable.getDebtorName()).isEqualTo("Google");
	}
}
