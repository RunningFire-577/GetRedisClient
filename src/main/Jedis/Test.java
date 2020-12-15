import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test {

    private static JedisPool jedisPool=null;
    public  static Jedis getJedisClinet(){
        if (jedisPool==null){
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(10); //最大可用连接数
            config.setMaxIdle(5); //最大闲置连接数
            config.setMinIdle(5); //最小闲置连接数
            config.setBlockWhenExhausted(true); //连接耗尽是否等待
            config.setMaxWaitMillis(2000); //等待时间
            config.setTestOnBorrow(true); //取连接的时候进行一下测试 ping pong
            jedisPool=new JedisPool(config,"hadoop102", 6379 );
            return jedisPool.getResource();
        }
        else
            return  jedisPool.getResource();

    }

    public static void main(String[] args) {
        Jedis jdcl = getJedisClinet();
        System.out.println(jdcl.ping());


    }



}
