package question1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main 
{
    public static void main( String[] args )
    {
        ApplicationContext obj = new AnnotationConfigApplicationContext(AppConfig.class);
        Rectangle rectangle = (Rectangle)obj.getBean("rectangleObj");
       
        rectangle.draw();
        System.out.println("Height of the rectangle  :" + rectangle.getHeight());
        System.out.println("Width of the rectangle   :" + rectangle.getWidth());
    }

}