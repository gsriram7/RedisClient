package com.company;

import redis.clients.jedis.Jedis;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Successful ping "+jedis.ping());
        long start = System.currentTimeMillis();
        for (long i = 0; i < 100000; i++) {
            Long j = i;
            jedis.set(j.toString(), j.toString());
        }
        System.out.println("Elapsed time in ms : "+(System.currentTimeMillis() - start));

        MySqlConnect.process();
        for (long i = 0; i < 100000; i++) {
            Long j = i;
            MySqlConnect.addData(j.toString(), j.toString());
        }
        System.out.println("Time elapsed for mysql in ms :"+MySqlConnect.l);
        MySqlConnect.closeCon();


    }
}
