package tools.mysb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages={"tools.config", "tools.mysb", "tools.mybatis.service", "tools.jpa.service"} )
public class App {
	
	public static void main (String[] args) {
		SpringApplication.run(App.class, args);
	}	
}
