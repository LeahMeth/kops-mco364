package kops.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public interface Tool {//methods are public automatically
	
	
	void mousePressed(Graphics g, int x, int y);
	
	void mouseDragged(Graphics g, int x, int y);
	
	void mouseReleased(Graphics g, int x, int y);
	
	void drawPreview(Graphics g);

	void setToolColor(Color newColor);

	void setToolSize(int size);

}
