package rabbitmq;


import com.rabbitmq.client.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 对消息单独设置过期时间
 * @date: 2019-10-03 11:43
 * @author: 十一
 */
public class RabbitProducer2 {

    private static final String USER_NAME = "u_action";
    private static final String PASSWORD = "u_action";
    private static final String EXCHANGE_NAME = "normal_exchange_demo";
    private static final String ROUTING_KEY = "routing_key_demo";
    private static final String QUEUE_NAME = "ttl_queue_demo";
    private static final String IP_ADDRESS = "test01.com";
    /**
     * RabbitMQ 服务端默认端口号为 5672
     */
    private static final int PORT = 5672;

    public static void main(String[] args) throws Exception {

        publisher();

    }

    private static void publisher() throws Exception {
        // 获取连接
        Connection connection  = getRabbitConnection();
        // 在连接中创建信道
        Channel channel = connection.createChannel();
        // 参数二：创建一个交换器类型为direct，它会把消息路由到那些 BindingKey 和 RoutingKey 完全匹配的队列中。
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, true, false, null) ;
        // 声明队列
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        // 绑定队列、交换器、和路由键
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTING_KEY);


        String message = "测试消息过期时间，对消息单独设置，时间：" + (System.currentTimeMillis()/1000);
        // 这里可以构造很多参数
        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties.Builder()
                .contentType("text/plain")
                // 2 为持久化
                .deliveryMode(2)
                // 设置该消息的过期时间，单位：毫秒
                .expiration("4000")
                .build();
        // 发送一条持久化的消息
        // 这里的路由键设置为空，这条消息将不能路由到交换器中，会被投递到备份交换器中
        channel.basicPublish(EXCHANGE_NAME,ROUTING_KEY,basicProperties,message.getBytes());
        //关闭资源
        channel.close() ;
        connection.close();
    }

    private static Connection getRabbitConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        Connection conn = null;
        try {
            conn = factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
