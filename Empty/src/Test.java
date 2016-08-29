class TestObservable extends java.util.Observable {
   private String name = "";
   public TestObservable(String name) {
      this.name = name;
   }

   public void modify() {
      setChanged();
   }

   public String getName() {
      return name;
   }
}

class TestObserver implements java.util.Observer {
   private String name = "";

   public TestObserver(String name) {
      this.name = name;
   }
   public void update(java.util.Observable o,Object arg) {
      String str = "Called update of " + name;
      str += " from " + ((TestObservable)o).getName();
      str += " with argument " + (String)arg;
      System.out.println(str);
   }
}
public class Test {
   public Test() {
   }
   public static void main(String[] args) {
      Test test = new Test();
      TestObservable to = new TestObservable("Observable");
      TestObserver o1 = new TestObserver("Observer 1");
      TestObserver o2 = new TestObserver("Observer 2");
      to.addObserver(o1);
      to.addObserver(o2);
      to.modify();
      to.notifyObservers("Notify argument");
   }
}