import java.awt.Color;

public class OrangeRobot {
	
	public int xCord;
	public int yCord;
	public int xCordNext;
	public Color oRobotColor;
	
	public OrangeRobot(){
		
		this.xCord = 1;
		this.yCord = 400;
		this.xCordNext = 0;
		this.oRobotColor = Color.ORANGE;
		
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
		return this.oRobotColor;
	}
	
	public boolean buttonPressed(){
		
		if(xCord == xCordNext){
			return true;
		}
		
		return false;
	}
}
