package kops.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import org.junit.Test;
import org.mockito.Mockito;

public class LineToolTest {
	
	@Test
	public void testMouseReleased(){
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		
		LineTool tool = new LineTool(properties);
	
		Graphics g = Mockito.mock(Graphics.class);
		
		tool.mousePressed(g, 5, 5);
		tool.mouseReleased(g, 10, 10);
		
			
		//check to make sure that g.draw(5,5,10,10) was called		
		//will work when use commented out code in LineTool's mouseReleased		
		Mockito.verify(g).drawLine(5, 5, 10, 10);
		Mockito.verify(g).setColor(Color.RED);
		
		
	}
	
	@Test
	public void testDrawPreview(){
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		
		LineTool tool = new LineTool(properties);
	
		Graphics g = Mockito.mock(Graphics.class);
		
		tool.mousePressed(g, 5, 5);
		tool.mouseReleased(g, 10, 10);
		tool.drawPreview(g);
		
			
		//check to make sure that g.draw(5,5,10,10) was called		
		//will work when use commented out code in LineTool's mouseReleased		
		Mockito.verify(g).drawLine(5, 5, 10, 10);
		Mockito.verify(g).setColor(Color.RED);
	}

}
