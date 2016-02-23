package kops.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class OvalTool implements Tool {

	private Color color;
	private int size;

	public OvalTool(Color color){
		this.color = color;
	}
	
	@Override
	public void mousePressed(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

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
		this.size = size;
		
	}


}
