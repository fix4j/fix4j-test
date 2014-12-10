package org.fix4j.test.plumbing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 4:52 PM
 */
public class ShuntFromSupplierToConsumer<M> implements Runnable {
    private final static Logger LOGGER = LoggerFactory.getLogger(BlockingPipe.class);
    private final Consumer<M> consumer;
    private final Supplier<M> supplier;
    private final String id;

    public ShuntFromSupplierToConsumer(final String id, final Supplier<M> supplier, final Consumer<M> consumer) {
        this.id = id;
        this.consumer = consumer;
        this.supplier = supplier;
    }

    @Override
    public void run(){
        while(true){
            LOGGER.debug("[" + id + "] Waiting for next message from supplier");
            final M m = supplier.get(Long.MAX_VALUE);
            LOGGER.debug("[" + id + "] Shunting message:" + m + " from:" + supplier + " to " + consumer);
            consumer.accept(m);
        }
    }

    public void start() {
        //TODO propert thread management with executor
        new Thread(this).start();
    }

    public String getId() {
        return id;
    }
}
