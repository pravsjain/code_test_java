package com.internationalsos.doctorpatientapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.datasource.internationalsos")
public class ConnectionPoolConfiguration {

	private long idleTimeout;
	private int maximumPoolSize;
	private long connectionTimeout;
	private long leakDetectionThreshold;
	private long maxLifetime;
	private boolean autoCommit;

	public long getIdleTimeout() {
		return idleTimeout;
	}

	public void setIdleTimeout(long idleTimeout) {
		this.idleTimeout = idleTimeout;
	}

	public int getMaximumPoolSize() {
		return maximumPoolSize;
	}

	public void setMaximumPoolSize(int maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}

	public long getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(long connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public long getLeakDetectionThreshold() {
		return leakDetectionThreshold;
	}

	public void setLeakDetectionThreshold(long leakDetectionThreshold) {
		this.leakDetectionThreshold = leakDetectionThreshold;
	}

	public long getMaxLifetime() {
		return maxLifetime;
	}

	public void setMaxLifetime(long maxLifetime) {
		this.maxLifetime = maxLifetime;
	}

	public boolean isAutoCommit() {
		return autoCommit;
	}

	public void setAutoCommit(boolean autoCommit) {
		this.autoCommit = autoCommit;
	}

	@Override
	public String toString() {
		return "ConnectionPoolConfiguration [idleTimeout=" + idleTimeout + ", maximumPoolSize=" + maximumPoolSize
				+ ", connectionTimeout=" + connectionTimeout + ", leakDetectionThreshold=" + leakDetectionThreshold
				+ ", maxLifetime=" + maxLifetime + ", autoCommit=" + autoCommit + "]";
	}
}
