package com.yunbao.springeventdrive;


import com.yunbao.springeventdrive.springevent.NotifyPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootEventdriveApplicationTests {

	@Autowired
	private NotifyPublisher notifyPublisher;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testSpringEventDrive () {
		notifyPublisher.publishEvent("我发布消息",1);

	}

}
