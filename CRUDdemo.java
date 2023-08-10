package material;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

class Employee1 implements Serializable {
    int empno;
    String ename;
    int salary;

    Employee1(int empno, String ename, int salary) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    public String toString() {
        return empno + " " + ename + " " + salary;
    }
}

public class CRUDdemo {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        int choice = -1;
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file = new File("D:\\raunak.txt");
        ArrayList<Employee1> a1 = new ArrayList<Employee1>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator<Employee1> li = null;

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            a1 = (ArrayList<Employee1>) ois.readObject();
            ois.close();
        }

        do {
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("0.EXIT");
            System.out.println("ENTER YOUR CHOICE:");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter how many employees you want:");
                    int n = s.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter employee no:");
                        int empno = s.nextInt();
                        System.out.print("Enter employee name:");
                        String ename = s1.nextLine();
                        System.out.print("Enter employee salary:");
                        int salary = s.nextInt();
                        a1.add(new Employee1(empno, ename, salary));
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(a1);
                    oos.close();
                    break;
                case 2:
                	if(file.isFile())
                	{
                	oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(a1);
                    oos.close();
                    System.out.println("--------------------------------");
                    li = a1.listIterator();
                    while (li.hasNext()) {
                        System.out.println(li.next());
                    }
                    System.out.println("--------------------------------");
                    break;
                	}
                    else
                    {
                    	System.out.println("file not exists........");
                    }
                case 3:
                	if(file.isFile())
                	{
                	oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(a1);
                    oos.close();			
                    boolean found = false;
                    System.out.println("Enter empno to search:");
                    int empno = s.nextInt();
                    System.out.println("--------------------------------");
                    li = a1.listIterator();
                    while (li.hasNext()) {
                        Employee1 e = li.next();
                        if (e.empno == empno) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record not found...");
                        System.out.println("--------------------------------");
                    }
                	}
                    else
                    {
                    	System.out.println("file not exists........");
                    }
                    break;
                case 4:
                	if(file.isFile())
                	{
                	oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(a1);
                    oos.close();			
                    boolean found = false;
                    System.out.println("Enter empno to delete:");
                    int empno = s.nextInt();
                    System.out.println("--------------------------------");
                    li = a1.listIterator();
                    while (li.hasNext()) {
                        Employee1 e = li.next();
                        if (e.empno == empno) 
                        {
                        	li.remove();
                            found = true;
                        }
                    }
                    if (found) 
                    {
                    	oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(a1);
                        oos.close();
                    	System.out.println("record deleted sucessfully");
                    }
                        else
                        {
                        	System.out.println("Record not found...");	
                        }
                        	System.out.println("--------------------------------");
                    }
                	
                    else
                    {
                    	System.out.println("file not exists........");
                    }
                    break;	
                case 5:
                	if(file.isFile())
                	{
                	oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(a1);
                    oos.close();			
                    boolean found = false;
                    System.out.println("Enter empno to update:");
                    int empno = s.nextInt();
                    System.out.println("--------------------------------");
                    li = a1.listIterator();
                    while (li.hasNext()) {
                        Employee1 e = li.next();
                        if (e.empno == empno) 
                        {
                        	System.out.print("Enter new Empname:");
                        	String ename = s1.nextLine();
                        	System.out.print("Enter new salary :");
                        	int sal = s.nextInt();
                            li.set(new Employee1(empno,ename,sal));
                            found = true;
                        }
                    }
                    if (found) 
                    {
                    	oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(a1);
                        oos.close();
                    	System.out.println("record updated sucessfully");
                    }
                        else
                        {
                        	System.out.println("Record not found...");	
                        }
                        	System.out.println("--------------------------------");
                    }
                	
                    else
                    {
                    	System.out.println("file not exists........");
                    }
                    break;		
                	
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}
