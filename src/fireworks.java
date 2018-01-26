
public class fireworks {
	//
	private EZImage fireworksPicture;
	private static int x, y;
	private boolean launched; 
	public boolean pressed = false;
	
	// Constructor for creating fireworks.
		public fireworks(String filename, int posx, int posy) {
			fireworksPicture = EZ.addImage(filename, posx, posy);
			fireworksPicture.rotateBy(-90);
			fireworksPicture.scaleTo(0.6);// Zac Hayashida
			//position for fireworks
			x = posx;
			y = posy;
			launched = false; //boolean make it false because not needed right here 
		}
		
		// Accessor method to retrieve the position of the fireworks.
		public int getX() {
			return x; //return x for fireworks
		}

		public int getY() {
			return y; //return y for fireworks 
		}
		
		//setting fireworks position
		private void setImagePosition(int posx, int posy) {
			fireworksPicture.translateTo(posx, posy);
		}
		
		//code to make it move up 
		public void moveUp(int step) {
			fireworksPicture.moveForward(step+20);;
			x=fireworksPicture.getXCenter();
			y=fireworksPicture.getYCenter();
		}
		
		//code to make it rotate
		public void rot(double ang){
			fireworksPicture.rotateBy(ang);
		}
		//remove firework pictures
		public void cleanup() {
			EZ.removeEZElement(fireworksPicture);
		}
		
	
}
