package com.vp.redis;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface RedisMgr {
	
	public <T> void putObject(String key,T t);
	public Object getObject(String key);
	public void putMapObject(String key,Map<String,Object> map);
	public Map<Object,Object> getMapObject(String key);
	public Object getMapEntry(String hashKey,String entryKey);
	public <T> void putSetObject(String key,Set<T>jobs);
	public Set<Object> getSetMembers(String key);
	public boolean isKeyExist(String key);
	public boolean isMapEntryExist(String hashKey, String entryKey);	
	public boolean deleteCacheObject(String key);
	public <T> boolean putObjectWithExpire(String key, T t, long lifeTime, TimeUnit timeUnit);
	public void putMapString(String key,String mapKey,Object obj);	
	public String getMapString(String hashKey, String entryKey);
	public void  putSetMember(String key, Object member);
	public long getSetCardinality(String key);
	public void unionSets(String key1, String key2);
	public boolean isMemberExist(String key, String member);
	public boolean setKeyExpire(String key, long lifeTime, TimeUnit timeUnit);
	public Long deleteSetMember(String key, String member);
	public boolean zAdd(String key, Object value, Double score);
	public Double zScore(String key, Object value);
}
