package providerManagers;

import messages.MessageGenerator;
import messages.MessageOptions;

public class MessageGeneratorManager extends ProviderManager<MessageGenerator> {
	
	private String affirmationsFilepath = "./src/config/messageData/AffirmationMessageOptions.json";
	
	private MessageGenerator messageGenerator;
	
	private enum MessageType {
		AFFIRMATIONS
	}
	
	public MessageGeneratorManager() {
		String type = super.getConfigType("messages");
		setGeneratorByType(type);
	}
	
	private void setGeneratorByType(String type) {
		switch (type) {
		case "affirmations":
			messageGenerator = new MessageOptions(affirmationsFilepath);
			break;
		default:
			messageGenerator = new MessageOptions();
		}
	}

	@Override
	public MessageGenerator getBuilder() {
		return messageGenerator;
	}

}
