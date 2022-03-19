import backgrounds.BackgroundBuilder;
import messages.MessageBuilder;
import providerManagers.BackgroundBuilderManager;
import providerManagers.MessageBuilderManager;
import providerManagers.ProviderManager;
import providerManagers.TextBuilderManager;
import safeTextZones.TextBuilder;

public class GodClass {
	
	private static ProviderManager<BackgroundBuilder> backgroundBuilderManager;
	private static ProviderManager<MessageBuilder> messageGeneratorManager;
	private static ProviderManager<TextBuilder> textBuilderManager;
	
	
	public static ProviderManager<BackgroundBuilder> getBackgroundBuilderManager() {
		if(backgroundBuilderManager == null) {
			backgroundBuilderManager = new BackgroundBuilderManager();
		}
		return backgroundBuilderManager;
	}
	
	public static ProviderManager<MessageBuilder> getMessageBuilderManager() {
		if(messageGeneratorManager == null) {
			messageGeneratorManager = new MessageBuilderManager();
		}
		return messageGeneratorManager;
	}
	
	public static ProviderManager<TextBuilder> getTextBuilderManager() {
		if(textBuilderManager == null) {
			textBuilderManager = new TextBuilderManager();
		}
		return textBuilderManager;
	}

}
