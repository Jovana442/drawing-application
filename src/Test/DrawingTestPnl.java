package Test;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

public class DrawingTestPnl extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Jovana Malic Drawing");
		
		frame.setSize(800,800);
		frame.setVisible(true);
		DrawingTestPnl drawingTestPnl = new DrawingTestPnl();
		drawingTestPnl.setBackground(Color.white);
		frame.getContentPane().add(drawingTestPnl);
		
		

	}
	
	// metode
	
	public void paint(Graphics g) {
		Point p1 = new Point(50,50);
		p1.draw(g);
		
		Line l1 = new Line(new Point(100,100), new Point(200,200), true);
		l1.draw(g);
		
		Circle c1 = new Circle(new Point(400, 200), 70, true);
		c1.draw(g);
		
		Rectangle r1 = new Rectangle(new Point(500,500), 60, 60, true);
		r1.draw(g);
		
		
	}

}
