package NIIT;
class Point{
	private int x;
	private int y;
	
	Point(){
		this(0);
	}
	
	Point(int value){
		this(value, value);
	}
	
	Point(int x_, int y_){
		x = x_;
		y = y_;
	}
	
	@Override
	public String toString() {                  //переопределение метода toString
		//	return super.toString();
		return "Point: x = " + x + ", y = " + y;
	}
}
public class classWork1 {
	public static void main(String[] args) {
		Point a = new Point();					// в этом случае вызывается конструктор по умолчанию
//		a.x = 5;								//не можем обратиться, т.к.private поле
		Point b = new Point(1);
		//b.x = 2;
		//b.y = 2;
		Point c = new Point(2, 2);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
