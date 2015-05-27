package com.company;

import redis.clients.jedis.Jedis;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Jedis jedis = new Jedis("localhost");
        System.out.println("Successful ping "+jedis.ping());
        jedis.set("selvaram", "indix");
        System.out.println(jedis.get("selvaram"));
        jedis.lpush("selvaram2", "kpm");
        jedis.lpush("selvaram2", "dolphin");
        jedis.lpush("selvaram2", "tce");
        jedis.lpush("selvaram2", "tw");
        jedis.lpush("selvaram2", "indix");

        List<String> selvaram = jedis.lrange("selvaram2", 0, 5);

        for (int i = 0; i < selvaram.size(); i++) {
            System.out.println(selvaram.get(i));
        }

    }
}
