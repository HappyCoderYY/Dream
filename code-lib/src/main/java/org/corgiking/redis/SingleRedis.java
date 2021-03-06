package org.corgiking.redis;

import redis.clients.jedis.Jedis;

public class SingleRedis {

	public void main() {
		Jedis jedis = new Jedis("localhost", 6379);

		jedis.auth("admin");

		// 添加数据
		jedis.set("name", "Corgi King");
		System.out.println(jedis.get("name"));
		// 拼接数据
		jedis.append("name", " is so handsome!");
		System.out.println(jedis.get("name"));
		// 删除数据
		jedis.del("name");
		System.out.println(jedis.get("name"));
		// 添加多个数据
		jedis.mset("name", "Corgi King", "age", "18");
		jedis.incr("age");// 进行加1操作
		System.out.println(jedis.get("name") + "-" + jedis.get("age"));
		
		jedis.disconnect();
		jedis.close();
	}
}
