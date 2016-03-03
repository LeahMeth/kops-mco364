package kops.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class BucketTool implements Tool {

	private Color color;
	private int source;
	private int currentX;
	private int currentY;
	private Point currentPoint;

	public BucketTool(Color color) {
		this.color = color;
	}

	@Override
	public void mousePressed(Graphics g, int x, int y, BufferedImage buffer) {
		source = buffer.getRGB(x, y);
		if(source == color.getRGB()){
			return;
		}

		Stack<Point> points = new Stack<Point>();
		points.push(new Point(x, y));
		while (!points.isEmpty()) {
			currentPoint = points.pop();
			currentX = currentPoint.getX();
			currentY = currentPoint.getY();
			if(currentX > 0 && currentY > 0 && currentX < 1000 && currentY < 750){
				if(buffer.getRGB(currentX, currentY) == source){
					buffer.setRGB(currentX, currentY, color.getRGB());
					
					points.push(new Point(currentX, currentY - 1));
					points.push(new Point(currentX - 1, currentY));
					points.push(new Point(currentX, currentY + 1));
					points.push(new Point(currentX + 1, currentY));
				}
			}
			
		}

	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setToolColor(Color newColor) {
		this.color = newColor;

	}

	@Override
	public void setToolSize(int size) {
		// TODO Auto-generated method stub

	}

}
