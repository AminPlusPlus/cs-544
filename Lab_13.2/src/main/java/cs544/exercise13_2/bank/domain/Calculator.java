package cs544.exercise13_2.bank.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Calculator {


    public Calculator() {
        System.out.println("Call Constructor");
    }



    public int add(int x, int y){
        System.out.println("Calculator.add receiving x= "+x+" and y= "+y); return x+y;
    }
}