import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Sliding Numbers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new GameWindow());

		frame.pack();
		frame.setVisible(true);

	}
}