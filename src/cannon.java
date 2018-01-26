import java.util.ArrayList;

public class cannon {
	private EZImage cannonPicture;
	private  int x, y;
	private int MAX_WIDTH, MAX_HEIGHT;
	public boolean pressed = false;
	fireworks temp;
	private ArrayList<fireworks> fws= new ArrayList<fireworks>();
	
	// Constructor for creating fireworks.
	public cannon(String filename, int width, int height) {
	
		//add fireworks in the cannon
		fws.add(new fireworks("Firework.png",width/2, height));
	
		//added cannon and place it bottom middle 
		cannonPicture = EZ.addImage(filename, width/2, height);
		MAX_WIDTH = width;
		MAX_HEIGHT = height;
		x = MAX_WIDTH/2;
		y = MAX_HEIGHT/2;
		cannonPicture.scaleTo(0.0008*MAX_HEIGHT); //Zac Hayashida
	}
	public void initlialize(){
		 
		//basically there is an array where one stay with the cannon, one goes up, and one is ready to go up
		for(int i=fws.size()-2;i>=0; i--){
			temp=fws.get(i);
			temp.moveUp(5);
			if(temp.getY() < 0){
			fws.remove(i);
			temp.cleanup();
			}
		}
		temp=fws.get(fws.size()-1);
	
		//when a is pressed 
		if(EZInteraction.isKeyDown('a')){
		
			//rotate left by -5
			cannonPicture.rotateBy(-5);
			temp.rot(-5);
		}
	
		//when d is pressed
		if(EZInteraction.isKeyDown('d')){
			//rotate right by 5
			cannonPicture.rotateBy(5);
			temp.rot(5);
		} else if (EZInteraction.wasKeyReleased('d')) {
			//System.out.println("but d was released");
		}
	}
	

	
	public int getFireworkX(){
		return temp.getX();
	}
	public int getFireworkY(){
		return temp.getY();
	}
	public void shoot(){
      
		//press s to shoot
        if(EZInteraction.wasKeyReleased('s')){
        	//add fireworks
            fws.add(new fireworks("Firework.png",MAX_WIDTH/2, MAX_HEIGHT));
        System.out.println(temp.getX());
        
            //update the fireworks rotation 
            fws.get(fws.size()-1).rot(cannonPicture.rotationInDegrees);
        
            //cannon is in front of the fireworks because fireworks is inside
            cannonPicture.pullToFront();
        }
    }
}	