package org.fix4j.test.integration;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;

/**
 * User: ben
 * Date: 20/08/2014
 * Time: 5:42 PM
 */
public interface FixEngineSessionFactory {
    FixEngineSession createSession(final FixSessionId sessionId, final FixConnectionMode fixConnectionMode, final Consumer<FixMessage> toClient);
}
