// Joshua Lee
public class Santa {
		
		// Variables that we need for Santa
		private EZImage santa, santa2;
		private EZSound sound;
		private int x, y;
		private int MAX_HEIGHT, MAX_WIDTH;
		private int directionX = 10;
		private double scale,scaleBy;
		private double scaleP,scalePBy;
		private boolean moving;
		
		// Constructor
		public Santa(String santa,String santa2, int width, int height){ // Remember to add the sound when you find a sound
			
			// Insert the image
			this.santa = EZ.addImage(santa, width, height);
			this.santa2 = EZ.addImage(santa2, width, height);
			this.santa2.hide();
			this.sound = EZ.addSound("hohoho.wav");
			sound.play();
			
			// Grabs the initial position of the Santa.
			this.x = width /2;
			this.y = height /8;
			
			// Keeps track of how big the screen is. For later use.
			this.MAX_HEIGHT = height;
			this.MAX_WIDTH = width;
			
			// Scale the image to be the right size for the game.
			
			// For santasleigh.png and santasleigh2.png use this
			//scale = 0.0005 * MAX_WIDTH;
			
			// For santa1.png and santa2.png use this
			scale = 0.0004*MAX_WIDTH; 
			
			
			this.santa.scaleBy(scale);
			this.santa2.scaleBy(scale);
			
			System.out.println(scale);
			
			// Set moving to false
			moving = false;
		}
		
		// Getting the position of Santa if needed
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}
		public boolean moving(){
			return moving;
		}
		// Move function for Santa
		public void move(){
				if (moving == false){
					moving = true;
				}
					
				// Move Santa
				if (moving == true){
					santa.translateTo(x, y); 
					santa2.translateTo(x, y);
					x = x+directionX;
					if(x > MAX_WIDTH){
						directionX = -directionX;
						santa.hide();
						santa2.show();
						//santa.rotateBy(180);
					}
					if(x < 0){
						directionX = -directionX;
						santa.show();
						santa2.hide();
						//santa.rotateBy(180);
					}
				//EZ.refreshScreen();
				}
			}
		
		// Stop Santa if needed
		public void stop(){
			moving = false;
		}
		public void play(){
			sound.play();
		}
}
