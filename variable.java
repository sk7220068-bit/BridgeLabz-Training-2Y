import java.util.*;
public class variable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1= sc.next();
        
        String str2= "shivam"; 
        String str3 = new String("shivam");
        
        
        System.out.println(str1==str3);
        System.out.println(str1==str2);
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));
        
        String names[]= {"shivam","rahul", "abhishek","aishwarya"}; 
        for(int i =0; i<names.length;i++) {
            if (str1.equals(names[i])) {
                System.out.println("Student Registered");
                break;
            } 
            else {
                System.out.println("Student Not Found");
            }
        }
        
    }
}   


  

