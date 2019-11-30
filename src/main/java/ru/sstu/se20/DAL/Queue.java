package ru.sstu.se20.DAL;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * This class implements data access to two queues:
 * Pending, the queue where pending jobs (images) are sent to be taken by  workers
 * And Result, where resulting images are sent from workers
 */
public class Queue {


    private Jedis jedis;


    public Queue() {
        this.jedis = new Jedis();
    }

    /**
     * @param job - Json serialized with fields: jobId, contentImage, styleImage
     */
    public void putPending(String job) {
        jedis.lpush("pending", job);
    }

    /**
     * @return List<String> of pending jobs, ready to be taken by workers
     */
    public List<String> showPending() {
        return jedis.lrange("pending", 0, -1);
    }

    /**
     * @return int of how many pending jobs in queue
     */
    public Long lenPending() {
        return jedis.llen("pending");
    }


    /**
     * @return first result from queue, where result is serialized json with fields jobId, resultImage
     */
    public String popResult() {
        return jedis.lpop("result");
    }

    /**
     * @return List<String> of results, finished by workers
     */
    public List<String> showResult() {
        return jedis.lrange("result", 0, -1);
    }

    /**
     * @return int of how many pending jobs in queue
     */
    public Long lenResult() {
        return jedis.llen("result");
    }
}
