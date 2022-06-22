package lecture.chapter9;

public class Point2D {

  private int x;
  private int y;

  /*
  public int hashCode(){
    return x + y;
  }
  */

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Point2D point2D = (Point2D) o;

    if (x != point2D.x) return false;
    return y == point2D.y;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }
}
