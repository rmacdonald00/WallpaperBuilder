import processing.core.PApplet;

public class Main  extends PApplet {

	  static public void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "WallpaperBuilder" };
	    if (passedArgs != null) {
	      PApplet.main(concat(appletArgs, passedArgs));
	    } else {
	      PApplet.main(appletArgs);
	    }
	    System.out.println("end of main");
	  }
}
