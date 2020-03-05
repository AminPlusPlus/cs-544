package cs544.exercise12_1.bank.config;


import cs544.exercise12_1.bank.dao.AccountDAO;
import cs544.exercise12_1.bank.dao.IAccountDAO;
import cs544.exercise12_1.bank.jms.IJMSSender;
import cs544.exercise12_1.bank.jms.JMSSender;
import cs544.exercise12_1.bank.logging.ILogger;
import cs544.exercise12_1.bank.logging.Logger;
import cs544.exercise12_1.bank.service.AccountService;
import cs544.exercise12_1.bank.service.CurrencyConverter;
import cs544.exercise12_1.bank.service.IAccountService;
import cs544.exercise12_1.bank.service.ICurrencyConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "cs544.exercise12_1.bank")
public class AppConfiguration {

}
