package backgrounds;

import java.util.function.Function;

import processing.core.PApplet;

public class EquationBackground implements BackgroundBuilder {

	@Override
	public void drawBackground(PApplet sketch) {
		// TODO Auto-generated method stub
		drawFucntion(sketch, getFunction());
		
	}
	
	private void drawFucntion(PApplet sketch, Function<int[], Integer> fucntion) {
		sketch.loadPixels();
		System.out.println(sketch.width + " " + sketch.height);
		for (int i = 0; i < sketch.width; i++) {
			for(int j = 0; j < sketch.height; j++) {
				sketch.pixels[i+j*sketch.width] = sketch.color((int) ((fucntion.apply(new int[] {i+100,j}) + 1.0) * 255/2.0));
			}
		}
		sketch.updatePixels();
	}
	
	private Function<int[], Integer> getFunction() {
		Function<int[], Integer> function = (x -> {
			int val = 2*x[0] + x[1] + x[0]*x[1] - x[0]*x[0]*x[0]/10;
			if (val > 255) {
				val /= 255; 
			}
			return val;
		});
		return function;
	}

}
