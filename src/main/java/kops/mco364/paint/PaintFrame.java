package kops.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class PaintFrame extends JFrame{
	
	public PaintFrame(){
		setTitle("Paint");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = new Container();
		container = getContentPane();
		container.setLayout(new BorderLayout());
		
		Canvas canvas = new Canvas();
		container.add(canvas, BorderLayout.CENTER);
		
	
	
		
		
		
	}
	
	public static void main(String[] args){
		new PaintFrame().setVisible(true);
	}

}
