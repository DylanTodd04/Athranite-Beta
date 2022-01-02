import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyClass implements KeyListener{
	
	int x = 0;
	int y = 0;
	
	KeyClass()
	{
		
	}

	public void keyTyped(KeyEvent e) 
	{
		//not needed
	}

	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		System.out.println(key);
	}

	public void keyReleased(KeyEvent e) 
	{
		
	}

}
