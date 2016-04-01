package kops.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

import javax.inject.Singleton;

@Singleton
public class PaintProperties {

	private int width;
	private int height;
	private Color color;
	private BasicStroke stroke;
	private int weight;
	private boolean fill;
	private BufferedImage image;
	
	
	public PaintProperties(){
		this.image = new BufferedImage(1000, 750, BufferedImage.TYPE_INT_ARGB);
		this.fill = false;
		this.color = Color.BLACK;
		this.weight = 1;
		this.width = 1000;
		this.height = 750;
		
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Stroke getStroke() {
		return new BasicStroke(this.weight);
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public boolean isFill() {
		return fill;
	}
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getWeight() {
		return this.weight;
	}
	
	
}
