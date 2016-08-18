package NIIT;

import java.io.*;
import java.util.*;

public class OutSerialize {
    public static void main (String args[]) throws IOException{
        RandomClass rc1 = new RandomClass();
        RandomClass rc2 = new RandomClass();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objects.dat")); //�������� ���� ������� � ������� ������ ������� � �����
        Date now = new Date(System.currentTimeMillis());									  //java.util.* ��� ������������ ��� ������������� ������ Date

        out.writeObject(now);
        out.writeObject(rc1);
        out.writeObject(rc2);
        out.close();
        System.out.println("I have written: ");
        System.out.println("A Date object: " + now);
        System.out.println("Two Group of randoms ");
        rc1.printout();
        rc2.printout();
 }
}