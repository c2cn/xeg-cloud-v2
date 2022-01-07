//package com.xiaoergekeji.cloud.common.mysql;
//
//import org.flywaydb.core.Flyway;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
///**
// * @author ArchieDing
// * @since 2020/09/07
// */
////@Configuration
//public class FlywayConfig {
//	@Resource
//	private DataSource dataSource;
//
//	@PostConstruct
//	public void migrate() {
//		Flyway flyway = Flyway.configure()
//			.dataSource(dataSource)
//			.locations("db/migration")
//			.baselineOnMigrate(true)
//			.load();
//		flyway.migrate();
//	}
//}
