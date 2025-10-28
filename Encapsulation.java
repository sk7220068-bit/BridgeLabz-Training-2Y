
class Student{
	
	private int Rollno;
    
    private String name;

    public String getName() { 
    	return name; 
    }
    
    public void setRollno(int rollno) {
    	this.Rollno = rollno;
    }
    
    public int getRollno() { 
    	return Rollno ; 
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    
}

public class  Encapsulation {
    
    public static void main(String[] args) {
        Student s= new Student();
        s.setName("Shivam"); 
        System.out.println("Name=> " + s.getName());
    }
}
