package kops.mco364.paint;

import java.awt.Graphics;

public abstract class Tool {

	protected PaintProperties properties;
	protected CanvasRepaintManager manager;
	
	public Tool(CanvasRepaintManager manager, PaintProperties properties){
		this.properties = properties;
		this.manager = manager;
	}
	
	abstract void mousePressed(Graphics g, int x, int y);

	abstract void mouseDragged(Graphics g, int x, int y);

	abstract void mouseReleased(Graphics g, int x, int y);

	abstract void drawPreview(Graphics g);

}
