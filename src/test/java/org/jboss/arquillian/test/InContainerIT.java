package org.jboss.arquillian.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class InContainerIT extends InContainerITBase {

    @Deployment
    public static WebArchive createTestArchive()
    {
        final WebArchive war = ShrinkWrap
            .create(WebArchive.class, "test2.war")
            .addClasses(TestBean.class)
            .addAsLibraries(
                Maven.configureResolver().workOffline().loadPomFromFile("pom.xml")
                    .resolve("org.jboss.weld.servlet:weld-servlet").withTransitivity().asFile())
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml").setWebXML("in-container-web.xml");

        return war;
    }
}
