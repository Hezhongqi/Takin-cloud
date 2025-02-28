package io.shulie.takin.app.conf;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 无涯
 * @date 2021/6/7 3:17 下午
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * 采用丢弃队列中最老的任务
     *
     * @return -
     */
    @Bean(name = "stopThreadPool")
    public ThreadPoolExecutor stopTaskExecutor() {
        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("stop-thread-%d").build();
        return new ThreadPoolExecutor(10, 20, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), nameThreadFactory,
            new ThreadPoolExecutor.DiscardOldestPolicy());
    }
}
