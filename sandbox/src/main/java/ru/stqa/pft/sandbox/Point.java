package ru.stqa.pft.sandbox;


public class Point {
  public double x;
  public double y;

  public Point(double x,double y) {
    this.x=x;
    this.y=y;
  }

  public double distance(Point pointB){
    double AC = Math.pow (this.x - pointB.x, 2);
    double BC = Math.pow(this.y - pointB.y, 2);
    return Math.sqrt(AC + BC);
  }

}


