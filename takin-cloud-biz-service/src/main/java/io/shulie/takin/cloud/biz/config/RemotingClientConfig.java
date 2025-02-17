package io.shulie.takin.cloud.biz.config;

import javax.annotation.PostConstruct;

import com.netflix.curator.RetryPolicy;
import com.netflix.curator.framework.CuratorFramework;
import com.netflix.curator.framework.CuratorFrameworkFactory;
import com.netflix.curator.retry.ExponentialBackoffRetry;
import com.pamirs.pradar.remoting.RemotingClient;
import com.pamirs.pradar.remoting.netty.NettyClientConfigurator;
import com.pamirs.pradar.remoting.netty.NettyRemotingClient;
import com.pamirs.pradar.remoting.protocol.DefaultProtocolFactorySelector;
import com.pamirs.pradar.remoting.protocol.ProtocolFactorySelector;
import io.shulie.surge.data.common.zk.ZkClient;
import io.shulie.surge.data.common.zk.impl.NetflixCuratorZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author moriarty
 */
@Configuration
public class RemotingClientConfig {

    private RemotingClient remotingClient;

    private ProtocolFactorySelector selector;

    private static ZkClient zkClient;

    @Value("${pradar.zk.servers}")
    public String zkServers;

    @Value("${surge.deploy.enableStart}")
    public boolean enableStartSurge;

    @Value("${pradar.zk.timeOut:15000}")
    public int sessionTimeOut;

    @PostConstruct
    public void init() {
        if (!enableStartSurge) {
            RetryPolicy policy = new ExponentialBackoffRetry(1000, 10);
            CuratorFramework curator = CuratorFrameworkFactory.builder().
                connectString(zkServers).sessionTimeoutMs(sessionTimeOut).retryPolicy(policy).build();
            zkClient = new NetflixCuratorZkClient(curator, zkServers);
            curator.start();
        }
        selector = new DefaultProtocolFactorySelector();
    }

    @Bean
    public RemotingClient getRemotingClient() {
        NettyClientConfigurator config = new NettyClientConfigurator();
        remotingClient = new NettyRemotingClient(selector, config);
        remotingClient.start();
        return remotingClient;
    }

    @Bean
    public ZkClient getZkClient() {
        return zkClient;
    }

    @Bean
    public ProtocolFactorySelector getSelector(){
        return selector;
    }

}
