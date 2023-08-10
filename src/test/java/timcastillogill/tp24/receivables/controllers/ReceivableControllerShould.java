package timcastillogill.tp24.receivables.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import timcastillogill.tp24.receivables.models.Receivable;
import timcastillogill.tp24.receivables.repository.ReceivableRepository;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReceivableController.class)
public class ReceivableControllerShould {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ReceivableRepository receivableRepository;

	@Test
	public void when_recievable_endpoint_hit_store_payload_in_receivable_table() throws Exception {
		List<Receivable> payload = Arrays.asList(
				new Receivable(
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
				),

				new Receivable(
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
				)
		);
		String payloadJSON = objectMapper.writeValueAsString(payload);

		ResultActions resultActions = mockMvc.perform(
				post("/receivables")
						.contentType(MediaType.APPLICATION_JSON)
						.content(payloadJSON)
		);
		resultActions.andExpect(status().isOk());
	}

	@Test
	public void when_summary_endpoint_is_called_return_summary_statistics() throws Exception {
		when(receivableRepository.sumOpenInvoiceValue()).thenReturn(12345.67);
		when(receivableRepository.sumClosedInvoiceValue()).thenReturn(987.54);

		ResultActions resultActions = mockMvc.perform(
				get("/summary")
						.contentType(MediaType.APPLICATION_JSON)
		);
		resultActions
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.totalOpenValue").value(12345.67))
				.andExpect(jsonPath("$.totalClosedValue").value(987.54));
	}
}
