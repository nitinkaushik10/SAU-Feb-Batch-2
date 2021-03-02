package question2;

import question2.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Main 
{
    public static void main( String[] args )
    {
        ApplicationContext obj = new FileSystemXmlApplicationContext("name.xml");
        Student student =obj.getBean("student", Student.class);
        System.out.println(student.getName());
        try{
            student.throwsException();
        }
        catch(Exception e){
            System.out.println("Catching exception ");
        }

    }
}