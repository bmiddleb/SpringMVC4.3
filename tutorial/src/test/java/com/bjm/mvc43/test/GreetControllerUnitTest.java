package com.bjm.mvc43.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({})
@WebAppConfiguration
@ContextConfiguration(locations = 
	{"classpath:test-app-context.xml",
	"classpath:test-bean-context.xml"})
public class GreetControllerUnitTest extends AbstractJUnit4SpringContextTests {
	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		System.out.println("Initiating set up...");
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		System.out.println("...completed");
	}

	/*
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders
				.standaloneSetup(new GreetController())
				.build();
	}
	*/

	@Test
	public void givenWac_whenServletContext_thenItProvidesGreetController() {
	    ServletContext servletContext = wac.getServletContext();
	     
	    Assert.assertNotNull(servletContext);
	    Assert.assertTrue(servletContext instanceof MockServletContext);
	    Assert.assertNotNull(wac.getBean("greetController"));
	}

	@Test
	public void givenHomePageURI_whenMockMVC_thenReturnsIndexJSPViewName() throws Exception {
		this.mockMvc
			.perform(get("/homePage"))
			.andExpect(view()
			.name("index"));
	}

	@Test
	public void givenGreetURI_whenMockMVC_thenVerifyResponse() throws Exception {
		this.mockMvc
			.perform(get("/greet"))
			.andExpect(status()
			.isOk())
			.andExpect(content()
			.contentType(CONTENT_TYPE))
			.andExpect(jsonPath("$.message")
			.value("Hello World!!!"));
	}

	@Test
	public void givenGreetURIWithPathVariable_whenMockMVC_thenVerifyResponse() throws Exception {
		this.mockMvc
			.perform(get("/greetWithPathVariable/John"))
			.andExpect(status()
			.isOk())
			.andExpect(content()
			.contentType(CONTENT_TYPE))
			.andExpect(jsonPath("$.message")
			.value("Hello World John!!!"));
	}

	@Test
	public void givenGreetURIWithPathVariable_2_whenMockMVC_thenVerifyResponse() throws Exception {
		this.mockMvc
			.perform(get("/greetWithPathVariable/{name}", "Doe"))
			.andExpect(status()
			.isOk())
			.andExpect(content()
			.contentType(CONTENT_TYPE))
			.andExpect(jsonPath("$.message")
			.value("Hello World Doe!!!"));
	}

	@Test
	public void givenGreetURIWithQueryParameter_whenMockMVC_thenVerifyResponse() throws Exception {
		this.mockMvc
			.perform(get("/greetWithQueryVariable")
			.param("name", "John Doe"))
			.andDo(print())
			.andExpect(status()
			.isOk())
			.andExpect(content()
			.contentType(CONTENT_TYPE))
			.andExpect(jsonPath("$.message")
			.value("Hello World John Doe!!!"));
	}

	@Test
	public void givenGreetURIWithPost_whenMockMVC_thenVerifyResponse() throws Exception {
		this.mockMvc
			.perform(MockMvcRequestBuilders
			.post("/greetWithPost"))
			.andDo(print())
			.andExpect(status()
			.isOk())
			.andExpect(content()
			.contentType(CONTENT_TYPE))
			.andExpect(jsonPath("$.message")
			.value("Hello World!!!"));
	}

	@Test
	public void givenGreetURIWithPostAndFormData_whenMockMVC_thenVerifyResponse() throws Exception {
		this.mockMvc
			.perform(MockMvcRequestBuilders
			.post("/greetWithPostAndFormData")
			.param("id", "1")
			.param("name", "John Doe"))
			.andDo(print())
			.andExpect(status()
			.isOk())
			.andExpect(content()
			.contentType(CONTENT_TYPE))
			.andExpect(jsonPath("$.message")
			.value("Hello World John Doe!!!"))
			.andExpect(jsonPath("$.id")
			.value(1));
	}
}
