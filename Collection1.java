
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student>{
	
	public int rollno;
	public String name;
	public int age;
	 
	public Student(int rollno,String name,int age){    
	 this.rollno=rollno;    
	 this.name=name;    
	 this.age=age;    
	 }

	 /** here comparing based on age */
	@Override
	public int compareTo(Student st) {
		if(this.age == st.age) {
			return 0;
		}
		else if(this.age > st.age) {
			return 1;
		}
		else {
		    return -1;
		}
	}	
}

public class MainDriverClass {
    public static void main(String[] args) {
		
    	ArrayList<Student> al=new ArrayList<Student>();
    	al.add(new Student(101,"Vijay",23));
    	al.add(new Student(106,"Ajay",27));
    	al.add(new Student(105,"Jai",21));
    	
    	Collections.sort(al);
    	
    	for(Student st : al) {
    		System.out.println(st.rollno + " : "+st.name +" : "+st.age);
    	}
	}
}
