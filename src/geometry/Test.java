package geometry;

public class Test {

	public static void main(String[] args) {
	

		
		Point p1 = new Point();
		System.out.println(p1);
		
		Point p2 = new Point (10, 10, true);
		System.out.println(p2);
		
		Line ln1 = new Line();
		ln1.setStartPoint(p1);
		ln1.setEndPoint(p2);
		System.out.println("Line ln1: " + ln1);
		System.out.println("Line ln1 length is: " + ln1.length());
		
		Rectangle rt1 = new Rectangle();
		System.out.println(rt1);
		
		Rectangle rt2 = new Rectangle();
		rt2.setUpperLeft(p2);
		rt2.setWidth(30);
		rt2.setHeight(15);
		rt2.setSelected(false);
		System.out.println(rt2);
		
		Rectangle rt3 = new Rectangle (new Point(15,15), 12, 12, false);
		System.out.println(rt3);
		
		Circle c1 = new Circle( p2, 10, false);
		System.out.println(c1);
		
		Circle c2 = new Circle(new Point(15,2), 22, false);
		
		// Poredjenje povrsina krugova
		
		if (c1.area() > c2.area()) {
			System.out.println("Povrsina kruga c1 je veca");
		}
		else if(c1.area()<c2.area()) {
			System.out.println("Povrsina kruga c2 je veca");
		}
		else {
			System.out.println("Povrsine krugova su identicne");
		}
		
		
		// Poredjenje obima krugova
		
		if (c1.volume()>c2.volume()) {
			System.out.println("Oblim kruga c1 je veci");
		}
		
		else if (c1.volume()<c2.volume()) {
			System.out.println("Obim kruga c2 je veci");
		}
		else {
			System.out.println("Obimi krugova su identicni");
		}
		
		
		// Poredjenje povrsina kruga i pravougaonika
		
		if (c1.area()>rt1.area()) {
			System.out.println("Povrsina kruga je veca");
		}
		else if (c1.area()<rt1.area()) {
			System.out.println("Povrsina pravougaonika je veca");
		}
		else {
			System.out.println("Povsine su identicne");
		}
		
		
		Donut d1 = new Donut(new Point(7,7), 12, 9, false);
		System.out.println("Krofna 1: " + d1);
	}

}
