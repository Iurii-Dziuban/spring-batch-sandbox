package mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by iurii.dziuban on 09.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:mongo/application-context.xml",
        "classpath:mongo/test-context.xml",
        "classpath:mongo/application-context.xml"})
/** Example from https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo  */
public class SpringBatchEmbeddedMongoTest {

    private static MongodStarter starter = MongodStarter.getDefaultInstance();
    private static MongodExecutable mongodExecutable = null;
    private static MongodProcess mongod = null;

    private static final int DEFAULT_MONGO_DB_PORT = 27017;

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @BeforeClass
    public static void beforeClass() throws Exception {
        int port = DEFAULT_MONGO_DB_PORT;
        /* Mongo 3.2.1 Version.Main.PRODUCTION  Latest version 3.3.0 Version.Main.DEVELOPMENT*/
        IMongodConfig mongodConfig = new MongodConfigBuilder()
                .version(Version.Main.DEVELOPMENT)
                .net(new Net(port, Network.localhostIsIPv6()))
                .build();

        mongodExecutable = starter.prepare(mongodConfig);
        mongod = mongodExecutable.start();
    }

    @Test
    public void testClient() throws Exception {
        MongoClient mongo = new MongoClient("localhost", DEFAULT_MONGO_DB_PORT);
        DB db = mongo.getDB("mongoDB");
        DBCollection col = db.createCollection("testCol", new BasicDBObject());
        col.save(new BasicDBObject("testDoc", new Date()));
    }

    @Test
    public void launchJob() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
    }

    @Test
    public void launchStep() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1");
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
    }

    @AfterClass
    public static void afterClass() {
        if (mongod != null){
            mongod.stop();
        }
        if (mongodExecutable != null){
            mongodExecutable.stop();
        }
    }
}
