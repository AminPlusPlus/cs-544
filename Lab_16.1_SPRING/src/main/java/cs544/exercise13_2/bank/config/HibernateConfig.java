package cs544.exercise13_2.bank.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class HibernateConfig {

    @Bean
    public DataSource dataSource(){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306");
        mysqlDataSource.setUser("cs544");
        mysqlDataSource.setPassword("tjkdevelopment");

        System.out.println("sql connected :" + mysqlDataSource.getDescription());
        return mysqlDataSource;
    }
}
