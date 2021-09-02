package geometry;


import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	
// promenljive
	
	private int x;
	private int y;
	

	
// konstruktori 
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, Color border) {
		this(x, y);
		setBorder(border);
	}
	
	public Point(int x, int y, boolean selected) {
		this (x,y);
		this.selected = selected;
	}
	
	
	

// geteri i seteri 
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/* public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	} */
	
	// metode
	
	public String toString() {
		return "(" + x +"," + y + ")";
	}
	
	public double distance (int x, int y) {
		int dx = this.x - x;
		int dy = this.y - y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point temp = (Point) obj;
			if (x == temp.x && y == temp.y) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getBorder());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y+2, x, y-2);
		
		if (selected) {
			g.setColor(Color.BLUE);
			selectedShape(g);
		}
	}
	
	@Override
	public void selectedShape(Graphics g) {
		g.drawRect(x - 2, y - 2, 4, 4);
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Point) {
			return (int) (this.distance(0, 0) - ((Point) o).distance(0,0));
		}
		return 0;
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y = this.y + byY;
		
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	@Override
	public void paintInside(Graphics g) {
	
		
	}

	
	
	
	

}
