package com.example.momorecorder.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsCount {
    private Date date;
    private Number value;
}
