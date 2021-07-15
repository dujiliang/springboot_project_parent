package com.drool.demo;


import com.drool.demo.entity.Animal;
import com.drool.demo.entity.Cat;
import com.drool.demo.entity.Golfer;
import com.drool.demo.entity.People;
import com.drool.demo.utils.DroolsStringUtils;
import org.assertj.core.util.Lists;
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



	@Test
	public void contextLoads() {

	}

	@Test
	public void testGolfer () {
		List<String> memberList = Lists.newArrayList("Fred","Joe","Bob","Tom");
		List<Integer> positionList = Lists.newArrayList(1,2,3,4);
		ArrayList<String> colorList = Lists.newArrayList("red", "blue", "orange", "plaid");
		for (String name : memberList) {
			for (Integer pos : positionList) {
				for (String color : colorList) {
					Golfer golfer = new Golfer(name,color,pos);
					session.insert(golfer);
				}
			}
		}
		int i = session.fireAllRules();
		System.out.println(i);
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
		session.insert(animal);
//		session.insert(cat);
//		session.insert(cat);
		session.insert(people1);//插入
		session.fireAllRules();//执行规则
	}

}
