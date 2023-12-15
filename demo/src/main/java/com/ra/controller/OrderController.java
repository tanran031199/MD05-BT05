package com.ra.controller;

import com.ra.dto.request.RequestOrder;
import com.ra.dto.response.ResponseOrder;
import com.ra.dto.response.ResponseOrderDetail;
import com.ra.entity.Order;
import com.ra.service.OrderDetailService;
import com.ra.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<ResponseOrder>> getAllOrder() {
        List<ResponseOrder> orders = orderService.getAllOrder();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<List<ResponseOrderDetail>> getOrderDetailByOrderId(@PathVariable("orderId") Long orderId) {
        List<ResponseOrderDetail> orderDetails = orderDetailService.getOrderDetailByOrderId(orderId);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody RequestOrder requestOrder) {
        Order order = orderService.createOrder(requestOrder);
        orderDetailService.createAllOrderDetail(order, requestOrder.getOrdersDetail());
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
