package com.ra.service;

import com.ra.dto.request.RequestOrderDetail;
import com.ra.dto.response.ResponseOrderDetail;
import com.ra.entity.Order;

import java.util.List;

public interface OrderDetailService {
    List<ResponseOrderDetail> getOrderDetailByOrderId(Long orderId);

    void createAllOrderDetail(Order order, List<RequestOrderDetail> ordersDetail);
}
