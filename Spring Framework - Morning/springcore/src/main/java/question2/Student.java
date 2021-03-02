package question2;

import org.springframework.stereotype.Component;

@Component
public class Student {
    String name;

    public String getName() {
        return "Inside getName function : "+name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public void throwsException() throws ArithmeticException {
        throw new ArithmeticException("Arithmetic exception");
    }
}