package com.test.ouyang;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.test.ouyang.banner.MyBannner;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.test.ouyang.mapper")
public class Application {
	public static Logger log_ = Logger.getLogger(Application.class.getName());
	
	/**
	 * 配置spring datasource
	 * 使用C3P0连接池
	 * 在application.properties中设置datasource的前缀必须由是spring.datasource开始
	 * */
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource(){
		return  new ComboPooledDataSource();
	}
	/**
	 * 读取mybatis配置文件并获取sessionFactory
	 * */
	@Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }
	/**
	 * 添加事务管理
	 * */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    /**
     * 服务启动
     */
    public static void main(String[] args) {
    	SpringApplication application = new SpringApplication(Application.class);
    	MyBannner bannner = new MyBannner();
    	application.setBanner(bannner);
    	application.run(args);
        log_.info("SpringBoot Start Success");
    }
}
