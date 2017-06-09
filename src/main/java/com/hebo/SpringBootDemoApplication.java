package com.hebo;

import com.hebo.elasticsearch.ClienteRepositoryImpl;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@EnableElasticsearchRepositories(basePackages = {"com.hebo.elasticsearch"})*/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
public class SpringBootDemoApplication implements CommandLineRunner{

	@Value("${server.port}")
	private String port;
	@Value("${server.context-path}")
	private String path;

	@Autowired
	private Environment env;

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	ClienteRepositoryImpl clienteRepository;

	@RequestMapping("/{id}")
	public Object index(@PathVariable("id") String id){
		return clienteRepository.findOne(id);
	}

	@Bean
	public Queue heboQueue(){
		return new Queue("hebo");
	}

	@Override
	public void run(String... strings) throws Exception {
		clienteRepository.init();
		/*for (int i=0;i<10000000;i++){
			rabbitTemplate.convertAndSend("hebo","你好"+i);
		}*/

	}
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(new SimpleMessageConverter());
		return template;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setConcurrentConsumers(10);
		factory.setAcknowledgeMode(AcknowledgeMode.NONE);
		return factory;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
