package kops.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	private JButton print;
	private Canvas canvas;

	public PaintFrame() {
		setTitle("Paint");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = new Container();
		container = getContentPane();
		container.setLayout(new BorderLayout());

		canvas = new Canvas();

		print = new JButton("Print Canvas");
		print.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.setJobName("Print Canvas");
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

		container.add(print, BorderLayout.NORTH);
		container.add(canvas, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		new PaintFrame().setVisible(true);
	}

}
