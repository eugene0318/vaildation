package hello.itemservice.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

public class MessageCodesResolverTest {

	MessageCodesResolver codeResolver = new DefaultMessageCodesResolver();

	@Test
	void messageCodesResolverObject() {
		String[] messageCodes = codeResolver.resolveMessageCodes("required", "item");

		assertThat(messageCodes).containsExactly("required.item", "required");
	}

	@Test
	void messageCodesResolverField() {
		String[] messageCodes = codeResolver.resolveMessageCodes("required", "item", "itemName", String.class);
		for (String messageCode : messageCodes) {
			System.out.println(messageCode);
		}

		assertThat(messageCodes).containsExactly("required.item.itemName", "required.itemName",
				"required.java.lang.String", "required");
	}

}
