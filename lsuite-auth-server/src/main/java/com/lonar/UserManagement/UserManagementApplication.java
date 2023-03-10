package com.lonar.UserManagement;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.lonar.UserManagement.security.AuthorizationServerConfiguration;
import com.lonar.UserManagement.security.ResourceServerConfiguration;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lonar.UserManagement.*"})
@PropertySource({ "classpath:persistence.properties" })
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
@Configuration
public class UserManagementApplication extends SpringBootServletInitializer{

	@Autowired
	private Environment env;
	
	/*@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;*/
	
	public static Map<Integer,String> messageList=new HashMap<Integer,String>();
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserManagementApplication.class);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(new Class[] {UserManagementApplication.class,
				AuthorizationServerConfiguration.class,
				ResourceServerConfiguration.class },
				args);
	}
	
	
	@Bean
	//@Primary
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	       dataSource.setDriverClassName(env.getProperty("db.driver"));
	       dataSource.setUrl(env.getProperty("db.url"));
	       dataSource.setUsername(env.getProperty("db.username"));
	       dataSource.setPassword(env.getProperty("db.password"));
	       return dataSource;
	}
	 
}
