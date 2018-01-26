// Joshua Lee
import java.util.Random;

public class Present {

	private EZImage present;
	private EZImage present2;
	private EZSound sound;
	private String pictureName;
	private static int x, y;
	private int directionY = 20;
	private int MAX_HEIGHT;
	private int GRAVITY = 10;
	private int TERMINAL_VELOCITY = 100;
	private boolean dropping;
	
	// Constructor
	public Present (String name, int height){
		present = EZ.addImage(name, 0, 0);
		present2=EZ.addImage("explosion.png", 0, 0);
		present2.hide();
		present.hide();
		MAX_HEIGHT = height;
		present.scaleTo(0.00009*MAX_HEIGHT);
		present2.scaleTo(0.0002*MAX_HEIGHT);
		dropping = false;
		
	}
	
	// Function
	public void drop(int santaX, int santaY){
		
		
		if (dropping == false){
		
		present.translateTo(santaX, santaY);
		present.show();
		x = santaX;
		y = santaY;
		
		dropping = true;
		}
		
		if (dropping == true){
		// Move it
		present.translateTo(x, y); 
		y = y+directionY;
		
		if(y > MAX_HEIGHT){
			present.hide();		
			present.translateTo(0, 0);
			dropping = false;
		}
		//EZ.refreshScreen();
		}
	}
	//hide present and show explosion
	public void hide(){
		present2.show();
		present2.translateTo(x, y);
		present.hide();
		present.translateTo(0, 0);
		dropping = false;
	}
	// check if object is inside
	public boolean destroyed(int x, int y){
		return present.isPointInElement(x, y);
	}
	// return position of x and y by Zac Hayashida
	public int getX(){
		return x;
	}
	public int getY() {
		return y;
	}
	
}
