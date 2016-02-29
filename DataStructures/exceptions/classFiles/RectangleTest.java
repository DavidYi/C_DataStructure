package exceptions.classFiles;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle (4, -5);
		Rectangle r2 = new Rectangle (8, 7);
		
		System.out.println("Area: " + r1.getArea());
		System.out.println("Area: " + r2.getArea());
		
		r2.setWidth(-1);
		System.out.println("Area: " + r2.getArea());
	}
}
