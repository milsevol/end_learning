package cn.eleven.rabbitmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: rabbitmq admin 配置
 * @date: 2020-01-12 16:45
 * @author: 十一
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("test01.com:5672");
        connectionFactory.setUsername("u_action");
        connectionFactory.setPassword("u_action");
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }


    /**
     * @param connectionFactory 这个实例来自于上一个
     * @see cn.eleven.rabbitmq.RabbitMQConfig#connectionFactory()
     * @return
     */
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }
}
