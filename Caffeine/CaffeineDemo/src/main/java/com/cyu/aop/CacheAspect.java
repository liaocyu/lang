package com.cyu.aop;

import com.cyu.annotition.DoubleCache;
import com.cyu.constants.CacheConstant;
import com.cyu.enums.CacheType;
import com.cyu.utils.ExpressionUtils;
import com.github.benmanes.caffeine.cache.Cache;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@Aspect
@AllArgsConstructor
public class CacheAspect {

    private final Cache cache;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    // 定义切点
    @Pointcut("@annotation(com.cyu.annotition.DoubleCache)")
    public void cacheAspect() {
    }


    @Around("cacheAspect()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        //拼接解析springEl表达式的map
        String[] paramNames = signature.getParameterNames();
        Object[] args = point.getArgs();
        TreeMap<String, Object> treeMap = new TreeMap<>();
        for (int i = 0; i < paramNames.length; i++) {
            treeMap.put(paramNames[i],args[i]);
        }

        DoubleCache annotation = method.getAnnotation(DoubleCache.class);
        String elResult = ExpressionUtils.parse(annotation.key(), treeMap);
        String realKey = annotation.cacheName() + ":" + CacheConstant.COLON + ":" + elResult; // "order" + "test" + "7"

        //强制更新
        if (annotation.type()== CacheType.PUT){
            Object object = point.proceed(); // 这是执行的目标方法

            // 将其转换为json格式
            Gson gson = new Gson();
            String jsonString = gson.toJson(object);

            System.out.println(jsonString);
            stringRedisTemplate.opsForValue().set(realKey, jsonString,annotation.l2TimeOut(), TimeUnit.SECONDS);


            cache.put(realKey, object);
            return object;
        }
        //删除
        else if (annotation.type()== CacheType.DELETE){
            // later
            stringRedisTemplate.delete(realKey);

            cache.invalidate(realKey);
            return point.proceed();
        }

        //读写，查询Caffeine
        Object caffeineCache = cache.getIfPresent(realKey);
        if (Objects.nonNull(caffeineCache)) {
            log.info("get data from caffeine");
            return caffeineCache;
        }

        //查询Redis

        // later
        Object redisCache = stringRedisTemplate.opsForValue().get(realKey);

        if (Objects.nonNull(redisCache)) {
            log.info("get data from redis");
            cache.put(realKey, redisCache);
            return redisCache;
        }

        log.info("get data from database");
        Object object = point.proceed();
        if (Objects.nonNull(object)){
            //写入Redis

            // later
            Gson gson = new Gson();
            String jsonString = gson.toJson(object);
            stringRedisTemplate.opsForValue().set(realKey, jsonString,annotation.l2TimeOut(), TimeUnit.SECONDS);

            //写入Caffeine
            cache.put(realKey, object);        
        }
        return object;
    }
}