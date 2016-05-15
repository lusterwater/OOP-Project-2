import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.Timer;
import javax.swing.JPanel;
 
public class Simulation extends JPanel implements ActionListener {

	public static final int FRAME_RATE = 30;
	public Timer t;
	public OrangeRobot oBot;
	//public BlueRobot bBot;
	public Buttons button;
	private int[] test = {30, 10};
	private Scanner inFile;
	private int cases;
	public int temp = 0;
	

	//public int[] answerArr = new int[20];
	
	public Simulation(){
		setBackground(Color.WHITE);
		t = new Timer(7200/FRAME_RATE,this);
		oBot = new OrangeRobot();
		button = new Buttons();
	}
	
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		button.drawButton(g);
		g.setColor(oBot.oRobotColor);
		g.fillRect(oBot.xCord*15, oBot.yCord, 10, 10);
		int tempOXCord = oBot.xCord*15;
		if(oBot.buttonPressed()){	
			g.setColor(Color.BLACK);
			g.drawRect(tempOXCord, oBot.yCord+10, 10, 10);
		}
			
	


		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == t){
			repaint();
			oNextMove();
			oBotMove();
		}
		
	}
	
	//This function just help the Orange Robot move on the screen
	public void oBotMove(){
		if(oBot.xCord == oBot.xCordNext){
			oBot.stay();
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
		if(temp == test.length-1){
			oBot.stay();
		}else if(temp < test.length){
				oBot.xCordNext = test[temp];
				if(oBot.xCord == oBot.xCordNext){
					oBot.xCord = oBot.xCordNext;
					temp++;
					oBot.xCordNext = test[temp];
				}
			}

	}
	
	public void openFile(){
		try{
			Path file = Paths.get("A-small-practice.in");
			inFile = new Scanner(file);
		}
		catch(Exception e){
			System.out.println("There was an error opening your file");
		}
	
	}
	
	public void getCases(){
		cases = inFile.nextInt();
	}
	
	/*
	public void solveGCJ(){
		
		int cases = inFile.nextInt();
		
		for(int i = 0; i < cases; i++){
			
			int moves = inFile.nextInt();
			int oCur = 1;
			int bCur = 1;
			int bMove = 0;
			int oMove = 0;
			for(int j = 0; j < moves; j++){
				if(inFile.next().equals("B")){
					int bNext = inFile.nextInt();
					bMove = Math.max(bMove + Math.abs(bCur - bNext), oMove)+1;
					bCur = bNext;
					
				}else{
					int oNext = inFile.nextInt();
					oMove = Math.max(oMove + Math.abs(oCur - oNext), bMove)+1;
					oCur = oNext;
				}
			}
		
			answerArr[i] = Math.max(bMove, oMove);
		}
	}
	*/
	public void closeFile(){
		inFile.close();
	}
	
	public int getCase(){
		return cases;
	}
	/*
	public void printOut(){
		for(int i = 0; i < 20; i++){
			System.out.println(answerArr[i]);
		}
	}*/
	public void go(){
		t.start();
	}

}
