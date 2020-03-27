package se.snowcatsystems.traveldiary.user;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import se.snowcatsystems.traveldiary.database.MySqlContainer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest()
@TestPropertySource(locations="classpath:application-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class UserTest {

    @Autowired
    private WebApplicationContext context;

    private String token = null;
    private MockMvc mockUser;

    @Container
    public static MySQLContainer mySQLContainer = MySqlContainer.getInstance();

    @Before
    public void setup() throws Exception {
        mockUser = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();

        mockUser.perform(post("/login/register")
                .content("{ \"username\": \"test\", \"password\": \"test\",\"email\":\"email@email.email\",\"firstName\":\"Test\",\"lastName\":\"Test\",\"active\":1,\"role\":[\"USER\", \"ADMIN\"] }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        MvcResult result = mockUser.perform(post("/login")
                .content("{ \"username\": \"test\", \"password\": \"test\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        this.token = result.getResponse().getHeader("Authorization");
    }

    @Test
    @Order(3)
    public void testLogin() throws Exception {
        MvcResult result = mockUser.perform(post("/login")
                .content("{ \"username\": \"test\", \"password\": \"test\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
        assertThat(result.getResponse().getHeader("Authorization")).isNotNull();
    }

    @Test
    @Order(2)
    public void shouldReturn409() throws Exception {
        mockUser.perform(post("/login/register")
                .content("{ \"username\": \"test\", \"password\": \"test\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(409));
    }

    @Test
    @Order(1)
    @Ignore
    public void failLogin() throws Exception {
        mockUser.perform(post("/login")
                .content("{ \"username\": \"tests\", \"password\": \"test\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(403));
    }


    @After
    public void clean() throws Exception {
        HttpHeaders httpHeaders = getHttpHeaders();

        mockUser.perform(delete("/login/delete")
                .headers(httpHeaders)
                .content("{ \"username\": \"test\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Authorization", token);
        httpHeaders.add("Content-Type", "application/json");

        return httpHeaders;
    }
}