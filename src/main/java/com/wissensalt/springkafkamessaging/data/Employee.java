package com.wissensalt.springkafkamessaging.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = -5791632692532121382L;

    private Long id;
    private String name;
    private String address;
    private BigDecimal salary;

}
