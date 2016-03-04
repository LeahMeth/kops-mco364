package kops.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class OvalTool extends Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public OvalTool(PaintProperties properties) {
		super(properties);
	}

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;

	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		this.x2 = x;
		this.y2 = y;

	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(properties.getWeight()));
		g2.setColor(properties.getColor());
		x2 = x;
		y2 = y;

		if (x1 < x2 && y1 < y2) {
			g2.drawOval(x1, y1, (x2 - x1), (y2 - y1));
		} else if (x1 < x2 && y1 > y2) {
			g2.drawOval(x1, y2, (x2 - x1), (y1 - y2));
		} else if (x1 > x2 && y1 < y2) {
			g2.drawOval(x2, y1, (x1 - x2), (y2 - y1));
		} else {
			g2.drawOval(x2, y2, (x1 - x2), (y1 - y2));
		}

	}

	@Override
	public void drawPreview(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(properties.getWeight()));
		g2.setColor(properties.getColor());
		if (x1 < x2 && y1 < y2) {
			g2.drawOval(x1, y1, (x2 - x1), (y2 - y1));
		} else if (x1 < x2 && y1 > y2) {
			g2.drawOval(x1, y2, (x2 - x1), (y1 - y2));
		} else if (x1 > x2 && y1 < y2) {
			g2.drawOval(x2, y1, (x1 - x2), (y2 - y1));
		} else {
			g2.drawOval(x2, y2, (x1 - x2), (y1 - y2));
		}

	}

	

}
