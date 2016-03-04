package kops.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class LineTool extends Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public LineTool(PaintProperties properties) {
		super(properties);
	}

	public void mousePressed(Graphics g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(properties.getWeight(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		g2.setColor(properties.getColor());
		g2.draw(new Line2D.Float(x1, y1, x, y));

	}

	public void mouseDragged(Graphics g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	public void drawPreview(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(properties.getWeight(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		g2.setColor(properties.getColor());
		g2.draw(new Line2D.Float(x1, y1, x2, y2));
	}

	

}
