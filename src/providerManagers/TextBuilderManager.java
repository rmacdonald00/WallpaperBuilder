package providerManagers;

import safeTextZones.RectangleText;
import safeTextZones.TextBuilder;

public class TextBuilderManager extends ProviderManager<TextBuilder> {

	private TextBuilder textZoneBuilder;
	
	public TextBuilderManager() {
		String type = super.getConfigType("safetextzone");
		setBuilderByType(type);
	}
	
	private void setBuilderByType(String type) {
		switch (type) {
		case "rectangle":
			textZoneBuilder = new RectangleText();
			break;
		default:
			textZoneBuilder = new RectangleText();
		}		
	}

	@Override
	public TextBuilder getBuilder() {
		return textZoneBuilder;
	}

}
