package org.jboss.arquillian.test;

import javax.annotation.Resource;

public class TestBean
{
   @Resource(name = "resourceInjectionTestName")
   private String name;

   public String getName()
   {
      return name;
   }
}
