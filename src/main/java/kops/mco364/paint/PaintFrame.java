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

public class PaintFrame extends JFrame {

	private Canvas canvas;
	private JPanel toolPanel, settingsPanel;
	private JButton print, changeColor, changeSize;
	private JButton undo, redo;
	protected Tool tool;

	public PaintFrame() {
		setTitle("Paint");
		setSize(1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		Container container = new Container();
		container = getContentPane();
		container.setLayout(new BorderLayout());
		
		 PaintProperties properties = new PaintProperties(new BufferedImage(1000, 750, BufferedImage.TYPE_INT_ARGB));

		canvas = new Canvas(properties);
		

		ActionListener listener = new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				ToolButton button = (ToolButton) event.getSource();
				canvas.setTool(button.getTool());
			}
		};

			
		ToolButton buttons[] = new ToolButton[] { new ToolButton(new PencilTool(properties), "/pencil.png"),
				new ToolButton(new LineTool(properties), "/line.png"),
				new ToolButton(new RectangleTool(properties), "/rectangle.png"),
				new ToolButton(new OvalTool(properties), "/oval.png"),
				new ToolButton(new BucketTool(properties), "/bucket.png") };

		toolPanel = new JPanel(new FlowLayout());

		for(ToolButton button: buttons){
			toolPanel.add(button);
			button.addActionListener(listener);
		}

		// settings and options
		changeColor = new JButton(new ImageIcon(getClass().getResource("/colorpicker.jpg")));
		changeColor.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				Color newColor = JColorChooser.showDialog(null, "change color", Color.BLACK);
				if (newColor != null) {
					canvas.setToolColor(newColor);
				}
			}

		});

		changeSize = new JButton(new ImageIcon(getClass().getResource("/weight.png")));
		changeSize.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int size = 1;

				do {
					String sizeString = JOptionPane.showInputDialog(null, "Enter a number from 1 to 10");
					size = Integer.parseInt(sizeString);
				} while (size < 1 || size > 10);

				canvas.setToolSize(size);
			}

		});

		print = new JButton(new ImageIcon(getClass().getResource("/print.png")));
		print.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.setJobName("Print Canvas ");
				pj.setPrintable(new Printable() {

					public int print(Graphics graphics, PageFormat format, int pageIndex) throws PrinterException {
						if (pageIndex > 0) {
							return Printable.NO_SUCH_PAGE;
						}
						Graphics2D graphics2 = (Graphics2D) graphics;
						graphics2.translate(format.getImageableX(), format.getImageableY());
						canvas.paint(graphics2);
						return Printable.PAGE_EXISTS;

					}

				});
				try {
					pj.print();
				} catch (PrinterException e) {
					e.printStackTrace();
				}

			}

		});

		undo = new JButton(new ImageIcon(getClass().getResource("/undo.jpg")));
		undo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				canvas.undoAction();

			}

		});

		redo = new JButton(new ImageIcon(getClass().getResource("/redo.png")));
		redo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.redoAction();
			}

		});

		settingsPanel = new JPanel(new FlowLayout());
		settingsPanel.add(undo);
		settingsPanel.add(redo);
		settingsPanel.add(changeSize);
		settingsPanel.add(changeColor);
		settingsPanel.add(print);

		container.add(toolPanel, BorderLayout.NORTH);
		container.add(canvas, BorderLayout.CENTER);
		container.add(settingsPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new PaintFrame().setVisible(true);
	}

}
