package messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MessageOptionsTest {

	private MessageOptions messageOptions;

	@Test
	void GivenListOfPhrases_GetAllMessages_ReturnsAllCombinations() {
		//Arrange
		List<List<String>> phraseBuildingBlocks = new ArrayList<List<String>>(
				Arrays.asList(
					new ArrayList<String>(Arrays.asList("a", "b")),
					new ArrayList<String>(Arrays.asList("1", "2", "")),
					new ArrayList<String>(Arrays.asList("-", "+"))));		
		messageOptions = new MessageOptions(phraseBuildingBlocks);
		
		List<String> expectedMessages = new ArrayList<String>(
				Arrays.asList(
						"a\n1\n-", "a\n1\n+",
						"a\n2\n-", "a\n2\n+",
						"a\n-", "a\n+",
						"b\n1\n-", "b\n1\n+",
						"b\n2\n-", "b\n2\n+",
						"b\n-", "b\n+"));
		
		//Act
		List<String> actualMessages = messageOptions.getAllMessages();
		
		//Assert
		Assert.assertArrayEquals(expectedMessages.toArray(), actualMessages.toArray());
	}

}
