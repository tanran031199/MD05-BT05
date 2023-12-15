package com.ra.service;

import com.ra.dto.request.RequestOrder;
import com.ra.dto.response.ResponseOrder;
import com.ra.entity.Order;

import java.util.List;

public interface OrderService {
    List<ResponseOrder> getAllOrder();
    public Order createOrder(RequestOrder order);
}
