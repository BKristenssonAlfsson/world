package se.snowcatsystems.traveldiary.initilization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(initializers = {AbstractInitilizerTest.Initilizer.class})
public abstract class AbstractInitilizerTest {

    @Autowired
    public MockMvc mockMvc;

    private static MySQLContainer sqlContainer;

    static {
        sqlContainer = new MySQLContainer("mysql:latest")
                .withDatabaseName("world")
                .withUsername("test")
                .withPassword("test");
        sqlContainer.start();
    }

    public static class Initilizer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + sqlContainer.getJdbcUrl(),
                    "spring.datasource.username=" + sqlContainer.getUsername(),
                    "spring.datasource.password=" + sqlContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}
