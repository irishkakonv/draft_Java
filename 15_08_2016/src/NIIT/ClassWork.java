package NIIT;

class Point{
	private int x;
	private int y;
	
	public int m(int value){
		return 42;
	}
	
	public double m(double value){
		return 42;
	}
	
	public void f(){
		System.out.println("f() no data");
	}
	
	public void f(int value){
		System.out.println("f(int)" + value);
	}
	
	public void f(double value){
		System.out.println("f(double)" + value);
	}
	
	public void f(String value){
		System.out.println("f(string)" + value);
	}
	/*public void f_void(){
		System.out.println("f() no data");
	}
	public void f_int(int value){
		System.out.println("f(int)" + value);
	}
	
	public void f_double(double value){
		System.out.println("f(double)" + value);
	}
	
	public void f_string(String value){
		System.out.println("f(string)" + value);
	}*/
	/*public Point(int x_, int y_){
		x = x_;
		y = y_;
	}*/
	
	public Point(){
		this(0,0);
	}
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public Point(int value){
		x = value;
		y = value;
	}
	
	public Point(String line, double xv, int yv){
		this((int)xv, yv);
		System.out.println("Point (text, d, i))" + line);
	}
	
	
	public void move(int dx, int dy){
		x += dx;
		y += dy;
	}


	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		
		if(o == this){
			return true;
		}
		
		if(! (o instanceof Point)){
			return false;
		}
		
		Point other = (Point)o;
		boolean eq = false;
		if ((x == other.x) && y == other.y){
			eq = true;
		}
		else{
			eq = false;
		}
		return eq;
	}
	
	@Override                                      //переопределяем метод toString
	public String toString(){
		return "x = " + x + ", y = " + y;
	}
}	

class Point3D extends Point{
	private int z;
	Point3D(int x, int y, int z){
		super(x, y);
		this.z = z;
	}
	@Override                                      //переопределяем метод toString
	public String toString(){
		String point = super.toString();
		return point + ", z = " + z;
	}
	
}
public class ClassWork {
	//static Point ps = new Point(1,1);  //ссылка хранится в статической памяти, объект в динамической
	public static void main(String[] args) {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(2, 2);
		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);
		System.out.println("_______________");
		//String info = p1.toString();  //приведение к строке
		//String info = "point " + p1; //автоматически приводит к toString
		
		/*p2 = p1;
		p2.x = 3;
		p2.y = 3;*/
		
		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);
		
		p2.move(-1, -1);  //сравниваем точки по координатам
		if(p1.equals(p2)){System.out.println("EQ");
		}
		else{
			System.out.println("NOT EQ");
		}
		
		/*p1.f_void();
		p1.f_int(1);
		p1.f_double(3.14);
		p1.f_string("fgh");*/
		p1.f();                 //перегрузка методов
		p1.f(1);
		p1.f(3.14);
		p1.f("text");
		
		p1.m(1230);
		p1.m(3.14);
		
		//Point p3 = new Point("text", 3.14, 5);
		Point3D p3 = new Point3D(1, 2, 3);
		p3.move(3, 3);
		System.out.println("p3 = " + p3.toString());
	}
}
