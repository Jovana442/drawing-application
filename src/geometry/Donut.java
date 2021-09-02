package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
	//promenljive
	
	private int innerR;
	
	// konstruktori
	
	public Donut() {
		
	}
	
	public Donut(Point center, int r, int innerR) {
		super(center, r);
		this.innerR = innerR;
	}
	
	public Donut(Point center, int r, int innerR, Color border, Color inside) {
		this(center, r, innerR);
		setBorder(border);
		setInside(inside);
	}
	
	public Donut(Point center, int r, int innerR, boolean selected) {
		this(center, r, innerR);
		this.selected = selected;
	}
	
	// geteri i seteri
	

	public int getInnerR() {
		return innerR;
	}

	public void setInnerR(int innerR) {
		this.innerR = innerR;
	}
	
	// metode
	
	public String toString() {
		return super.toString() + ", inner radius = " + innerR;
	}
	
	public double area() {
		return super.area() - innerR*innerR*Math.PI;
	}
	
	public boolean contains(int x, int y) {
		return super.contains(x, y) && center.distance(x, y) >=innerR;
	}
	
	// isto contains za Donut, preko tacke:
	
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	public void draw(Graphics g) {
		g.setColor(getBorder());
		super.draw(g);
		g.setColor(getBorder());
		g.drawOval(center.getX() - innerR, center.getY() - innerR, 2*innerR, 2*innerR);
		
		if (selected) {
			
			g.drawRect(center.getX() - innerR - 2, center.getY() - 2, 4,4);
			g.drawRect(center.getX() + innerR - 2, center.getY() - 2, 4,4);
			g.drawRect(center.getX() - 2, center.getY() - innerR - 2, 4,4);
			g.drawRect(center.getX() - 2, center.getY() + innerR - 2, 4,4);
		}
	}
	
	public void paintInside(Graphics g) {
		
		super.paintInside(g);
	    g.setColor(getInside());
		g.setColor(Color.WHITE);
		g.fillOval(center.getX() - innerR + 2, center.getY() - innerR + 2, 2*innerR-3, 2*innerR-3);
	}
	
	
	

	

	
}
