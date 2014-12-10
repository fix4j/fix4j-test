package org.fix4j.test.acceptance

import org.fix4j.test.DefaultContextFactory
import org.fix4j.test.properties.PropertyKeysAndDefaultValues
import org.fix4j.test.session.ContextFactory
import org.fix4j.test.session.FixConnectionMode
import org.fix4j.test.session.FixSessionId
import org.fix4j.test.session.TestContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

/**
 * User: ben
 * Date: 8/12/14
 * Time: 4:05 PM
 */
class ContextFactoryTest extends Specification {
    def "test default properties"(){
        when:
        final ContextFactory testFactory = new DefaultContextFactory();

        then:
        final TestContext testContext = testFactory.createTestContext(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        assert testContext.applicationProperties.getAsString("DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS") == PropertyKeysAndDefaultValues.DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS.getDefaultValue();
    }

    def "test override default properties"(){
        when:
        final ContextFactory testFactory = new DefaultContextFactory(["DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS": "66666"]);

        then:
        TestContext testContext = testFactory.createTestContext(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        assert testContext.applicationProperties.getAsString("DEFAULT_FIX_MSG_WAIT_TIMEOUT_MS") == "66666";
    }
}
