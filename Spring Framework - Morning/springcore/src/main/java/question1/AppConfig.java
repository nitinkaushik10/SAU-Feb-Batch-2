package question1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

   
    @Bean(name="rectangleObj")
    public Rectangle getRectangle() {
        return new Rectangle();
    }

    @Bean(name="pointObj")
    public Point getPoint() {
        return new Point(0,0);
    }

    @Bean(name="Point1")
    public Point getPoint1() {
        return new Point(0,0);
    }

    @Bean(name="Point2")
    public Point getPoint2() {
        return new Point(20,0);
    }

    @Bean(name="Point3")
    public Point getPoint3() {
        return new Point(20,20);
    }

    @Bean(name="Point4")
    public Point getPoint4() {
        return new Point(0,20);
    }

}
