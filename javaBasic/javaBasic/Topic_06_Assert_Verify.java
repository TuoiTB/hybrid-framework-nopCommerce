package javaBasic;

import static org.assertj.core.api.Assertions.*;

public class Topic_06_Assert_Verify {
	public static void main(String[] args) {
		Topic_06_Assert_Verify frodo = new Topic_06_Assert_Verify();
		Topic_06_Assert_Verify sauron = new Topic_06_Assert_Verify();
		// basic assertions
		assertThat(frodo.getName()).isEqualTo("Frodo");
		assertThat(frodo).isNotEqualTo(sauron);

		// chaining string specific assertions
		assertThat(frodo.getName()).startsWith("Fro")
		                           .endsWith("do")
		                           .isEqualToIgnoringCase("frodo");
	}
	public String getName() {
		return "frodo";
	}
}
