package cs544.exercise13_1.aspect;

import cs544.exercise13_1.EmailSender;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

import java.util.logging.Logger;

@Aspect
public class LogManagement {

    @After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email,message)")
    public void executeLogAfterMail(JoinPoint jp, String email, String message){

        EmailSender sender = (EmailSender)jp.getTarget();

        java.util.logging.Logger.getLogger("").info(jp.getSignature().getName()
                + " address= " + email + "\nmessage= "+message +
                " \n outgoing mail server = "+sender.getOutgoingMailServer() );
    }

    @Around("execution(* cs544.exercise13_1.CustomerDAO.save(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println("Time to execute save = "+totaltime+"ms");

        return retVal;
    }

}
