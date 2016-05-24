import java.awt.Color;
import java.awt.Graphics;

public class Buttons {
		
	public Color button1 = Color.GREEN;
	public Color button2 = Color.MAGENTA;
	public static final int incrementer = 15;
	
	public Buttons(){}
	
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
}
