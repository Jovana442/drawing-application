package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable, Movable{
	
	//promenljive
	
	protected boolean selected;
	private Color border = Color.BLACK;
	private Color inside = Color.WHITE;
	
	
	
	
	// kontruktori
	
	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
		

	
	// geteri i seteri
	
	public boolean getSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	
	public Color getBorder() {
		return border;
	}

	public void setBorder(Color border) {
		this.border = border;
	}

	public Color getInside() {
		return inside;
	}

	public void setInside(Color inside) {
		this.inside = inside;
	}
	
	// apstraktne metode

	public abstract boolean contains (int x, int y);
	public abstract void draw (Graphics g);
	public abstract void selectedShape(Graphics g);
	public abstract void paintInside(Graphics g);
	

}
