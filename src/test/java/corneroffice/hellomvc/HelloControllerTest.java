package corneroffice.hellomvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HelloControllerTest {

    private HelloController underTest;
    private Model mockModel;


    @BeforeEach
    void setUp() {
        underTest = new HelloController();
        mockModel = mock(Model.class);
    }

    @Test
    public void shouldSayHelloToEveryone_sayHelloEveryone() {
        underTest.sayHelloToEveryone(mockModel);
        verify(mockModel).addAttribute("user", new User("Everyone"));
    }
    @Test
    public void sayHelloToEveryoneReturnsCorrectViewName() {
        String viewName = underTest.sayHelloToEveryone(mockModel);
        assertThat(viewName).isEqualTo("HelloView");
    }
    @Test
    public void routingWroksFor_sayHelloToEveryOne() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
               .andExpect(status().isOk());

    }
}
