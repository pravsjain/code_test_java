package com.internationalsos.doctorpatientapp.config;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan("com.internationalsos.doctorpatientapp.mapper")
public class DatabaseConfiguration {

	private static final Logger LOGGER = LogManager.getLogger(DatabaseConfiguration.class);
	public static final String CSTORE_DATASOURCE = "cstoreDS";

	@Autowired
	ConnectionPoolConfiguration cPool;

	@Bean(name = CSTORE_DATASOURCE, destroyMethod = "")
	@ConfigurationProperties(prefix = "spring.datasource.internationalsos")
	@Primary
	public DataSource switchDataSource() {
		// Filled up with the properties specified
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setIdleTimeout(cPool.getIdleTimeout());
		dataSource.setMaximumPoolSize(cPool.getMaximumPoolSize());
		dataSource.setConnectionTimeout(cPool.getConnectionTimeout());
		dataSource.setLeakDetectionThreshold(cPool.getLeakDetectionThreshold());
		dataSource.setMaxLifetime(cPool.getMaxLifetime());
		dataSource.setAutoCommit(cPool.isAutoCommit());
		LOGGER.info(cPool.toString());

		return dataSource;
	}

}