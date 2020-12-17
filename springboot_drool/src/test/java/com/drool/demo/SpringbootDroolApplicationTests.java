package com.drool.demo;


import com.drool.demo.entity.Animal;
import com.drool.demo.entity.Cat;
import com.drool.demo.entity.People;
import com.drool.demo.utils.DroolsStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootDroolApplicationTests {


	@Autowired
	private KieSession session;

	@Autowired
	private KieBase kieBase;

	@Test
	public void contextLoads() {

	}

	@Test
	public void test() {
		People people = new People();
		people.setName("达");
		people.setSex(1);
		people.setDrlType("people");


		People people1 = new People();
		people1.setName("芬奇");
		people1.setSex(2);
		people1.setDrlType("people");

		Cat cat = new Cat();
		cat.setSex(1);
		cat.setName("hello ketty");

		Animal animal = new Animal();
		List<People> peopleList = new ArrayList<>();
		peopleList.add(people);
		peopleList.add(people1);
		animal.setPeoples(peopleList);
		DroolsStringUtils droolsStringUtils = new DroolsStringUtils();
		//session.insert(droolsStringUtils);
//		session.insert(animal);
//		session.insert(cat);
		session.insert(people);
//		session.insert(people1);//插入
		session.fireAllRules();//执行规则
	}
}
