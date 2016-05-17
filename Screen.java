import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Screen {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Bot Trust Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		Simulation simulation = new Simulation();
		frame.add(simulation, BorderLayout.CENTER);
		
		frame.setSize(1600, 800);
		frame.setVisible(true);
		
		simulation.go();
		simulation.openFile();
		simulation.getCases();
		simulation.storeInputs();
		simulation.printInputs();
		simulation.closeFile();
		
	}

}

