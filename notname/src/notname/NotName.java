package notname;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class TestMap extends HashMap{ 
    @Override 
    public Set keySet(){ 
        return  null; 
    } 
} 

class NotName{ 
    public static void main(String[] args){ 
        Map map = new TestMap(); 
        for(Object o: map.keySet()){ 
            System.out.println(o); 
        } 
    } 
} 
