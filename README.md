# spring-batch-sandbox
A project that shows spring batch capabilities and integration with other frameworks (http://projects.spring.io/spring-batch/)

# Project parts
Maven project that consists of the following parts:
- Java main classes are under (`src/main/java/main`) with different demo samples
- Spring batch infrastructure components are under (`src/main/java/org.spring.batch.infrastructure`)
- Test extentions for executing tests with spring batch (src/test/java)

# Building project
`mvn clean package` to build
`mvn clean pre-integration-test -Dembedmongo.wait` to run mongodb locally

# Spring batch main features demo
Main features examples are under src/main/java folder. It is simply classes with main methods, that explain the feature and ready to be executed and provide log that shows the results.
- `concurrent` for concurrent features
- `exceptional` for exceptional cases with skips, retries, failed states
- `general` for simple demos with task executor, java config, jdbc xml config
- `hibernate` with Hibernate reader/writers capabilities and integration (hibernate dependency has dependency conflict. To enable example uncomment hibernate dependency)
- `in_memory` with in memory simple reader/writers capabilities and integration
- `jpa` with JPA reader/writers capabilities and integration (hibernate dependency has dependency conflict. To enable example uncomment hibernate jpa dependency)
- `mybatis` with Mybatis reader/writers capabilities and integration
- `mongo` with mongo db examples
- `concurrent` with concurrent and parallel features
- `partitioner` with partitioner functionality feature
- `scheduler` with scheduling features based on cron and quartz
- `retry` with two samples with stateless and stateful retry
- `jsr352` with jsr job description example

#  Spring batch tests
Tests are under `src/test/java`
- `mongo` test with embedded and external modes
- `java_config` test with spring batch java config and invocation of job
- `system_command` test with spring batch command tasklet to run command line command
- `param_passing` test of passing parameters inside one step and between steps
- `retry` test for spring-retry annotation based functionality

# Pom.xml
Libraries: spring-batch-core, spring-batch-infrastructure, spring-retry, spring-jdbc for db population, commons-dbcp2 for database connection pool, h2 file based database for ease of db usage, log4j logging (possibility to configure) via slf4j.
Integration with jpa, hibernate, mybatis, mongo, schedulers: cron and quartz

# Logging
Spring batch logging logic.
- Commons logging is used.
- Commons logging is configured to use Log4j under the hood.