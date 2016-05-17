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
	private Vector<Vector <Boolean>> posOrder = new Vector<Vector <Boolean>>();
	private Vector<Vector <Integer>> bluePos = new Vector<Vector <Integer>>();
	private Vector<Vector <Integer>> oranPos = new Vector<Vector <Integer>>();
	private int[] test = {10, 60, 25};
	private int[] test2 = {30, 10, 40};
	private boolean[] test3 = {true, false, false, true, false, true};
	private Scanner inFile;
	private int cases;
	private int temp = 0;
	private int temp2 = 0;
	private int temp3 = 0;
			
	public Simulation(){
		setBackground(Color.BLACK);
		t = new Timer(3600/FRAME_RATE,this);
		oBot = new OrangeRobot();
		bBot = new BlueRobot();
		button = new Buttons();
	}
				
	public void paintComponent(Graphics g){
			
		super.paintComponent(g);
		button.drawButton(g);
			
		g.setColor(oBot.oRobotColor);
		g.fillRect(oBot.xCord*15, oBot.yCord, 10, 10);
		g.setColor(bBot.bRobotColor);
		g.fillRect(bBot.xCord*15, bBot.yCord, 10, 10);
			
		if(bBot.buttonPressed() && test3[temp3] == true){	
			g.setColor(Color.WHITE);
			g.fillRect(bBot.xCord*15, bBot.yCord+10, 10, 10);
			
		}
			
		if(oBot.buttonPressed() && test3[temp3] == false){	
			g.setColor(Color.WHITE);
			g.fillRect(oBot.xCord*15, oBot.yCord+10, 10, 10);
			
		}
				
		System.out.println(test3[3]);
		System.out.println(temp3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == t){
			repaint();
			oNextMove();
			bNextMove();
			oBotMove();
			bBotMove();
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
		if(temp >= test.length-1 && temp3 >= test3.length-1){
		//This part just here so to stop some error codes I'm getting with nullpointer exception
		}else if(temp < test.length && test3[temp3] == false){
				oBot.xCordNext = test[temp];
				if(oBot.xCord == oBot.xCordNext){
					oBot.xCord = oBot.xCordNext;
					temp++;
					temp3++;
					oBot.xCordNext = test[temp];
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
		if(temp2 >= test2.length-1 && temp3 >= test3.length-1){
			
		}
		else if(temp2 < test2.length && test3[temp3] == true){
			bBot.xCordNext = test2[temp2];
			if(bBot.xCord == bBot.xCordNext){
				bBot.xCord = bBot.xCordNext;
				temp2++;
				temp3++;
				bBot.xCordNext = test2[temp2];
			}
		}
	}
		
	//Stores the value of the GCJ inputs in vectors so we can use them later in our simulation.
	public void storeInputs(){
		for(int i = 0; i < cases; i++){
			int moves = inFile.nextInt();
			Vector<Boolean> posTemp = new Vector<Boolean>();
			Vector<Integer> oPosTemp = new Vector<Integer>();
			Vector<Integer> bPosTemp = new Vector<Integer>();
			int j = 0;
			while(j < moves){
				if(inFile.next().equals("B")){
					posTemp.add(true);
					bPosTemp.add(inFile.nextInt());
				}
				else{
					posTemp.add(false);
					oPosTemp.add(inFile.nextInt());
				}
				j++;
			}
			
			posOrder.add(posTemp);
			bluePos.add(bPosTemp);
			oranPos.add(oPosTemp);
		}
	}
		
	//just to test if the inputs were stored correctly
	public void printInputs(){
		for(int i = 0; i < cases; i++){
			int j = 0;
			int oC = 0;
			int bC = 0;
			int pOsize = posOrder.get(i).size();
			int bPsize = bluePos.get(i).size();
			int oPsize = oranPos.get(i).size();
			
			while(j < pOsize){
				System.out.print(posOrder.get(i).get(j) + " ");
				j++;
			}
			System.out.println();
			if(oranPos.get(i).isEmpty()==false){
				while(oC < oPsize){
					System.out.print(oranPos.get(i).get(oC) + " ");
					oC++;
				}
			}
			System.out.println();
			while(bC < bPsize){
				System.out.print(bluePos.get(i).get(bC) + " ");
				bC++;
			}
			System.out.println();
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
				
	public void closeFile(){
		inFile.close();
	}
		
	public int getCase(){
		return cases;
	}
		
	public void go(){
		t.start();
	}

}

