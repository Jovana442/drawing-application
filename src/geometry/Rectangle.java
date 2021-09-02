package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
	
	// promenljive
	
	private Point upperLeft;
	private int width;
	private int height;

	
	
	// konstruktori
	
	public Rectangle() {
		
	}
	
	public Rectangle (Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
		
	}
	
	public Rectangle(Point upperLeft, int width, int height, Color border, Color inside) {
		this(upperLeft, width, height);
		setBorder(border);
		setInside(inside);
	}
	
	public Rectangle (Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}

	
	// geteri i seteri 
	
	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	/* public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	} */
	
	// metode 
	
	public String toString() {
		return "Upper left point: " + upperLeft + ", width = " + width + ", height = " + height;
		}
	
	public double area () {
		return width * height;
	}
	
	public double volume () {
		return 2 * width + 2 * height;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle temp = (Rectangle) obj;
			return upperLeft.equals(temp.upperLeft) && height == temp.height && width == temp.width;
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return(upperLeft.getX() <x && x < upperLeft.getX() + width && upperLeft.getY() <y && y < upperLeft.getY() + height);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getBorder());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		
		if (selected) {
			g.setColor(Color.BLUE);
			selectedShape(g);
			}
		
	}
	
	@Override
	public void selectedShape(Graphics g) {
		g.drawRect(upperLeft.getX() - 2, upperLeft.getY() - 2, 4, 4);
		g.drawRect(upperLeft.getX() + width - 2, upperLeft.getY() - 2, 4, 4);
		g.drawRect(upperLeft.getX() - 2, upperLeft.getY() + height - 2, 4, 4);
		g.drawRect(upperLeft.getX() + width - 2, upperLeft.getY() + height - 2, 4, 4);
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return (int) (this.area() - ((Rectangle)o).area());
		}
		return 0;
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
		
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
		
	}

	@Override
	public void paintInside(Graphics g) {
		g.setColor(getInside());
		g.fillRect(upperLeft.getX() + 1, upperLeft.getY() + 1, width - 1, height - 1);
		
	}

	
	
	
	

}
