import java.awt.Color;

//Zac Hayashida
public class HOUSE {

	private static int x;
	private static int y;
	private EZImage house;
	private EZImage housef;
	private EZLine line;
	
	
	//Constructer for house and lines setting them apart
	public HOUSE(String filename, String filename2, int posx, int posy, int linex, int liney, int linex2, int liney2) {
		x=posx;
		y=posy;
		housef=EZ.addImage("chouse.png",posx, posy);
		housef.hide();
		house= EZ.addImage(filename, posx, posy);
		line =EZ.addLine(linex, liney, linex2,  liney2, Color.GREEN, 15);	
	
		
	}
	//Create a happy meter when houses recieve a gift
		void happy () {
		line.setPoint2(line.getX2() , line.getY2()-35);
		
	}
		//get Y coordianate of line
	public int lGetY() {
		return line.getY2();
	}
	//show festive house
		void festive(){
			housef.show();
			EZ.removeEZElement(house);
	}

	//A boolean to activate happy() in the main by checking if object is inside house
	public boolean recieved(int posx, int posy) {
		return house.isPointInElement(posx, posy);
	}
}