import java.awt.Color;

public class BlueRobot {
	
	public int xCord;
	public int yCord;
	public int xCordNext;
	Color bRobotColor;
	
	public BlueRobot(){
		
		this.xCord = 1;
		this.yCord = 200;
		this.xCordNext = 0;
		this.bRobotColor = Color.BLUE;
		
	}
	
	public void goLeft(){
		this.xCord--;
	}
	
	public void goRight(){
		this.xCord++;
	}
	
	public void stay(){
		
	}

	public Color getColor(){
		return this.bRobotColor;
	}
	
	public boolean buttonPressed(){
		
		if(xCord == xCordNext){
			return true;
		}
		
		return false;
	}

}
