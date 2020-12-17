package com.yunbao.redisgeo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.yunbao.redisgeo.entity.Pharmacy;
import com.yunbao.redisgeo.mapper.PharmacyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisgeoApplicationTests {


	@Autowired
	private StringRedisTemplate redisTemplate;


	@Test
	public void contextLoads() {

	}


	@Test
	public void testZset() {
		redisTemplate.opsForZSet().add("geokey-1","aa",1);
	}

	@Autowired
	private PharmacyMapper pharmacyMapper;

	@Test
	public void test () {

		String geokey = "pharmacy_geo";
		List<Pharmacy> pharmacyList = pharmacyMapper.selectList(new QueryWrapper<>());
		ObjectMapper mapper=new ObjectMapper();
		for (Pharmacy pharmacy : pharmacyList) {

			try {
				if (pharmacy.getLongitude() != null && pharmacy.getLatitude() != null) {
					String pharmacyStr =mapper.writeValueAsString(pharmacy);
					double lng = pharmacy.getLongitude().doubleValue();
					double lat = pharmacy.getLatitude().doubleValue();
					redisTemplate.opsForGeo().add(geokey,new Point(lng,lat),pharmacyStr);
				}

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		System.out.println(pharmacyList.size());
	}

	@Test
	public void testDelete() throws Exception {
		Pharmacy pharmacy = pharmacyMapper.selectById(13467);
		ObjectMapper mapper=new ObjectMapper();
		String pharmacyStr =mapper.writeValueAsString(pharmacy);
		Long pharmacy_geo = redisTemplate.opsForZSet().remove("pharmacy_geo", pharmacyStr);
		System.out.println(pharmacy_geo);
	}

	@Test
	public void test11() throws Exception{
		Pharmacy pharmacy = pharmacyMapper.selectById(13467);
		ObjectMapper mapper=new ObjectMapper();
		String pharmacyStr =mapper.writeValueAsString(pharmacy);
		Long pharmacy_geo = redisTemplate.opsForZSet().rank("pharmacy_geo", pharmacyStr);
		System.out.println(pharmacy_geo);
	}


	@Test
	public void testGeo () {
		String geokey = "pharmacy_geo";
//		List<Point> position = redisTemplate.opsForGeo().position(geokey,"{\"id\":15102,\"pharmacyName\":\"好药师大药房(康泰店)\",\"longitude\":113.854911,\"latitude\":30.261561,\"commentScore\":null,\"introduceDesc\":null,\"medicineRecomd1\":null,\"medicineRecomd2\":null,\"medicineRecomd3\":null,\"medicineRecomd4\":null,\"advert1\":null,\"advert2\":null,\"advert3\":null,\"brandFlag\":1,\"healthcareFlag\":1,\"allDayaroundFlag\":null,\"onsaleFlag\":null,\"bookFlag\":1,\"deliveryFlag\":1,\"cooperativeFlag\":1,\"rebate\":null,\"mainPharmacy\":null,\"picturePath\":\"/upload/pharmacyImg/haoyaoshi/pic/haoyaoshi_pic.jpg\",\"uniqueCode\":null,\"doudou\":null,\"createTime\":1585743803112,\"createBy\":\"excel\",\"updateTime\":null,\"updateBy\":null,\"heat\":null,\"carriage\":0,\"startTime\":null,\"endTime\":null,\"address\":\"武汉市汉南区汉南农场康泰路6号\",\"phone\":\"13871319156\",\"logoPath\":\"/upload/pharmacyImg/haoyaoshi/haoyaoshi_logo.jpg\",\"licensePic\":\"/upload/pharmacyImg/haoyaoshi/LICENSE_PIC/15102_license.jpg\",\"lmedicinePic\":\"/upload/pharmacyImg/haoyaoshi/LMEDICINE_PIC/15102_permit.jpg\",\"gspPic\":\"/upload/pharmacyImg/haoyaoshi/GSP_PIC/15102_gsp.jpg\",\"spltPic\":\"/upload/pharmacyImg/haoyaoshi/SPLT_PIC/15102_food.jpg\",\"ylqxPic\":\"/upload/pharmacyImg/haoyaoshi/YLQX_PIC/15102_ylqx.jpg\"}");
//		System.out.println(position.size());
		Set<String> strings = redisTemplate.opsForZSet().rangeByScore(geokey, 4040115476764774.0, 4040115479163761.0);
		System.out.println(strings);
//		Cursor<ZSetOperations.TypedTuple<String>> zset = redisTemplate.opsForZSet().scan(geokey, ScanOptions.NONE);
//		while (zset.hasNext()) {
//			ZSetOperations.TypedTuple<String> next = zset.next();
//			System.out.println(next.getValue() + "-->" + next.getScore());
//		}


		//Set<String> range = redisTemplate.opsForZSet().
		//System.out.println(range);
	}


	@Test
	public void zsetTest() {
		redisTemplate.opsForZSet().add("zset:test","aaa",1);
		redisTemplate.opsForZSet().add("zset:test","bbb",2);
		redisTemplate.opsForZSet().add("zset:test","ccc",3);
		redisTemplate.opsForZSet().add("zset:test","ddd",4);
	}

	@Test
	public void test1 () {
		LocalDate birth = LocalDate.parse("2020-08-16");
		LocalDate localDate = birth.plusDays(99);
		System.out.println("百天日期" + localDate.toString());
	}

}
