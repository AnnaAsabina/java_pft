package ru.stqa.pft.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.PointProgramm.Point;

public class PointTests {
  @Test
  public void testDistance(){
    Point pointA = new Point(23, 35);
    Point pointB = new Point(22, 39);

    Assert.assertEquals(pointA.distance(pointB),4.123105625617661);
  }
}