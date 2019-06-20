package com.example.movie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.movie.model.UserProfile;
import com.example.movie.repository.IUserRepository;
import com.example.movie.service.UserAccountService;
import java.nio.charset.Charset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieApplicationTests {

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private IUserRepository iUserRepository;

  @MockBean
  private UserAccountService userAccountService;

  @Test
  public void userDetailsStoredInDatabase() {
    UserProfile myProfile = new UserProfile("test", "password");
    iUserRepository.save(myProfile);
    UserProfile foundProfile = iUserRepository.findByUserName("test");
    assert (myProfile.getPassword().equals(foundProfile.getPassword()));
  }

  @Test
  public void newUserStoredInDatabase() throws Exception {
    mockMvc.perform(post("/register")
        .param("userName", "dummy")
        .param("password", "mummy"))
        .andExpect(status().isOk());

    assert iUserRepository.findByUserName("dummy") != null;
  }

  @Test
  public void loginWithValidCredentials() throws Exception {
    iUserRepository.save(new UserProfile("admin", "password"));
    mockMvc.perform(post("/login")
        .param("userName", "admin")
        .param("password", "password"))
        .andExpect(status().is2xxSuccessful());
  }


}
