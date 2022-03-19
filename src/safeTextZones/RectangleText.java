package safeTextZones;

import processing.core.PApplet;
import processing.core.PConstants;

public class RectangleText implements TextBuilder {

	private float[] rectangleCoordinates = null;

	@Override
	public void addText(PApplet sketch, String text) {
		drawTextZone(sketch);
		addTextOverZone(sketch, text);		
	}
	
	private void addTextOverZone(PApplet sketch, String text){
		float[] coords = getRectangleCoordinates(sketch);
		sketch.textAlign(PConstants.CENTER);
		sketch.fill(30, 245, 100);
		float yCenter = coords[1] + (coords[3] / 3);
		sketch.text(text, (float) (sketch.width * .45), yCenter);
	}
	
	private void drawTextZone(PApplet sketch) {
		sketch.fill(45, 45, 100);
		float[] coords = getRectangleCoordinates(sketch);
		
		//TODO: I think the lines from the striped background are adding a border around new border
		
		sketch.rect(coords[0], coords[1], coords[2], coords[3]);
	}

	private float[] getRectangleCoordinates(PApplet sketch) {
		if(rectangleCoordinates == null) {			
			rectangleCoordinates = new float[] {
					(float)0, (float)(sketch.height * .6), 
					(float)sketch.width, (float)(sketch.height * 0.1)};
		}
		return rectangleCoordinates;
	}
	
}
