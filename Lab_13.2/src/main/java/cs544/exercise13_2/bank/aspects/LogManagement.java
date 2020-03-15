package cs544.exercise13_2.bank.aspects;
import cs544.exercise13_2.bank.logging.ILogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogManagement {

    @Autowired
    ILogger logger;

    @After("execution(* cs544.exercise13_2.bank.dao..*.*(..))")
    public void printsLogDAO(){
    logger.log("DAO Called");
    }



    @Around("execution(* cs544.exercise13_2.bank.service..*.*(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        logger.log("Service Time to execute  = "+totaltime+"ms");

        return retVal;
    }

    @After("execution(* cs544.exercise13_2.bank.jms..*.*(..))")
    public void printsLogJMS(){
        logger.log("JMS SENT");
    }

    @Around("execution(* cs544.exercise13_2.bank.domain.Calculator.add(..))")
    public Object aroundCalculator (ProceedingJoinPoint call) throws Throwable {
        Object[] args = call.getArgs();
        int x = (Integer)args[0];
        int y = (Integer)args[1];
        System.out.println("CalcAdvice.changeNumbers: x= "+x+"and y= "+y);

        args[0]=5;
        args[1]=9;
        Object object= call.proceed(args);

        System.out.println("CalcAdvice.changeNumbers: call.proceed returns "+object);
        return object;

    }

}
