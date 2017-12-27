
package ru.stqa.pft.PointProgramm;

public class PointDistanceProgramm {
  public static void main(String[] args) {

    Point pointA = new Point(23, 35);
    Point pointB = new Point(22, 39);

    System.out.println("Расстояние между точками равно " + pointA.distance(pointB));
  }


}
