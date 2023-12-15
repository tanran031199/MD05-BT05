package com.ra.dto.response;

import com.ra.entity.Product;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseOrderDetail {
    private Long orderDetailId;
    private Double unitTotalPrice;
    private Integer quantity;
    private Product product;
}
