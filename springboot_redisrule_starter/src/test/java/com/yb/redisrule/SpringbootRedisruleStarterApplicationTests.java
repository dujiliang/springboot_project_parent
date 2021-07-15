package com.yb.redisrule;


import com.yb.redisrule.RuleDataExecutor.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootRedisruleStarterApplicationTests {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private Environment environment;


	@Test
	public void contextLoads() {
	}


	@Test
	public void redisTest () {
		Set<String> list = redisTemplate.opsForSet().members("ez_health_center_list");
		list.stream().forEach((a)-> System.out.println(a));
	}

	@Test
	public void mongoTest() {
		List<Rule> all = mongoTemplate.findAll(Rule.class);
		all.stream().forEach(a-> System.out.println(a.getName()));
	}

	@Test
	public void envTest() {
		String property = environment.getProperty("spring.data.mongodb.uri");
		System.out.println(property);
	}

}
