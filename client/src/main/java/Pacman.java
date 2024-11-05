import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pacman extends JFrame{

	public Pacman(ArrayList<String> playerNames, String playerName, ManagedChannel channel, JPanel mainPanel, CardLayout cardLayout) {
		add(new Model(playerNames, playerName, channel, mainPanel, cardLayout)); // Pasa 'this' al constructor de Model
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> playerNames = new ArrayList<>();
		playerNames.add("Pacman");
		playerNames.add("Ghost");
		String target = "localhost:9090"; // Change this to your server address
		ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
		CardLayout cardLayout = new CardLayout();
		JPanel mainPanel = new JPanel(cardLayout);
		Pacman pac = new Pacman(playerNames, "Luis", channel, mainPanel, cardLayout);
		// Maximize the window to fill the entire screen
		pac.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pac.setVisible(true);
		pac.setTitle("Pacman");
		pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pac.setLocationRelativeTo(null);
		
	}

}


