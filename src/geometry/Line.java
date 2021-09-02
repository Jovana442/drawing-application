package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	
	// promenljive
	
	private Point startPoint;
	private Point endPoint;

	
	
	// konstruktori
	
	public Line () {
			
	}
		
	public Line (Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
		
		public Line(Point startPoint, Point endPoint, Color border, Color inside) {
			this(startPoint, endPoint);
			setBorder(border);
			setInside(inside);
	}
		
	public Line (Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	// geteri i seteri
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	/* public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	} */
	
	// metode 
	
	public String toString() {
		return startPoint + "-->" + endPoint;
		
	}
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line temp = (Line) obj;
			return startPoint.equals(temp.startPoint) && endPoint.equals(temp.endPoint);
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return (startPoint.distance(x, y) + endPoint.distance(x, y)) - length() <2;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getBorder());;
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		
		if (selected) {
			g.setColor(Color.BLUE);
			selectedShape(g);
		}
		
	}
	
	@Override
	public void selectedShape(Graphics g) {
		g.drawRect(this.getStartPoint().getX() - 2, this.getStartPoint().getY() - 2, 4, 4);
		g.drawRect(this.getEndPoint().getX() - 2, this.getEndPoint().getY() - 2, 4, 4);
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Line) {
			return (int) (this.length() - ((Line)o).length());
		}
		return 0;
	}

	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
		
	}

	@Override
	public void moveTo(int x, int y) {
		
		
	}

	@Override
	public void paintInside(Graphics g) {
	
		
	}

	
	

}
