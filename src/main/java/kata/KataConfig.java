package kata;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan("com.nttdata.kata")
@EnableAutoConfiguration
@EnableJpaRepositories("com.nttdata.kata.repository")
public class KataConfig {
	   @Bean
	    public DataSource dataSource()
	    {
	        return new EmbeddedDatabaseBuilder().setType( EmbeddedDatabaseType.H2 ).build();
	    }
	 
	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory( DataSource dataSource, JpaVendorAdapter jpaVendorAdapter )
	    {
	        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
	        lef.setDataSource( dataSource );
	        lef.setJpaVendorAdapter( jpaVendorAdapter );
	        lef.setPackagesToScan( "com.nttdata.kata.domain" );
	        return lef;
	    }
	 
	    @Bean
	    public JpaVendorAdapter jpaVendorAdapter()
	    {
	        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
	        hibernateJpaVendorAdapter.setShowSql( true );
	        hibernateJpaVendorAdapter.setGenerateDdl( true );
	        hibernateJpaVendorAdapter.setDatabase( Database.H2 );
	        return hibernateJpaVendorAdapter;
	    }
	 
	    @Bean
	    public PlatformTransactionManager transactionManager()
	    {
	        return new JpaTransactionManager();
	    }
	 

    public static void main(String[] args) {
    	//SpringApplication.run(Application.class, args);
    	
        ApplicationContext ctx = SpringApplication.run(KataConfig.class, args);
        

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

    }
}
