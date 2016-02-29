package exceptions.exercises;

/**
 * (IllegalTriangleException) Exercise 11.1 defined the Triangle class with
 * three sides. In a triangle, the . The
 * Triangle class must adhere to this rule. Create the IllegalTriangleException class,
 * and modify the constructor of the Triangle class to throw an IllegalTriangle Exception object
 * if a triangle is created with sides that violate the rule.
 *
 * Created by David on 1/14/2016.
 */

public class Ex13_5 {
  public static void main(String[] args) {
      Triangle triangle = new Triangle(1, 1.5, 1);
      triangle.setColor("yellow");
      triangle.setFilled(true);

      System.out.println(triangle);
      System.out.println("The area is " + triangle.getArea());
      System.out.println("The perimeter is "
              + triangle.getPerimeter());
      //test if it throws properly

      Triangle triangle1 = new Triangle(10, 1.5, 1);
  }
}
