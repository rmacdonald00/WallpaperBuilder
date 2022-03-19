package backgrounds;

import processing.core.PApplet;

public class StripedBackground implements BackgroundBuilder{
	
	@Override
	public void drawBackground(PApplet sketch) {
		// TODO Auto-generated method stub
		System.out.println("draw backgorund");
		sketch.fill(20,200,20);
		sketch.rect(100, 20, 50, 50);
		
	}

}
