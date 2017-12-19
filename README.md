# spring-batch-sandbox
[![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badge/)    

[![Build Status](https://travis-ci.org/Iurii-Dziuban/spring-batch-sandbox.svg?branch=master)](https://travis-ci.org/Iurii-Dziuban/spring-batch-sandbox)
[![Coverage Status](https://coveralls.io/repos/github/Iurii-Dziuban/spring-batch-sandbox/badge.svg?branch=master)](https://coveralls.io/github/Iurii-Dziuban/spring-batch-sandbox?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/5a11b2260fb24f2a6c0d2ffe/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/5a11b2260fb24f2a6c0d2ffe)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Iurii-Dziuban/spring-batch-sandbox/issues)

A project that shows spring batch capabilities and integration with other frameworks (http://projects.spring.io/spring-batch/)

**Note:** Spring batch is configured to use latest version of spring, latest hibernate.
However, excluding older versions of spring, hibernate is done in pom.xml

# Table of contents:
 * [Static Analysis QA Checks](#checks)
 * [Project structure](#project-structure)
 * [Build project](#building-project)
 * [Project parts](#project-parts)
 * [Build configuration](#pomxml)
 * [Logging configuration](#logging)
 * [Features](#spring-batch-main-features-demo)
 * [Tests](#tests)
 * [Ideas to try](#ideas)
 
# Checks

`Jacoco`/`cobertura` code coverage, `pmd`, `checkstyle`, `enforcer`, `findbugs`

# Project structure
Maven project that consists of the following parts:
- Java main classes are under (`src/main/java`) with infrastructural elements 
- Each test file ends on `Test` and can be executed showing different features. 
Logging is provided on good level and configurable in log4j config via slf4j
Test extensions for executing tests with spring batch (`src/test/java`) and run during the build

# Building project
`mvn clean package`

# Project parts
- Infrastructure. Contains spring batch components that might be used in other modules. Also contains common sql scripts.
- General. Contains general examples with different configurations and with integration with other frameworks/libraries
- JPA integrations. Contains jpa and hibernate examples that conflict with general examples because of spring version higher than spring batch uses

# Pom.xml
Libraries:
- spring-batch-core
- spring-integration
- spring-retry
- spring-jdbc for db population
- commons-dbcp2 for database connection pool
- h2 file based database for ease of db usage
- log4j logging (possibility to configure) via slf4j

Integration with:
- jpa
- hibernate
- mybatis
- mongo
- schedulers: cron and quartz

# Logging
Spring batch logging logic.
- Slf4j is configured to use Log4j under the hood.

# Spring batch main features demo

Main components are under `src/main/java/org.spring.batch.infrastructure` folder.
- `completion_policy` for chunk completion
- `listeners` job and step listeners
- `model` contains model to be used in examples
- `partitioner` partitioner implementation
- `processors` step processors
- `readers` step readers
- `scheduler` scheduler components
- `validator` job validators
- `writers` job writers

# Tests
Main features examples are under `src/test/java` folder. Under `main` package
It is simply test classes with test methods, that explain the feature and ready to be executed and provide log that shows the results.
- `concurrent` for concurrent features
- `exceptional` for exceptional cases with skips, retries, failed states
- `general` for simple demos with task executor, java config, jdbc xml config
- `in_memory` with in memory simple reader/writers capabilities and integration
- `jsr352` with jsr job description example
- `mybatis` with Mybatis reader/writers capabilities and integration
- `partitioner` with partitioner functionality feature
- `retry` with two samples with stateless and stateful retry
- `scheduler` with scheduling features based on cron and quartz
- `hibernate` with Hibernate reader/writers capabilities and integration (hibernate dependency has dependency conflict. To enable example uncomment hibernate dependency)
- `jpa` with JPA reader/writers capabilities and integration (hibernate dependency has dependency conflict. To enable example uncomment hibernate jpa dependency)
  * example with Hibernate
  * example with EclipseLink (BasicDatasource is not supported, different Datasource implementation is used, HQL and JPQL difference)
  * example with OpenJPA (HQL, JPQL and difference of query for openjpa)

Tests under `src/test/java`
- `general` - simple test demo
- `mongo` test with embedded and external modes **NOTE** `mvn clean pre-integration-test -Dembedmongo.wait` to run mongodb locally
- `java_config` test with spring batch java config and invocation of job
- `system_command` test with spring batch command tasklet to run command line command
- `param_passing` test of passing parameters inside one step and between steps
- `retry` test for spring-retry annotation based functionality
- `spring_integration` test for integration of spring batch with spring integration framework. Poller, Transformer, Router, Email sending by Spring integration and job processing via spring batch.

# Ideas