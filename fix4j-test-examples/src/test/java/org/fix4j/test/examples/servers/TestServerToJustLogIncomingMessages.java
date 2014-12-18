package org.fix4j.test.examples.servers;

import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.session.BlockingSession;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.TestSessionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 13/08/2014
 * Time: 8:57 PM
 */
public class TestServerToJustLogIncomingMessages implements Runnable {
    private final static Logger LOGGER = LoggerFactory.getLogger(TestServerToJustLogIncomingMessages.class);
    private boolean stop = false;

    public static void main(String[] args) {
        new Thread(new TestServerToJustLogIncomingMessages()).start();
    }

    public void run() {
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());
        final BlockingSession server = helper.createBlockingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        while(!stop){
            LOGGER.info(server.getNextMessage().toPrettyString());
        }
        LOGGER.info("Shutting down...");
        server.shutdown();
    }

    public void shutdown() {
        this.stop = true;
    }
}
