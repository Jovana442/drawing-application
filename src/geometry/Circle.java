package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	
	//promenljive
	
	protected Point center;
	protected int r;

	
	// konstruktori
	
	public Circle() {
		
	}
	
	public Circle (Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	public Circle(Point center, int r, Color border, Color inside) {
		this(center, r);
		setBorder(border);
		setInside(inside);
	}
	
	public Circle (Point center, int r, boolean selected) {
		this(center, r);
		this.selected = selected;
	}
	
	
	// geteri i seteri
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	/* public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}*/
	
	// metode
	
	public String toString () {
		return "Center: " + center + " , Radius = " + r;
	}
	
	public double area () {
		return r * r * Math.PI;
	}
	
	public double volume () {
		return 2 * r * Math.PI;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle temp = (Circle) obj;
			return center.equals(temp.center) && r == temp.r;
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= r;
	}
	
	

	@Override
	public void draw(Graphics g) {
		g.setColor(getBorder());
		g.drawOval(center.getX() - r, center.getY() - r, 2*r, 2*r);
		
		if (selected) {
			g.setColor(Color.BLUE);
			selectedShape(g);
		}
		
	}
	
	@Override
	public void selectedShape(Graphics g) {
		g.drawRect(center.getX() - 2, center.getY() - 2, 4,4);
		g.drawRect(center.getX() - r - 2, center.getY() - 2, 4,4);
		g.drawRect(center.getX() + r - 2, center.getY() - 2, 4,4);
		g.drawRect(center.getX() - 2, center.getY() - r - 2, 4,4);
		g.drawRect(center.getX() - 2, center.getY() + r - 2, 4,4);
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return (int) (this.area() - ((Circle)o).area());
		}
		return 0;
	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
		
	}

	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
	}

	@Override
	public void paintInside(Graphics g) {
		g.setColor(getInside());
		g.fillOval(center.getX() - r + 1, center.getY() - r + 1, 2*r-2, 2*r-2);
		
	}

	
		
		
		
	
	

}
