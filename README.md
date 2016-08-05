# spring-batch-sandbox
A project that shows spring batch capabilities and integration with other frameworks (http://projects.spring.io/spring-batch/)

# Project parts
Maven project that consists of the following parts:
- Java main classes are under (`src/main/java/main`) with different demo samples
- Spring batch infrastructure components are under (`src/main/java/org.spring.batch.infrastructure`)
- Test extentions for executing tests with spring batch (src/test/java)

# Spring batch main features demo
Main features examples are under src/main/java folder. It is simply classes with main methods, that explain the feature and ready to be executed and provide log that shows the results.
- `concurrent` for concurrent features
- `exceptional` for exceptional cases with skips, retries, failed states
- `general` for simple demos with task executor, java config, jdbc xml config
- `hibernate` with Hibernate reader/writers capabilities and integration
- `in_memory` with in memory simple reader/writers capabilities and integration
- `jpa` with JPA reader/writers capabilities and integration
- `mybatis` with Mybatis reader/writers capabilities and integration

# Pom.xml
Libraries: spring-batch-core, spring-batch-infrastructure, spring retry, spring jdbc for db population, commons-dbcp2 for database connection pool, h2 file based database for ease of db usage, log4j logging (possibility to configure) via slf4j.
Integration with jpa, hibernate, mybatis.

# Logging
Spring batch logging logic.
- Log4j is used