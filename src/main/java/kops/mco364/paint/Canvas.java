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

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JPanel;

@Singleton
public class Canvas extends JPanel {

	private BufferedImage buffer, copy;
	private Tool tool;
	private Color color;
	private int toolSize;
	private PaintProperties properties;
	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;

	@Inject
	public Canvas(final PaintProperties properties) {
		this.properties = properties;

		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();

		copy = deepCopy();
		undo.push(copy);

		tool = new PencilTool(properties); // default

		this.addMouseListener(new MouseListener() {

			public void mousePressed(MouseEvent e) {
				copy = deepCopy();
				undo.push(copy);
				tool.mousePressed(properties.getImage().getGraphics(), e.getX(), e.getY());
				repaint();

			}

			public void mouseReleased(MouseEvent e) {
				tool.mouseReleased(properties.getImage().getGraphics(), e.getX(), e.getY());
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

				tool.mouseDragged(properties.getImage().getGraphics(), e.getX(), e.getY());

				repaint();
			}

			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public void setToolColor(Color newColor) {
		properties.setColor(newColor);
	}

	public void setToolSize(int size) {
		properties.setWeight(size);
	}

	public PaintProperties getProperties() {
		return properties;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(properties.getImage(), 0, 0, null);
		tool.drawPreview(g);

	}

	public void undoAction() {
		if (!undo.isEmpty()) {
			copy = deepCopy();
			redo.push(copy);
			properties.setImage(undo.pop());
			repaint();
		}
	}

	public void redoAction() {
		if (!redo.isEmpty()) {
			copy = deepCopy();
			undo.push(copy);
			properties.setImage(redo.pop());
			repaint();
		}
	}

	public BufferedImage deepCopy() {
		ColorModel cm = properties.getImage().getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = properties.getImage().copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

}
