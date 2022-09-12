package com.internationalsos.doctorpatientapp.config;

import javax.sql.DataSource;

import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.internationalsos.doctorpatientapp.mapper.PatientMapper;

@Configuration
@MapperScan("com.internationalsos.doctorpatientapp.mapper")
public class MyBatisConfiguration {
	private static final String CSTORE_SESSION_FACTORY = "cstoreSF";

	public MyBatisConfiguration() {
		LogFactory.useLog4J2Logging();

	}

	@Bean(name = CSTORE_SESSION_FACTORY, destroyMethod = "")
	@Primary
	public SqlSessionFactoryBean cstoreSQLSessionFactory(
			@Name(DatabaseConfiguration.CSTORE_DATASOURCE) final DataSource oneDataSource) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(oneDataSource);
//		sqlSessionFactoryBean.setTypeAliases(new Class[] {PatientModel.class});
		sqlSessionFactoryBean.setTypeAliasesPackage("com.internationalsos.doctorpatientapp.model");
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
		sqlSessionFactory.getClass();

		return sqlSessionFactoryBean;
	}

	@Bean
	public MapperFactoryBean<PatientMapper> programMapper(
			@Name(CSTORE_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
		MapperFactoryBean<PatientMapper> factoryBean = new MapperFactoryBean<PatientMapper>(PatientMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
		return factoryBean;
	}

}