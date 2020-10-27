package com.my;

import com.my.auth.AuthDes;
import com.my.domain.AuthorQueryDo;
import com.my.service.AuthorService;
import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableHasorWeb
@RestController
@SpringBootApplication
@EnableHasor
@MapperScan({"com.my.mapper","com.my.mapper"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		//服务注册　
//		Consul consul;
//		consul = Consul.builder().build();
//		final AgentClient agentClient = consul.agentClient();
//		String service = "myboot";
//		String address = "localhost";
//		String tag = "dev";
//		int port = 8888;
//		final String serviceId = address + ":" + port;
//		ImmutableRegistration.Builder builder = ImmutableRegistration.builder();
//		builder.id(serviceId).name(service).address(address).port(port).addTags(tag);
//		agentClient.register(builder.build());
//
//		//jVM停止时摘除服务
//
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//		    @Override
//			public void run() {
//			    agentClient.deregister(serviceId);
//			}
//		});
	}

	@Autowired
	private AuthorService authorService;
	@Autowired
	private AuthDes authDes;

	@ResponseBody
	@RequestMapping("/")
	public String hello() {
		authorService.listAuthors(new AuthorQueryDo());

		return authDes.getFirstName() + "-" + authDes.getLastName();
	}
}
