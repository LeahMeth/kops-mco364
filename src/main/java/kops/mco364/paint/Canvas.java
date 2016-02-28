package kops.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage buffer, copy;
	private Tool tool;
	private Color color;
	private int toolSize;
	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;

	public Canvas() {

		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();

		buffer = new BufferedImage(1000, 900, BufferedImage.TYPE_INT_ARGB);
		copy = deepCopy();
		undo.push(copy);

		color = Color.BLACK;
		toolSize = 1;
		tool = new PencilTool(color, toolSize); // default

		this.addMouseListener(new MouseListener() {

			public void mousePressed(MouseEvent e) {
				copy = deepCopy();
				undo.push(copy);
				tool.mousePressed(buffer.getGraphics(), e.getX(), e.getY());
				repaint();

			}

			public void mouseReleased(MouseEvent e) {
				tool.mouseReleased(buffer.getGraphics(), e.getX(), e.getY());
				repaint();

			}

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {

				tool.mouseDragged(buffer.getGraphics(), e.getX(), e.getY());

				repaint();
			}

			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	public void setTool(String toolType) {
		switch (toolType) {
		case "Pencil":
			this.tool = new PencilTool(color, toolSize);
			break;
		case "Line":
			this.tool = new LineTool(color, toolSize);
			break;
		case "Rectangle":
			this.tool = new RectangleTool(color, toolSize);
			break;
		case "Oval":
			this.tool = new OvalTool(color, toolSize);
			break;
		case "Bucket":
			this.tool = new BucketTool(color);
			break;
		}
	}

	public void setToolColor(Color newColor) {
		this.color = newColor;
		this.tool.setToolColor(newColor);
	}

	public void setToolSize(int size) {
		this.toolSize = size;
		this.tool.setToolSize(size);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g);

	}

	public void undoAction() {
		//if (!undo.isEmpty()) {
			copy = deepCopy();
			redo.push(copy);
			this.buffer = undo.pop();
			repaint();
		//}
	}

	public void redoAction() {
		//if (!redo.isEmpty()) {
			copy = deepCopy();
			undo.push(copy);
			this.buffer = redo.pop();
			repaint();
		//}
	}

	public BufferedImage deepCopy() {
		ColorModel cm = this.buffer.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = this.buffer.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

}
