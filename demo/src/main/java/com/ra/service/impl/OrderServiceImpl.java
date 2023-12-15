package com.ra.service.impl;

import com.ra.advice.CommonException;
import com.ra.advice.CustomException;
import com.ra.dto.request.RequestOrder;
import com.ra.dto.response.ResponseOrder;
import com.ra.entity.Order;
import com.ra.entity.User;
import com.ra.repository.OrderRepository;
import com.ra.repository.UserRepository;
import com.ra.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ResponseOrder> getAllOrder() {
        return orderRepository.findAll().
                stream().map(item -> ResponseOrder.builder().
                        id(item.getId()).
                        note(item.getNote()).
                        phone(item.getPhone()).
                        address(item.getAddress()).
                        status(item.getStatus()).
                        createAt(item.getCreateAt()).
                        userName(item.getUser().getUserName()).
                        build()).toList();
    }

    @Override
    public Order createOrder(RequestOrder order) {
        Optional<User> user = userRepository.findById(order.getUserId());

        if (user.isPresent()) {
            return orderRepository.save(Order.builder().
                    note(order.getNote()).
                    phone(order.getPhone()).
                    address(order.getAddress()).
                    status(true).
                    createAt(order.getCreateAt()).
                    user(user.get()).
                    build());
        }

        throw new CustomException("Không tìm thấy người dùng phù hợp", 400);
    }
}
