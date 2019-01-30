import com.my.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =Application.class )
public class HelloControllerTest {

	private MockMvc mockMvc;


	@Autowired StringRedisTemplate stringRedisTemplate;


	ValueOperations<String, String> stringRedis;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(new Application()).build();
	}
	@Test
	public void getHello() throws Exception {
		System.out.println(mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn());;
	}



	@PostConstruct
	public void init(){
		stringRedis=stringRedisTemplate.opsForValue();
	}


	@Test
	public void testString (){
		stringRedis.set("sen", "sen1");
		System.out.println(stringRedis.get("sen"));
	}
}
