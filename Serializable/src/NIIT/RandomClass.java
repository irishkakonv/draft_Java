package NIIT;

import java.io.*;

public class RandomClass implements Serializable{  
	private static int r(){						// Генерация рандомного значения
        return (int)(Math.random() * 10);
 }
	private int[] datafile;
                                                   
	public RandomClass(){								 // Конструктор
		datafile = new int[r()];
        for (int i = 0; i < datafile.length; i++){
        	datafile[i]=r();
        }	
 }
    public void printout(){
    	System.out.println("This RandomClass has " + datafile.length + " random integers");
    	for (int  i = 0; i < datafile.length; i++){
    		System.out.print(datafile[i] + ":");
    		System.out.println();
    	}
    }	
}