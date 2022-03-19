import backgrounds.BackgroundBuilder;
import messages.MessageGenerator;
import providerManagers.BackgroundBuilderManager;
import providerManagers.MessageGeneratorManager;
import providerManagers.ProviderManager;

public class GodClass {
	
	private static ProviderManager<BackgroundBuilder> backgroundBuilderManager;
	private static ProviderManager<MessageGenerator> messageGeneratorManager;
	
	
	public static ProviderManager<BackgroundBuilder> getBackgroundBuilderManager() {
		if(backgroundBuilderManager == null) {
			backgroundBuilderManager = new BackgroundBuilderManager();
		}
		return backgroundBuilderManager;
	}
	
	public static ProviderManager<MessageGenerator> getMessageGeneratorManager() {
		if(messageGeneratorManager == null) {
			messageGeneratorManager = new MessageGeneratorManager();
		}
		return messageGeneratorManager;
	}

}
