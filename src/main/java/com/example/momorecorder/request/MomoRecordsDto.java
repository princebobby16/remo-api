package com.example.momorecorder.request;

import com.example.momorecorder.enums.TransactionTypes;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MomoRecordsDto implements Serializable {
    private TransactionTypes transactionType;
    private String phoneNumber;
    private Float amount;
    private Float commission;
}
