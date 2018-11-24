import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GameWindow extends JPanel
{
	private final int WIDTH = 400;
	private final int HEIGHT = 400;
	private final int MOVE = 100;
	public int clickCount = 0;
	private Number list[] = new Number[16];
	public Random rng = new Random();
	private Point clicked = null;
	public int clickedPosition = 0;
	private JButton push;
	private JLabel label;
	
	ImageIcon one = new ImageIcon("img/1.jpg");
	ImageIcon two = new ImageIcon("img/2.jpg");
	ImageIcon three = new ImageIcon("img/3.jpg");
	ImageIcon four = new ImageIcon("img/4.jpg");
	ImageIcon five = new ImageIcon("img/5.jpg");
	ImageIcon six = new ImageIcon("img/6.jpg");
	ImageIcon seven = new ImageIcon("img/7.jpg");
	ImageIcon eight = new ImageIcon("img/8.jpg");
	ImageIcon nine = new ImageIcon("img/9.jpg");
	ImageIcon ten = new ImageIcon("img/10.jpg");
	ImageIcon eleven = new ImageIcon("img/11.jpg");
	ImageIcon twelve = new ImageIcon("img/12.jpg");
	ImageIcon thirteen = new ImageIcon("img/13.jpg");
	ImageIcon fourteen = new ImageIcon("img/14.jpg"); 
	ImageIcon fifteen = new ImageIcon("img/15.jpg");
	ImageIcon empty = new ImageIcon("img/black.jpg");
	
	


	public GameWindow()
	{
		ClickListener listener = new ClickListener();
		addMouseListener(listener);

	


		//initializes numbers position and finalPosition and icons
		for(int i = 0; i < list.length; i++ )  
		{

			list[i] = new Number();

			list[i].setPosition(i+1);
			list[i].setFinal(i+1);
	
		}


		list[0].setIcon(one);
		list[1].setIcon(two);
		list[2].setIcon(three);
		list[3].setIcon(four);
		list[4].setIcon(five);
		list[5].setIcon(six);
		list[6].setIcon(seven);
		list[7].setIcon(eight);
		list[8].setIcon(nine);
		list[9].setIcon(ten);
		list[10].setIcon(eleven);
		list[11].setIcon(twelve);
		list[12].setIcon(thirteen);
		list[13].setIcon(fourteen);
		list[14].setIcon(fifteen);
		list[15].setIcon(empty);

		//label = new JLabel("Moves made: " + clickCount);
		//push = new JButton("Start Over");
		//push.addActionListener(new ButtonListener());

		//add(label);
		//add(push);

		shuffle();
		

		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);

	}

	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

			
			

			if(canSwap())
			{
				swap();
				
			}
			

		for(int i= 0; i < 16; i++)
			list[i].icon.paintIcon(this, page, getX(list[i].position), getY(list[i].position));
		//label.setText("Moves Made: " + clickCount);
		
	}

	public void shuffle()
	{
		int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		int x;
		int placeholder;
		for(int i = array.length-1; i > 0; i--)
		{
			x = rng.nextInt(i+1);
			placeholder = array[i];
			array[i] = array[x];
			array[x] = placeholder; 

		}
		for(int i = 0; i < list.length; i++)
		{
			list[i].setPosition(array[i]);
		}

	}


	public static int getX(int pos)
	{

		int i;

		if (pos == 1 || pos == 5 || pos == 9 || pos == 13)
			i = 0;
		else if (pos == 2 || pos == 6 || pos == 10 || pos == 14)
			i = 100;
		else if(pos == 3|| pos == 7 || pos == 11 || pos == 15)
			i = 200;
		else
			i = 300;
			
		return i;

	}

	public static int getY(int pos) 
	{
		int i;

		if(pos < 5)
			i = 0;
		else if(pos > 4 && pos < 9)
			i = 100;
		else if(pos > 8 && pos < 13)
			i = 200;
		else 
			i = 300;

		return i;

	}

	public int getPos(int x, int y) //returns the index of the number that is in the position of clicked
	{ 
		int value = 0;
		int result = -1;
		if(x >= 0 && y >= 0 && x < 100 && y < 100)
			value = 1;
		else if(x >= 100 && y >= 0 && x < 200 && y < 100)
			value = 2;
		else if(x >= 200 && y >= 0 && x < 300 && y < 100)
			value = 3;
		else if(x >= 300 && y >= 0 && x < 400 && y < 100)
			value = 4;
		else if(x >= 0 && y >= 100 && x < 100 && y < 200)
			value = 5;
		else if(x >= 100 && y >= 100 && x < 200 && y < 200)
			value = 6;
		else if(x >= 200 && y >= 100 && x < 300 && y < 200)
			value = 7;
		else if(x >= 300 && y >= 100 && x < 400 && y < 200)
			value = 8;
		else if(x >= 0 && y >= 200 && x < 100 && y < 300)
			value = 9;
		else if(x >= 100 && y >= 200 && x < 200 && y < 300)
			value = 10;
		else if(x >= 200 && y >= 200 && x < 300 && y < 300)
			value = 11;
		else if(x >= 300 && y >= 200 && x < 400 && y < 300)
			value = 12;
		else if(x >= 0 && y >= 300 && x < 100 && y < 400)
			value = 13;
		else if(x >= 100 && y >= 300 && x < 200 && y < 400)
			value = 14;
		else if(x >= 200 && y >= 300 && x < 300 && y < 400)
			value = 15;
		else if(x >= 300 && y >= 300 && x < 400 && y < 400)
			value = 16;

		for(int i = 0; i < list.length; i++)
		{
			if(value == list[i].position)
				result = i;
		}
		return result;
	}
	public boolean canSwap()
	{
		

		if (list[clickedPosition].position == (list[15].position - 1) || list[clickedPosition].position == (list[15].position + 1)
		|| list[clickedPosition].position == (list[15].position - 4) || list[clickedPosition].position == (list[15].position + 4))
			return true;
		else
			return false;
	}

	public void swap()
	{
		int t = 0;

		t = list[clickedPosition].position;
		list[clickedPosition].setPosition(list[15].position);
		list[15].setPosition(t);
		clickCount++;
		
	}

	public void checkWin()
	{
		int j = 0;
		for (int i = 0;i < 16; i++) {
			if(list[i].position == list[i].finalPosition)
				j++;
		}
		if(j == 16)
			JOptionPane.showMessageDialog(null, "Congrats! You've Won!");

	}

	private class ClickListener implements MouseListener
	{
		public void mouseClicked(MouseEvent event)
		{
			clicked = event.getPoint();
			clickedPosition = getPos(clicked.x, clicked.y);

			checkWin();
			repaint();
		}

		public void mousePressed(MouseEvent event){}
		public void mouseReleased(MouseEvent event){}
		public void mouseExited(MouseEvent event){}
		public void mouseMoved(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
	} 
	/*
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			shuffle();
			clickCount = 0;
			repaint();
		}
	}
	*/
}