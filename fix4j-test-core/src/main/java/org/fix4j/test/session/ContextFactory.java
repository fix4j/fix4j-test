package org.fix4j.test.session;

import org.fix4j.test.fixspec.FixSpecification;

/**
 * User: ben
 * Date: 2/12/14
 * Time: 5:35 AM
 */
public interface ContextFactory {
    TestContext createTestContext(FixSessionId fixSessionId, FixConnectionMode fixConnectionMode);
    FixSpecification getFixSpecification();
}
