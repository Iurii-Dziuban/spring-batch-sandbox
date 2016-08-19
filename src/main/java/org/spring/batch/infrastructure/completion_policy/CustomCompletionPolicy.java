package org.spring.batch.infrastructure.completion_policy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.repeat.context.RepeatContextSupport;
import org.springframework.batch.repeat.policy.DefaultResultCompletionPolicy;
import org.springframework.batch.repeat.policy.SimpleCompletionPolicy;
import org.springframework.util.ClassUtils;

/**
 * Created by iurii.dziuban on 12.08.2016.
 */
public class CustomCompletionPolicy extends DefaultResultCompletionPolicy {

    private static final Log LOGGER = LogFactory.getLog(CustomCompletionPolicy.class);

    public static final int DEFAULT_CHUNK_SIZE = 5;

    int chunkSize = 0;

    public CustomCompletionPolicy() {
        this(DEFAULT_CHUNK_SIZE);
    }

    public CustomCompletionPolicy(int chunkSize) {
        super();
        this.chunkSize = chunkSize;
    }

    public void setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    /**
     * Reset the counter.
     *
     * @see org.springframework.batch.repeat.CompletionPolicy#start(RepeatContext)
     */
    @Override
    public RepeatContext start(RepeatContext context) {
        return new CustomCompletionPolicy.SimpleTerminationContext(context);
    }

    /**
     * Terminate if the chunk size has been reached, or the result is null.
     *
     * @see org.springframework.batch.repeat.CompletionPolicy#isComplete(RepeatContext,
     * RepeatStatus)
     * @throws RuntimeException (normally terminating the batch) if the result is
     * itself an exception.
     */
    @Override
    public boolean isComplete(RepeatContext context, RepeatStatus result) {
        return super.isComplete(context, result) || ((CustomCompletionPolicy.SimpleTerminationContext) context).isComplete();
    }

    /**
     * Terminate if the chunk size has been reached.
     *
     * @see org.springframework.batch.repeat.CompletionPolicy#isComplete(RepeatContext)
     */
    @Override
    public boolean isComplete(RepeatContext context) {
        return ((CustomCompletionPolicy.SimpleTerminationContext) context).isComplete();
    }

    /**
     * Increment the counter in the context.
     *
     * @see org.springframework.batch.repeat.CompletionPolicy#update(RepeatContext)
     */
    @Override
    public void update(RepeatContext context) {
        ((CustomCompletionPolicy.SimpleTerminationContext) context).update();
    }

    protected class SimpleTerminationContext extends RepeatContextSupport {

        public SimpleTerminationContext(RepeatContext context) {
            super(context);
        }

        public void update() {
            LOGGER.info("CustomCompletionPolicy update");
            increment();
        }

        public boolean isComplete() {
            LOGGER.info("CustomCompletionPolicy isComplete");
            return getStartedCount() >= chunkSize;
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ClassUtils.getShortName(SimpleCompletionPolicy.class)+": chunkSize="+chunkSize;
    }
}
