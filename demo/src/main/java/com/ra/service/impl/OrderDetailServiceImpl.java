package com.ra.service.impl;

import com.ra.advice.CustomException;
import com.ra.dto.request.RequestOrderDetail;
import com.ra.dto.response.ResponseOrderDetail;
import com.ra.entity.Order;
import com.ra.entity.OrderDetail;
import com.ra.entity.Product;
import com.ra.repository.OrderDetailRepository;
import com.ra.repository.ProductRepository;
import com.ra.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ResponseOrderDetail> getOrderDetailByOrderId(Long orderId) {
        return orderDetailRepository.findAllByOrderId(orderId).
                stream().map(item -> ResponseOrderDetail.builder().
                        orderDetailId(item.getOrderDetailId()).
                        unitTotalPrice(item.getUnitTotalPrice()).
                        quantity(item.getQuantity()).
                        product(item.getProduct()).
                        build()).toList();
    }

    @Override
    public void createAllOrderDetail(Order order, List<RequestOrderDetail> ordersDetail) {

        List<OrderDetail> list = ordersDetail.stream().map(item -> {
            Optional<Product> product = productRepository.findById(item.getProductId());

            if (product.isPresent()) {
                return OrderDetail.builder().
                        product(product.get()).
                        quantity(item.getQuantity()).
                        unitTotalPrice(item.getQuantity() * product.get().getPrice()).
                        order(order).
                        build();
            }

            throw new CustomException("Sản phẩm nhập vào không phù hợp", 400);
        }).toList();

        orderDetailRepository.saveAll(list);
    }
}