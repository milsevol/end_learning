package net.xdclass.order_service.service.impl;

import net.xdclass.order_service.domain.ProductOrder;
import net.xdclass.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.net.www.URLConnection;
import sun.net.www.http.HttpClient;

import java.util.Date;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductOrder save(int userId, int productId) {

        Object obj = restTemplate.getForObject("http://product-service/api/v1/product/find?id="+productId, Object.class);

        System.out.println(obj);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());

        return productOrder;
    }
}
