package com.company;

import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        Jedis jedis = new Jedis("localhost");
        System.out.println("Successful ping "+jedis.ping());
        long start = System.currentTimeMillis();

        jedis.set("selva", "indix");
        System.out.println("selva->"+jedis.get("selva"));

        System.out.println("Elapsed time in ms : "+(System.currentTimeMillis() - start));

        MySqlConnect.process();
        MySqlConnect.addData("selva", "indix");
        MySqlConnect.getMap("selva");
        MySqlConnect.closeCon();

        System.out.println("Time elapsed for mysql in ms :"+MySqlConnect.l);

    }
}
