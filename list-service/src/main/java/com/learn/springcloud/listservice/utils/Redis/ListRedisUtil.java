package com.learn.springcloud.listservice.utils.Redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;
import java.util.*;


/**
 * RedisUtil
 * @author xiangxing liu
 */

@Service
public class ListRedisUtil<T> {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 缓存list数据
     *
     * @param key      缓存的键值
     * @param dataList 缓存的键值对应的list
     * @param <T>
     * @return 返回list值
     */
    @SuppressWarnings("unchecked")
    public <T> ListOperations<String, T> set(String key, List<T> dataList) {
        ListOperations<String, T> listOperations = redisTemplate.opsForList();
        try{
            for(T obj : dataList){
                listOperations.rightPush(key, obj);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return listOperations;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> get(String key, long start, long end){
        List<T> pageList = new ArrayList<>();
        try{
            ListOperations<String, T> listOperations = redisTemplate.opsForList();
            pageList = listOperations.range(key, start, end);
        } catch (Exception e){
            e.printStackTrace();
        }

        return pageList;
    }

    /**
     * 获取缓存的list对象
     *
     * @param key key缓存的键值
     * @param <T> 缓存键值对应的数据
     * @return dataList 列表
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> get(String key) {
        List<T> dataList = new ArrayList<>();
        try{
            ListOperations listOperations = redisTemplate.opsForList();
            Long size = listOperations.size(key);
            if(size != null) {
                for (int i = 0; i < size; i++) {
                    dataList.add((T) listOperations.leftPop(key));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return dataList;
    }

    @SuppressWarnings("unchecked")
    public Long size(String key) {
        return redisTemplate.opsForList().size(key);
    }
}