package se.snowcatsystems.traveldiary.user;

import org.junit.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import se.snowcatsystems.traveldiary.initilization.AbstractInitilizerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public class UserTest extends AbstractInitilizerTest {

    @Autowired
    private WebApplicationContext context;

    private String token = null;


    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();

        mockMvc.perform(post("/login/register")
                .content("{ \"username\": \"test\", \"password\": \"test\",\"email\":\"email@email.email\",\"firstName\":\"Test\",\"lastName\":\"Test\",\"active\":1,\"role\":[\"USER\", \"ADMIN\"] }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        MvcResult result = mockMvc.perform(post("/login")
                .content("{ \"username\": \"test\", \"password\": \"test\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        this.token = result.getResponse().getHeader("Authorization");
    }

    @Test
    @Order(3)
    public void testLogin() throws Exception {
        MvcResult result = mockMvc.perform(post("/login")
                .content("{ \"username\": \"test\", \"password\": \"test\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
        assertThat(result.getResponse().getHeader("Authorization")).isNotNull();
    }

    @Test
    @Order(2)
    public void shouldReturn409() throws Exception {
        mockMvc.perform(post("/login/register")
                .content("{ \"username\": \"test\", \"password\": \"test\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(409));
    }

    @Test
    @Order(1)
    @Ignore
    public void failLogin() throws Exception {
        mockMvc.perform(post("/login")
                .content("{ \"username\": \"tests\", \"password\": \"test\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(403));
    }


    @After
    public void clean() throws Exception {
        HttpHeaders httpHeaders = getHttpHeaders();

        mockMvc.perform(delete("/login/delete")
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