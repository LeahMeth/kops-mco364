package kops.mco364.paint;

import java.awt.Graphics;
import java.util.Stack;

public class BucketTool extends Tool {

	private int source;
	private int currentX;
	private int currentY;
	private Point currentPoint;
	//private PaintProperties properties;

	public BucketTool(PaintProperties properties) {
		super(properties);
	}

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		fill(x, y);

	}

	private void fill(int x, int y) {
		source = properties.getImage().getRGB(x, y);
		if (source == properties.getColor().getRGB()) {
			return;
		}

		Stack<Point> points = new Stack<Point>();
		points.push(new Point(x, y));
		while (!points.isEmpty()) {
			currentPoint = points.pop();
			currentX = currentPoint.getX();
			currentY = currentPoint.getY();
			if (currentX > 0 && currentY > 0 && currentX < 1000 && currentY < 750) {
				if (properties.getImage().getRGB(currentX, currentY) == source) {
					properties.getImage().setRGB(currentX, currentY, properties.getColor().getRGB());

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

	

}
