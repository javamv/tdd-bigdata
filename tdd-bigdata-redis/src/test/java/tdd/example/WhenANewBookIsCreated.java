package tdd.example;

import static com.lordofthejars.nosqlunit.redis.RemoteRedisConfigurationBuilder.newRemoteRedisConfiguration;

import org.junit.Rule;
import org.junit.Test;

import redis.clients.jedis.Jedis;

import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.redis.RedisRule;

public class WhenANewBookIsCreated {

/*	static {
		System.setProperty("REDIS_HOME", "/opt/redis-2.4.16");
	}

	@ClassRule
	public static ManagedRedis managedRedis = newManagedRedisRule().build();*/

//	@Rule
//	public RedisRule redisRule = new RedisRule(newRemoteRedisConfiguration().host("50.112.114.200").build());
//
//	@Test
//	@UsingDataSet(locations= "book.json", loadStrategy=LoadStrategyEnum.CLEAN_INSERT)
//	@ShouldMatchDataSet(location= "expected_book.json")
//	public void book_should_be_inserted_into_repository() {
//
//		BookManager bookManager = new BookManager(new Jedis("50.112.114.200"));
//		bookManager.insertBook(new Book("The Lord Of The Rings", 1299));
//
//	}
	
}
