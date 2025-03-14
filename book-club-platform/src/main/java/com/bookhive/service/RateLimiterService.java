package com.bookhive.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.BucketConfiguration;
import io.github.bucket4j.distributed.proxy.ProxyManager;
import io.github.bucket4j.redis.lettuce.cas.LettuceBasedProxyManager;
import io.lettuce.core.api.StatefulRedisConnection;

@Service
public class RateLimiterService {

    private final ProxyManager<String> proxyManager;

    public RateLimiterService(StatefulRedisConnection<String, byte[]> redisConnection) {
        this.proxyManager = LettuceBasedProxyManager.builderFor(redisConnection).build();
    }

    public Bucket resolveBucket(String key, long limit, Duration duration) {
        Bandwidth bandwidth = Bandwidth.builder()
                .capacity(limit)
                .refillIntervally(limit, duration) // For interval-based refill strategy
                .build();

        return proxyManager.builder()
                .build(key, () -> BucketConfiguration.builder()
                        .addLimit(bandwidth)
                        .build());
    }

    public boolean tryConsume(Bucket bucket) {

        return bucket.tryConsume(1);
    }
}