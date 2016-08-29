package NIIT;

import java.util.LinkedList;

interface Listener{
    void action();
}

interface Handler{
    void addListener(Listener l);
    void rmListener(Listener l);
    void fire();
}

class A implements Listener{
    public void print(){
        System.out.println("class A");
    }

    @Override
    public void action() {
        print();
    }
}
class B implements Listener{
    public void print(){
        System.out.println("class B");
    }
    
    @Override
    public void action() {
        print();
    }
}
class C implements Listener{
    public void print(){
        System.out.println("class C");
    }
    @Override
    public void action() {
        print();
    }
}

class F implements Handler{

    LinkedList<Listener> list = new LinkedList<>();
        
    @Override
    public void addListener(Listener l) {
        list.add(l);
    }

    @Override
    public void rmListener(Listener l) {
        list.remove(l);
    }

    @Override
    public void fire() {
        for(Listener l : list){
            l.action();
        }
    }
 }

public class Observer {
    public static void main(String[] args){
        A a = new A();
        B b = new B();
        C c = new C();
        A a2 = new A();
        
        F f = new F();
        
        f.addListener(a);
        f.addListener(b);
        f.addListener(c);
        f.addListener(a2);
        
        f.fire();
        
        f.rmListener(a);
        f.rmListener(a2);
        
        f.addListener(new Listener() {

            @Override
            public void action() {
                System.out.println("some action!!!");
            }
        });
        
        f.fire();
    }
}
