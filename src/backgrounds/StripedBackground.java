package backgrounds;

import java.util.Random;

import processing.core.PApplet;

public class StripedBackground implements BackgroundBuilder {
	
	private Random random = new Random();
	private int spaceBetweenLines = 0;
	
	@Override
	public void drawBackground(PApplet sketch) {
		System.out.println("draw backgorund");
		setStroke(sketch);
		
		try {
			drawLinesWithAngle(sketch, getAngle());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setStroke(PApplet sketch) {
		sketch.stroke(random.nextInt(255));
		int weight = random.nextInt(getSpaceBetweenLines(sketch) / 2);
		System.out.println("stroke weight = " + weight);
		sketch.strokeWeight(weight);
		sketch.strokeCap(sketch.PROJECT);
	}
	
	private int getSpaceBetweenLines(PApplet sketch) {
		if(spaceBetweenLines == 0) {
			spaceBetweenLines = 2 + random.nextInt(Math.min(sketch.width, sketch.height) / 3);
			System.out.println("Space bt = " + spaceBetweenLines);
		}
		return spaceBetweenLines;
	}
	private float getAngle() {
		return random.nextInt(180) - 90;
	}
	
	
	private void drawLinesWithAngle(PApplet sketch, float angleInDeg) throws Exception {
		if(angleInDeg > 90 || angleInDeg < -90) throw new Exception("Bad angle in shape background");
		float angleInRads = sketch.radians(angleInDeg);
		float slope = sketch.tan(angleInRads);
		
		
		if(angleInDeg < -45 || angleInDeg > 45) {
			drawLinesFromTop(sketch, angleInDeg, slope);
		} else {
			drawLinesFromSide(sketch, angleInDeg, slope);
		}	
		
	}


	private void drawLinesFromTop(PApplet sketch, float angleInDeg, float slope) {
		//vert
		float changeInWidth = sketch.height / slope;
		
		if(angleInDeg < 0) {
			drawVerticalLines(sketch, 0, sketch.width + Math.abs(changeInWidth), changeInWidth);
		} else {
			drawVerticalLines(sketch, -Math.abs(changeInWidth), sketch.width, changeInWidth);
		}
	}
	
	private void drawVerticalLines(PApplet sketch, float startingI, float endingI, float xSlope) {
		float increment = getSpaceBetweenLines(sketch);
		for(float i = startingI; i < endingI; i+= increment) {
			sketch.line(i, 0, i + xSlope, sketch.height);
		}
	}


	private void drawLinesFromSide(PApplet sketch, float angleInDeg, float slope) {
		//horiz
		float changeInHeight = sketch.width * slope;
		if(angleInDeg < 0) {
			drawHorizontalLines(sketch, 0, sketch.height + Math.abs(changeInHeight), changeInHeight);
		} else {
			drawHorizontalLines(sketch, -Math.abs(changeInHeight), sketch.height, changeInHeight);
		}
	}
	
	private void drawHorizontalLines(PApplet sketch, float startingI, float endingI, float ySlope) {
		float increment = getSpaceBetweenLines(sketch);
		for(float i = startingI; i < endingI; i+= increment) {
			sketch.line(0, i, sketch.width, i + ySlope);
		}
	}

}
