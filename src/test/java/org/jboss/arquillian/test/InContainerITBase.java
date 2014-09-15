package org.jboss.arquillian.test;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

public abstract class InContainerITBase {

    @Resource(name = "resourceInjectionTestName")
    protected String resourceInjectionTestValue;

    @Test
    public void shouldBeAbleToInjectMembersIntoTestClass(final TestBean testBean)
    {
       Assert.assertEquals("Hello World from an evn-entry", this.resourceInjectionTestValue);
       Assert.assertNotNull(testBean);
       Assert.assertEquals("Hello World from an evn-entry", testBean.getName());
    }
}
