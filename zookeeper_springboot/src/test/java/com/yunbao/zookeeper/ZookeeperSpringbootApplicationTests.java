package com.yunbao.zookeeper;

import com.yunbao.zookeeper.demo.ZKCurator;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.apache.curator.framework.recipes.cache.TreeCacheEvent.Type.NODE_ADDED;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZookeeperSpringbootApplicationTests {

	@Autowired
	private ZKCurator zKCurator;

//	@Autowired
//	private CuratorFramework client;

	@Test
	public void contextLoads() {
	}


	@Test
	public void testCreateNode () {
		zKCurator.createPersistentNode("/curator/test_2","测试数据");
	}

	@Test
	public void testCreateNode1 () throws Exception{
//		String s = client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/DUJILIANG/PROJECT_1", "ZHIYAO".getBytes());
//		System.out.println(s);
//		client.close();
	}


	/**
	 * 对当前节点的监听
	 * @throws Exception
	 */
	@Test
	public void watcherTest() throws  Exception{

		//zKCurator.createPersistentNode("/curator/test_nodeCache","");
		NodeCache nodeCache = zKCurator.registerNodeCacheListener("/curator/test_nodeCache");
		Thread.sleep(200000);
		//zKCurator.setData("/curator/test_nodeCache","nodeCache_value_1");
	}


	/***
	 *
	 * @throws Exception
	 */
	@Test
	public void childrenWatcherTest () throws Exception {

		PathChildrenCache pathChildrenCache = zKCurator.registerPathChildListener("/curator", (client, event) -> {

			ChildData childData = event.getData();
			if(childData != null){
				System.out.println("Path: " + childData.getPath());
				System.out.println("Stat:" + childData.getStat());
				System.out.println("Data: "+ new String(childData.getData()));
			}

			switch (event.getType()){
				case CHILD_ADDED:
					System.out.println("正在新增子节点：" + childData.getPath());
					//获取子节点
					List<String> list = zKCurator.getChildren("/curator");
					list.forEach(System.out::println);

					break;
				case CHILD_UPDATED:
					System.out.println("正在更新子节点："  + childData.getPath());
					break;
				case CHILD_REMOVED:
					System.out.println("子节点被删除");
					break;
				case CONNECTION_LOST:
					System.out.println("连接丢失");
					break;
				case CONNECTION_SUSPENDED:
					System.out.println("连接被挂起");
					break;
				case CONNECTION_RECONNECTED:
					System.out.println("恢复连接");
					break;
			}
		});
		Thread.sleep(200000);

	}


	/**
	 * 目录监听器
	 * @throws Exception
	 */
	@Test
	public void treeCacheListener () throws Exception{

		TreeCache treeCache = zKCurator.registerTreeCacheListener("/curator", 2, (client, event) -> {
			ChildData childData = event.getData();

			if(childData != null){
				System.out.println("Path: " + childData.getPath());
				System.out.println("Stat:" + childData.getStat());
				System.out.println("Data: "+ new String(childData.getData()));
			}

			switch (event.getType()){
				case NODE_ADDED:
					System.out.println("正在新增子节点：" + childData.getPath());
					//获取子节点
					List<String> list = zKCurator.getChildren("/curator");
					list.forEach(System.out::println);

					break;
				case NODE_UPDATED:
					System.out.println("正在更新节点："  + childData.getPath());
					break;
				case NODE_REMOVED:
					System.out.println("节点被删除：" + childData.getPath());
					break;
				case CONNECTION_LOST:
					System.out.println("连接丢失");
					break;
				case CONNECTION_SUSPENDED:
					System.out.println("连接被挂起");
					break;
				case CONNECTION_RECONNECTED:
					System.out.println("恢复连接");
					break;
			}

		});

		Thread.sleep(Integer.MAX_VALUE);
	}
}
