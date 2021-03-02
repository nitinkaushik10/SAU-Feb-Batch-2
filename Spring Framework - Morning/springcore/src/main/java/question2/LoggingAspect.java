package question2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    @Before("execution(public String getName())")
    public void LoggingAdviceBefore() {
        System.out.println("Logging Advice : Before");

    }

    @After("execution(public String getName())")
    public void LoggingAdviceAfter() {
        System.out.println("Logging Advice : After");

    }

    @AfterReturning("execution(public String getName())")
    public void LoggingAdviceAfterReturning() {
        System.out.println("Logging Advice : AfterReturning");

    }

    @AfterThrowing("execution(public void throwsException())")
    public void LoggingAdviceAfterThrowing() {
        System.out.println("Logging Advice : AfterThrowing");

    }

    @Around("execution(public String getName())")
    public Object LoggingAdviceAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Before Advice: Around");
        Object retVal = pjp.proceed();
        System.out.println("After Advice: Around");
        return retVal;
    }

}