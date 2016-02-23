package kops.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LineTool implements Tool{
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color;
	private int size;
	
	public LineTool(Color color){
		this.color = color;
	}

	public void mousePressed(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2.setColor(color);
        g2.draw(new Line2D.Float(x1, y1, x, y));
		
	}

	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		this.x2 = x;
		this.y2 = y;
	}


	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2.setColor(color);
        g2.draw(new Line2D.Float(x1, y1, x2, y2));
	}

	@Override
	public void setToolColor(Color newColor) {
		this.color = newColor;
	}

	@Override
	public void setToolSize(int size) {
		this.size = size;
		
	}
	
	
	
}
