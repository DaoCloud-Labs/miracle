package io.daocloud.miracle;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import io.daocloud.miracle.controller.MainController;
import io.daocloud.miracle.controller.PictureController;
import io.daocloud.miracle.controller.ServiceController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiracleApplicationTests {

  @InjectMocks
  private PictureController pictureController;

  @InjectMocks
  private MainController MainController;

  @InjectMocks
  private ServiceController serviceController;

  private MockMvc mockMvc;

  public MiracleApplicationTests() {
  }

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(MainController.class).build();
  }

  @Test
  public void getPicture() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/index")).andExpect(
        MockMvcResultMatchers.status().isOk()).andDo(print()).andReturn();
  }

  @Test
  public void testHello() {
    Assert.assertEquals("hello dcs", pictureController.hello());
  }

  @Test
  public void testYahaha(){
    Assert.assertEquals("success",MainController.yahaha());
  }

  @Test
  public void testAdd(){
    Assert.assertEquals("add",serviceController.add());
  }

}
