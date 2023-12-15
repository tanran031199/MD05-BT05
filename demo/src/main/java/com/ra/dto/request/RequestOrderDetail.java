package com.ra.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RequestOrderDetail {
    private Long productId;
    private Integer quantity;
}
