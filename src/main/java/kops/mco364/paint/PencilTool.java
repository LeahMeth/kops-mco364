package kops.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class PencilTool extends Tool {

	private int x, y;

	public PencilTool(PaintProperties properties) {
		super(properties);
	}

	public void mousePressed(Graphics g, int x, int y) {

		g.setColor(properties.getColor());
		g.fillOval(x, y, properties.getColor().getRGB(), properties.getWeight());
		this.x = x;
		this.y = y;
	}

	public void mouseDragged(Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(properties.getColor());
		g2.setStroke(new BasicStroke(properties.getWeight(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		g2.draw(new Line2D.Float(x, y, this.x, this.y));

		this.x = x;
		this.y = y;

	}

	public void mouseReleased(Graphics g, int x, int y) {

	}

	public void drawPreview(Graphics g) {

	}

	

}
