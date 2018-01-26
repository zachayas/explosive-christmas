import java.awt.Color;

public class MainGame {

	public static void main(String[] args) {
		// initialize backgrounds and Intro card
		EZ.initialize(1366, 768);
		EZ.setFrameRate(30);
		EZ.addImage("snow.png", 1366 / 2, 768 / 2);
		EZText text = EZ.addText(1366 / 2, 768 / 3, "Explosive Christmas", Color.GREEN, 90);
		EZText text2 = EZ.addText(1366 / 2, 680 / 2, "PRESS Z TO START", Color.RED, 65);
		EZText text3 = EZ.addText(1366 / 2, 810 / 2, "PRESS 'A' & 'D' TO MOVE", Color.GREEN, 65);
		EZText text4 = EZ.addText(1366 / 2, 470, "PRESS 'S' TO SHOOT", Color.RED, 65);
		EZSound tune = EZ.addSound("ctune.wav");
	
		// 4 homes are initialized
		HOUSE home = new HOUSE("house.png", "chouse.png", 136, 672, 128 * 2, 768, 128 * 2, 768);
		HOUSE home2 = new HOUSE("house.png", "chouse.png", 136 * 3, 672, 131 * 4, 768, 131 * 4, 768);
		HOUSE home3 = new HOUSE("house.png", "chouse.png", 136 * 7, 672, 134 * 8, 768, 134 * 8, 768);
		HOUSE home4 = new HOUSE("house.png", "chouse.png", 136 * 9, 672, 134 * 10, 768, 134 * 10, 768);
		
		// Initialize Santa, Present, and Cannon
		Santa santa = new Santa("santa.png", "santaf.png", 1366, 900);
		Present gift = new Present("present.png", 768);
		cannon can = new cannon("cannon.png", 1380, 700);
		Boolean start = false;
		tune.loop();
		//do loop to start the game
		do {

			if (EZInteraction.wasKeyReleased('z')) {
				start = true;
				EZ.removeEZElement(text);
				EZ.removeEZElement(text2);
				EZ.removeEZElement(text3);
				EZ.removeEZElement(text4);
			}
			EZ.refreshScreen();
		} while (start == false);
		//start the game and initialize objects
		while (start) {
			can.initlialize();
			can.shoot();
			santa.move();
			gift.drop(santa.getX(), santa.getY());
			//destroy gift if hit by firewrok
			if (gift.destroyed(can.getFireworkX(), can.getFireworkY())) {
				gift.hide();
			}
			//increase happy meter if house recieves present and change huse to a festive version if receieved enough	
			if (home.lGetY() >= 640) {
				if (home.recieved(gift.getX(), gift.getY() - 138)) {
					home.happy();
					gift.hide();
				}
			} else {
				home.festive();
			}

			if (home2.lGetY() >= 640) {
				if (home2.recieved(gift.getX(), gift.getY() - 138)) {
					home2.happy();
					gift.hide();
				}
			} else {
				home2.festive();
			}

			if (home3.lGetY() >= 640) {
				if (home3.recieved(gift.getX(), gift.getY() - 138)) {
					home3.happy();
					gift.hide();
				}
			} else {
				home3.festive();
			}

			if (home4.lGetY() >= 640) {
				if (home4.recieved(gift.getX(), gift.getY() - 138)) {
					home4.happy();
					gift.hide();
				}
			} else {
				home4.festive();
			}
			//if all houses recieved the amount end game
			if (home.lGetY() <= 640 && home2.lGetY() <= 640 && home3.lGetY() <= 640 && home4.lGetY() <= 640) {
				home4.festive();
				home3.festive();
				home2.festive();
				home.festive();
				santa.play();
				start = false;
				EZ.addText(1366 / 2, 768 / 3, "GAME OVER", Color.GREEN, 90);
				EZ.addText(1366 / 2, 768 / 2, "Merry Christmas", Color.RED, 80);
			}
			EZ.refreshScreen();
		}
	}
}
