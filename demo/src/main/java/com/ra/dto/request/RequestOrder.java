package com.ra.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RequestOrder {
    private Long userId;
    private String note;
    private String phone;
    private String address;
    private List<RequestOrderDetail> ordersDetail;
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date createAt;
}
