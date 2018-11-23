import javax.swing.*;
import java.awt.*;

public class Number
{
	public int position;

	public int finalPosition;

	public boolean canMove = false;

	ImageIcon icon;

	
	public void setIcon(ImageIcon icon)
	{
		this.icon = icon;
	}

	public void setPosition(int x)
	{
		position = x;

		
	}
	public void setFinal(int x)
	{
		finalPosition = x;
	}

	public void setMove(boolean tf)
	{
		canMove = tf;
	}



}