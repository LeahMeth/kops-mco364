package kops.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage buffer;
	private Tool tool;

	public Canvas() {

		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		this.tool = new LineTool();

		this.addMouseListener(new MouseListener() {

			public void mousePressed(MouseEvent e) {

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

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g);

	}

}
