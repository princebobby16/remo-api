package com.example.momorecorder.response;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private Date date;
    private Float value;
}
