package com.vp.redis;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.vp.util.JsonConverter;

@Service("redisMgr")
public class RedisMgrImpl implements RedisMgr {

	private static final Logger log = Logger.getLogger(RedisMgrImpl.class);
	private RedisTemplate<String, Object> redisTemplate;

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public boolean isKeyExist(String key) {
		if (redisTemplate.hasKey(key)) {
			return true;
		}
		return false;
	}

	@Override
	public <T> void putObject(String key, T t) {
		// log.info("Storing.. " +key +" in redis" );
		redisTemplate.opsForValue().set(key, t);
	}

	@Override
	public <T> boolean putObjectWithExpire(String key, T t, long lifeTime, TimeUnit timeUnit) {
		redisTemplate.opsForValue().set(key, t);
		return redisTemplate.expire(key, lifeTime, timeUnit);
	}

	@Override
	public Object getObject(String key) {
		if (isKeyExist(key)) {
			// log.info(key + " "+redisTemplate.opsForValue().get(key));
			return redisTemplate.opsForValue().get(key);
		}

		return null;
	}

	@Override
	public void putMapObject(String key, Map<String, Object> map) {
		log.info("Storing.. " + key + " in redis");
		redisTemplate.opsForHash().putAll(key, map);

	}

	@Override
	public Map<Object, Object> getMapObject(String key) {
		if (isKeyExist(key)) {
			return redisTemplate.opsForHash().entries(key);
		} else {
			return null;
		}
	}

	@Override
	public boolean isMapEntryExist(String hashKey, String entryKey) {
		boolean result = false;
		if (null != hashKey && null != entryKey) {
			result = redisTemplate.opsForHash().hasKey(hashKey, entryKey);
		}
		return result;
	}

	@Override
	public Object getMapEntry(String hashKey, String entryKey) {
		Object object = null;
		if (isKeyExist(hashKey)) {
			if (isMapEntryExist(hashKey, entryKey)) {
				object = redisTemplate.opsForHash().get(hashKey, entryKey);
			} else {
				log.info("entry " + entryKey + " not exist in " + hashKey);
			}
		} else {
			log.info("hash " + hashKey + " not exist");
		}
		return object;
	}

	@Override
	public <T> void putSetObject(String key, Set<T> jobs) {
		// log.info("Storing.. " +key +" in redis" );
		redisTemplate.opsForSet().add(key, jobs);

	}

	@Override
	public Set<Object> getSetMembers(String key) {
		return redisTemplate.opsForSet().members(key);
	}

	@Override
	public void putSetMember(String key, Object member) {
		log.info("Loading " + member + "  to   " + key);
		redisTemplate.opsForSet().add(key, member);
	}

	@Override
	public boolean setKeyExpire(String key, long lifeTime, TimeUnit timeUnit) {
		return redisTemplate.expire(key, lifeTime, timeUnit);
	}

	@Override
	public void putMapString(String key, String mapKey, Object obj) {
		// redisTemplate.opsForHash().put(key, (Object)mapKey, obj);
		log.info("key " + key + " mapKey " + mapKey + "  obj: " + obj);
		redisTemplate.opsForHash().put(key, (Object) mapKey, obj);
	}

	@Override
	public String getMapString(String hashKey, String entryKey) {
		String object = null;
		if (isKeyExist(hashKey)) {
			if (isMapEntryExist(hashKey, entryKey)) {
				log.info("redisTemplate.opsForHash().get(hashKey, entryKey): "
						+ JsonConverter.getInstance().toJson(redisTemplate.opsForHash().get(hashKey, entryKey)));
				object = (String) redisTemplate.opsForHash().get(hashKey, entryKey);
			} else {
				log.info("entry " + entryKey + " not exist in " + hashKey);
			}
		} else {
			log.info("hash " + hashKey + " not exist");
		}
		return object;
	}

	@Override
	public boolean deleteCacheObject(String key) {
		boolean success = false;

		if (isKeyExist(key)) {
			log.info("DELETE : " + key);
			redisTemplate.delete(key);
			success = true;
		}
		return success;
	}

	@Override
	public long getSetCardinality(String key) {
		long cardinality = 0;

		if (isKeyExist(key)) {
			cardinality = redisTemplate.opsForSet().size(key);
		}

		return cardinality;
	}

	@Override
	public void unionSets(String key1, String key2) {
		if (isKeyExist(key1) && isKeyExist(key2)) {
			log.info(" UNION of " + key1 + "    " + key2);
			redisTemplate.opsForSet().unionAndStore(key1, key2, key1);
		}
	}

	@Override
	public boolean isMemberExist(String key, String member) {
		boolean res = false;
		if (isKeyExist(key)) {
			res = redisTemplate.opsForSet().isMember(key, member);
		}
		return res;
	}

	@Override
	public Long deleteSetMember(String key, String member) {
		if (isMemberExist(key, member)) {
			log.info(" DELETE : " + member + "  FROM " + key);
			return redisTemplate.opsForSet().remove(key, member);
		}
		return null;
	}

	@Override
	public boolean zAdd(String key, Object value, Double score) {
		return redisTemplate.opsForZSet().add(key, value, score);
	}

	@Override
	public Double zScore(String key, Object value) {
		return redisTemplate.opsForZSet().score(key, value);
	}

}