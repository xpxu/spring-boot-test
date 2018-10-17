package com.example.xpxu.demo.lab.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xupeng.
 */
@Configuration
public class HttpClientConfig {

    @Value("${httpclient.socket_timeout}")
    private String socketTimeout;

    @Value("${httpclient.connect_timeout}")
    private String connectTimeout;

    @Value("${httpclient.connect_pool_size}")
    private String poolMaxTotal;

    @Value("${httpclient.connect_pool_max_per_route}")
    private String poolMaxPerRoute;

    /**
     * httpclient的参数配置
     */
    @Bean
    public HttpClient httpClient() {
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
        // 超时时间
        requestConfigBuilder.setSocketTimeout(Integer.parseInt(socketTimeout));
        // 连接时间
        requestConfigBuilder.setConnectTimeout(Integer.parseInt(connectTimeout));
        RequestConfig defaultRequestConfig = requestConfigBuilder.build();
        // 连接池配置
        final PoolingHttpClientConnectionManager pollingConnectionManager = new PoolingHttpClientConnectionManager();
        // 总连接数
        pollingConnectionManager.setMaxTotal(Integer.parseInt(poolMaxTotal));
        // 同路由的并发数
        pollingConnectionManager.setDefaultMaxPerRoute(Integer.parseInt(poolMaxPerRoute));

        // httpclient 配置
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(pollingConnectionManager);
        httpClientBuilder.setDefaultRequestConfig(defaultRequestConfig);
        return httpClientBuilder.build();
    }
}
