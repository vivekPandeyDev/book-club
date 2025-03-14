package com.bookhive.aop;


import java.time.Duration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.bookhive.handler.RateLimitExceededException;
import com.bookhive.service.RateLimiterService;

import io.github.bucket4j.Bucket;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class RateLimiterAspect {

    private final RateLimiterService rateLimiterService;
    private final HttpServletRequest request;

    @Around("@annotation(rateLimited)")
    public Object handleRateLimiting(ProceedingJoinPoint joinPoint, RateLimited rateLimited) throws Throwable {
        String ip = getClientIp();

        // Resolve the bucket from Redis
        Bucket bucket = rateLimiterService.resolveBucket(ip, rateLimited.limit(),Duration.ofMinutes(rateLimited.duration()));

        if (rateLimiterService.tryConsume(bucket)) {
            return joinPoint.proceed(); // Allow the request
        } else {
            throw new RateLimitExceededException("Too many requests. Please try again later.");
        }
    }

    private String getClientIp() {
        String forwardedFor = request.getHeader("X-Forwarded-For");
        if (forwardedFor != null) {
            return forwardedFor.split(",")[0];
        }
        return request.getRemoteAddr();
    }
}
