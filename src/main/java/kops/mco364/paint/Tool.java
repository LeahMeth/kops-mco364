package kops.mco364.paint;

import java.awt.Graphics;

public interface Tool {//methods are public automatically
	
	
	//ne
	void mousePressed(Graphics g, int x, int y);
	
	void mouseDragged(Graphics g, int x, int y);
	
	void mouseReleased(Graphics g, int x, int y);
	
	void drawPreview(Graphics g);

}
