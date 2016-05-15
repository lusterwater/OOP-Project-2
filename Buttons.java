import java.awt.Color;
import java.awt.Graphics;

public class Buttons {
	
	
	public Color button1 = Color.GREEN;
	public Color button2 = Color.PINK;
	public Color buttonPressed = Color.BLACK;
	public static final int incrementer = 15;
	
	public OrangeRobot oRef = new OrangeRobot();
	
	public Buttons(){
	
	}
	
	public void drawButton(Graphics g){
		g.setColor(button1);
		for(int i = 1; i <= 100; i++ ){
			g.fillRect(i * incrementer , 200, 10, 10);
		}
		
		g.setColor(button2);
		for(int j = 1; j <= 100; j++){
			g.fillRect(j * incrementer , 400, 10, 10);
		}
	}

	public boolean oPressed(Graphics g){
		
		if(oRef.buttonPressed()){
			g.setColor(buttonPressed);
			g.fillRect(oRef.xCord * 15, oRef.yCord+15, 10, 10);
			return true;
		}
		return false;
	}
}
