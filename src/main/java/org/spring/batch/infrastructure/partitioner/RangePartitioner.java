package org.spring.batch.infrastructure.partitioner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iurii.dziuban on 09.08.2016.
 */
public class RangePartitioner implements Partitioner {

    private static final Log LOGGER = LogFactory.getLog(RangePartitioner.class);

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {

        Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();

        int range = 3;
        int fromId = 1;
        int toId = range;

        for (int i = 1; i <= gridSize; i++) {
            ExecutionContext value = new ExecutionContext();

            LOGGER.info("\nStarting : Thread" + i);
            LOGGER.info("fromId : " + fromId);
            LOGGER.info("toId : " + toId);

            value.putInt("fromId", fromId);
            value.putInt("toId", toId);

            // give each thread a name, thread 1,2,3
            value.putString("name", "Thread" + i);

            result.put("partition" + i, value);
            fromId = toId + 1;
            toId += range;
        }

        return result;
    }

}
