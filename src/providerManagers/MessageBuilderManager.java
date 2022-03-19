package providerManagers;

import messages.MessageBuilder;
import messages.MessageOptions;

public class MessageBuilderManager extends ProviderManager<MessageBuilder> {
	
	private String affirmationsFilepath = "./config/messageData/AffirmationMessageOptions.json";
	
	private MessageBuilder messageGenerator;

	public MessageBuilderManager() {
		String type = super.getConfigType("messages");
		setBuilderByType(type);
	}
	
	private void setBuilderByType(String type) {
		switch (type) {
		case "affirmations":
			messageGenerator = new MessageOptions(affirmationsFilepath);
			break;
		default:
			messageGenerator = new MessageOptions();
		}
	}

	@Override
	public MessageBuilder getBuilder() {
		return messageGenerator;
	}

}
