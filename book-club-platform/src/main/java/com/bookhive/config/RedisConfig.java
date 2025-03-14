package com.bookhive.config;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.RedisCodec;

@Configuration
@EnableCaching
public class RedisConfig {


    @Bean
    RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(10)) // Cache expiry time
                        .serializeValuesWith(RedisSerializationContext.SerializationPair
                                .fromSerializer(new GenericJackson2JsonRedisSerializer())))
                .build();
    }

    @Bean
    RedisClient redisClient(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisURI redisURI = RedisURI.create(lettuceConnectionFactory.getHostName(), lettuceConnectionFactory.getPort());
        return RedisClient.create(redisURI);
    }

    @Bean
    StatefulRedisConnection<String, byte[]> statefulRedisConnection(RedisClient redisClient) {
        RedisCodec<String, byte[]> codec = new RedisCodec<>() {
            @Override
            public String decodeKey(ByteBuffer buffer) {
                return StandardCharsets.UTF_8.decode(buffer).toString();
            }

            @Override
            public byte[] decodeValue(ByteBuffer buffer) {
                byte[] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);
                return bytes;
            }

            @Override
            public ByteBuffer encodeKey(String key) {
                return StandardCharsets.UTF_8.encode(key);
            }

            @Override
            public ByteBuffer encodeValue(byte[] value) {
                return ByteBuffer.wrap(value);
            }
        };

        return redisClient.connect(codec);
    }
}
