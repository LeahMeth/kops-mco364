package kops.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PaintFrame extends JFrame implements ActionListener {

	private Canvas canvas;
	private JPanel toolPanel, settingsPanel;
	private JButton pencil, line, rectangle, oval, bucket;
	private JButton print, changeColor, changeSize;
	
	public PaintFrame() {
		setTitle("Paint");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = new Container();
		container = getContentPane();
		container.setLayout(new BorderLayout());

		canvas = new Canvas();

		//tools
		pencil = new JButton("Pencil");
		pencil.addActionListener(this);
		line = new JButton("Line");
		line.addActionListener(this);
		rectangle = new JButton("Rectangle");
		rectangle.addActionListener(this);
		oval = new JButton("Oval");
		oval.addActionListener(this);
		bucket = new JButton("Bucket");
		bucket.addActionListener(this);
		
		toolPanel = new JPanel(new FlowLayout());
		
		toolPanel.add(pencil);
		toolPanel.add(line);
		toolPanel.add(rectangle);
		toolPanel.add(oval);
		toolPanel.add(bucket);
		
		//settings and options
						
		changeColor = new JButton("Change Color");
		changeColor.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent event) {
				Color newColor = JColorChooser.showDialog(null, "change color", Color.BLACK);
				if(newColor != null){
					canvas.setToolColor(newColor);
				}
			}
			
		});
		
		changeSize = new JButton("Change Size");
		changeSize.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int size = 1;
				
				do{
				String sizeString = JOptionPane.showInputDialog(null, "Enter a number from 1 to 10");
				size = Integer.parseInt(sizeString);
				}while(size < 1 || size > 10);
				
				canvas.setToolSize(size);
			}
			
		});
		
		print = new JButton("Print Canvas");
		print.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.setJobName("Print Canvas ");
				pj.setPrintable(new Printable() {

					public int print(Graphics graphics, PageFormat format,
							int pageIndex) throws PrinterException {
						if(pageIndex > 0){
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
		
			
		
		settingsPanel = new JPanel(new FlowLayout());
		settingsPanel.add(changeSize);
		settingsPanel.add(changeColor);
		settingsPanel.add(print);
		
		
		container.add(toolPanel, BorderLayout.NORTH);
		container.add(canvas, BorderLayout.CENTER);
		container.add(settingsPanel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent event) {
		JButton source = (JButton) event.getSource();
		String toolType = source.getText();
		
		canvas.setTool(toolType);
		
	}

	public static void main(String[] args) {
		new PaintFrame().setVisible(true);
	}

	

}
