package kops.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	
	private BufferedImage buffer;
	

	
	public Canvas(){
		
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

		this.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				
				Graphics g = buffer.getGraphics();
				g.setColor(Color.BLUE);
				g.fillOval(e.getX(), e.getY(), 5, 5);

				repaint();

			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		addMouseMotionListener(new MouseMotionListener(){

			public void mouseDragged(MouseEvent e) {
				
				int x1 = e.getX();
				int y1 = e.getY();
			
				
				Graphics g = buffer.getGraphics();
				g.setColor(Color.BLUE);
				
				int x2 = e.getX();
				int y2 = e.getY();
				g.drawLine(x1, y1, x2, y2);
				
				x1 = x2;
				y1 = y2;
				
				
				repaint();
			}

			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(buffer, 0, 0, null);
		
	}

}
