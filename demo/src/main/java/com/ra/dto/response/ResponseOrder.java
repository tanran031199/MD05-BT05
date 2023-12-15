package com.ra.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ResponseOrder {
    private Long id;
    private String note;
    private String phone;
    private String address;
    private Boolean status;
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date createAt;
    private String userName;
}
