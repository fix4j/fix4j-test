package org.fix4j.test.plumbing;

/**
 * User: ben
 * Date: 1/12/14
 * Time: 5:59 AM
 */
public interface Processor<T> {
    T process(T entity);
}
