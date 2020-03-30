package se.snowcatsystems.traveldiary.country;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import se.snowcatsystems.traveldiary.initilization.AbstractTestContainerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountryControllerTest extends AbstractTestContainerTest {

    @Autowired
    private WebApplicationContext context;

    private String token = null;

    @BeforeAll
    void setup() throws Exception{

        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();

        this.mockMvc.perform(post("/login/register")
                .content("{ \"username\":\"test\",\"password\":\"test\",\"email\":\"email@email.email\",\"firstName\":\"Test\",\"lastName\":\"Test\",\"active\":1,\"role\":[\"USER\", \"ADMIN\"] }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        MvcResult result = this.mockMvc.perform(post("/login")
                .content("{ \"username\": \"test\", \"password\": \"test\" }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        this.token = result.getResponse().getHeader("Authorization");
    }

    @Test
    void testGetCountries() throws Exception{
        HttpHeaders httpHeaders = getHttpHeaders();
        MvcResult result = mockMvc.perform(post("/country")
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()).andReturn();

        assertEquals(200, result.getResponse().getStatus(), "We got 200 OK back");
    }

    @AfterAll
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
