package providerManagers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import backgrounds.BackgroundBuilder;
import backgrounds.EquationBackground;
import backgrounds.StripedBackground;

public class BackgroundBuilderManager extends ProviderManager<BackgroundBuilder> {

	private BackgroundType backgroundType;
	private List<BackgroundBuilder> backgroundBuilders;

	public BackgroundBuilderManager() {
		String type = super.getConfigType("background");
		backgroundBuilders = new ArrayList<>();
		setManagersByType(type);
	}

	private void setManagersByType(String type) {
		switch (type) {
		case "striped":
			backgroundType = BackgroundType.STRIPED;
			backgroundBuilders.add(new StripedBackground());
			break;
		case "equation":
			backgroundType = BackgroundType.EQUATION;
			backgroundBuilders.add(new EquationBackground());
			break;
		case "random":
			backgroundType = BackgroundType.RANDOM;
			backgroundBuilders.add(new StripedBackground());
			backgroundBuilders.add(new EquationBackground());
			break;
		}
	}

	public enum BackgroundType {
		EQUATION, STRIPED, RANDOM
	}

	@Override
	public BackgroundBuilder getBuilder() {
		if(backgroundType == BackgroundType.RANDOM) {
			return backgroundBuilders.get(new Random().nextInt(backgroundBuilders.size()));
		}
		return backgroundBuilders.get(0);
	}

}
