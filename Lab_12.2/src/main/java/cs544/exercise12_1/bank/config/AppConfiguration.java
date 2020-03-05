package cs544.exercise12_1.bank.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "cs544.exercise12_1.bank")
@Import({Daoconfig.class,Jmsconfig.class})
public class AppConfiguration {

}
