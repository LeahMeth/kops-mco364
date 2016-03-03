package kops.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class PencilTool implements Tool {

	private int x, y;
	private Color color;
	private int size;

	public PencilTool(Color color, int size) {
		this.color = color;
		this.size = size;
	}

	public void mousePressed(Graphics g, int x, int y, BufferedImage buffer) {

		g.setColor(color);
		g.fillOval(x, y, size, size);
		this.x = x;
		this.y = y;
	}

	public void mouseDragged(Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		g2.draw(new Line2D.Float(x, y, this.x, this.y));

		this.x = x;
		this.y = y;

	}

	public void mouseReleased(Graphics g, int x, int y) {

	}

	public void drawPreview(Graphics g) {

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
