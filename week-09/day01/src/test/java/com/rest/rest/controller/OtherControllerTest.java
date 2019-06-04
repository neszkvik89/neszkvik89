package com.rest.rest.controller;

import static org.junit.Assert.*;

import com.rest.rest.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(OtherController.class)
public class OtherControllerTest {
  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ArrayService arrayService;

  @MockBean
  private LogService logService;

  @MockBean
  NumberService numberService;

  @MockBean
  ErrorService errorService;

  @MockBean
  AppendService appendService;

  @Test
  public void greeter_missingAllInput () throws Exception {
      mockMvc.perform(get("/greeter"))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$.error", is("Please provide a name and a title!")));
    }
  }
