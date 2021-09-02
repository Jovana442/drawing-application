package drawing;


import java.awt.Graphics;

import java.util.ArrayList;
import javax.swing.JPanel;

import geometry.Shape;

public class PnlDrawing extends JPanel {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	// kreiranje panela
	
	public PnlDrawing() {
		
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape shape : shapes) {
			shape.paintInside(g);
			shape.draw(g);
			
		}
		repaint();
		
	}
	
	
	// geteri i seteri
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	
	
	

	

}
