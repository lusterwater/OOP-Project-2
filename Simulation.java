import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.Timer;
import javax.swing.JPanel;
	 
public class Simulation extends JPanel implements ActionListener {

	private static final int FRAME_RATE = 30;
	private Timer t;
	private OrangeRobot oBot;
	private BlueRobot bBot;
	private Buttons button;
	private int[] bluePosArr = {61,40,19,94};
	private int[] oranPosArr = {99,3,22,43,26};
	private int[] posArr = {1,1,0,0,1,0,1,0,0};
	private int oPosCount;
	private int bPosCount;
	private int posCount;
	private boolean oButIsPressed;
	private boolean bButIsPressed;
			
	public Simulation(){
		setBackground(Color.BLACK);
		t = new Timer(7200/FRAME_RATE,this);
		oBot = new OrangeRobot();
		bBot = new BlueRobot();
		button = new Buttons();
		oButIsPressed = false;
		bButIsPressed = false;
		oPosCount = 0;
		bPosCount = 0;
		posCount = 0;
	}
				
	public void paintComponent(Graphics g){
			
		super.paintComponent(g);
		
		//draws the buttons
		button.drawButton(g);
		
		//draws the two robots
		g.setColor(oBot.oRobotColor);
		g.fillRect(oBot.xCord*15, oBot.yCord, 10, 10);
		g.setColor(bBot.bRobotColor);
		g.fillRect(bBot.xCord*15, bBot.yCord, 10, 10);
		
		//Check if the button can be pressed and if it can be pressed it shows it graphically
		if(bBot.buttonPressed() && posArr[posCount] == 1){	
			g.setColor(Color.WHITE);
			g.fillRect(bBot.xCord*15, bBot.yCord+10, 10, 10);
			bButIsPressed = true;

		}
			
		if(oBot.buttonPressed() && posArr[posCount] == 0){	
			g.setColor(Color.WHITE);
			g.fillRect(oBot.xCord*15, oBot.yCord+10, 10, 10);
			oButIsPressed = true;
		}
		
	}
	
	//This is where all the animation comes in
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == t){
			tick();
		}
	}
	
	//checks for the next order for the robots to move
	public void botNextSeq(){
		if(posCount >= posArr.length-1){
			
		}
		else if (oButIsPressed == true || bButIsPressed == true){
			posCount++;
		}
	}
		
	//Checks the position of the next coordinate of Orange robot and if he should move left or right or stay still
	public void oBotMove(){
		if(oBot.xCord == oBot.xCordNext){
			//This part is just here to stop the frame from moving if there is no more moves
		}
		else if(oBot.xCord < oBot.xCordNext ){
			oBot.goRight();
		}
		else if(oBot.xCord > oBot.xCordNext ){
			oBot.goLeft();
		}
	}
		
	//Checks if there is a another move for the Orange Robot to go
	public void oNextMove(){
		if(oranPosArr.length <= 0){
		
		}
		else{
			if(oPosCount >= oranPosArr.length-1){
			
			}
			else if(oButIsPressed == true){
				oBot.xCord = oBot.xCordNext;
				oButIsPressed = false;
				oPosCount++;
				oBot.xCordNext = oranPosArr[oPosCount];
				
			}else if(oPosCount == 0){
				oBot.xCordNext = oranPosArr[oPosCount];
			}
		}
	}

	//Checks the position of the next coordinate of Blue robot and if he should move left or right or stay still
	public void bBotMove(){
		if(bBot.xCord == bBot.xCordNext){
		//This part is just here to stop the frame from moving if there is no more moves
		}
		else if(bBot.xCord < bBot.xCordNext){
			bBot.goRight();
		
		}
		else if(bBot.xCord > bBot.xCordNext){
			bBot.goLeft();
			
		}
	}
	
	//Checks the container if there are any more moves for the Blue Robot to move
	public void bNextMove(){
		if(bluePosArr.length <= 0){
			
		}
		else{
			if(bPosCount >= bluePosArr.length-1){
			
			}
			else if(bButIsPressed == true){
				bBot.xCord = bBot.xCordNext;
				bButIsPressed = false;
				bPosCount++;
				bBot.xCordNext = bluePosArr[bPosCount];
			}
			else if(bPosCount == 0){
				bBot.xCordNext = bluePosArr[bPosCount];
			}
		}	
	}
	
	public void tick(){
		repaint();
		botNextSeq();
		bNextMove();
		oNextMove();
		bBotMove();
		oBotMove();
	}
	
	//starts the animation
	public void go(){
		t.start();
	}

}

