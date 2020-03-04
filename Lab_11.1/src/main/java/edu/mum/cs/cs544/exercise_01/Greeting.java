package edu.mum.cs.cs544.exercise_01;

public class Greeting {
    private String greeting;

    public Greeting() {}
    public Greeting(String greeting){
        this.greeting=greeting;
    }
    public void sayHello(){
        System.out.println(greeting);
    }
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}