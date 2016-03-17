package kops.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {

	
	
	@Inject
	public PaintFrame(final Canvas canvas, PaintToolbar toolbar) {
		setTitle("Paint");
		setSize(1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		container.add(canvas, BorderLayout.CENTER);
		container.add(toolbar, BorderLayout.NORTH);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PaintModule());		
		PaintFrame frame = injector.getInstance(PaintFrame.class);	
		
	}

}
