package cs544.exercise13_2.bank.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "cs544.exercise13_2.bank")
@Import({Daoconfig.class,Jmsconfig.class})
public class AppConfiguration {



}
