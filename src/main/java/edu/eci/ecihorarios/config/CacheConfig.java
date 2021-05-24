/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ecihorarios.config;

import com.google.common.cache.CacheBuilder;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Configuration; 
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;

/**
 *
 * @autho David Coronado
 */  
@Configuration
@EnableCaching
public class CacheConfig implements CachingConfigurer {  
    
    public final static String CACHE_SUBJECT = "cacheSubject"; 
    public final static String CACHE_CURRICULUM = "cacheCurriculum";
  
    @Bean
    @Override
    public CacheManager cacheManager() {
        
        SimpleCacheManager cacheManager = new SimpleCacheManager();  
        
        GuavaCache cache1 = new GuavaCache(CACHE_SUBJECT, CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).build());
        GuavaCache cache2 = new GuavaCache(CACHE_CURRICULUM, CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).build());
   
        
        cacheManager.setCaches(Arrays.asList(cache1,cache2));
        
        return cacheManager;
    
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
       return null;
    }
    
    
    
}
