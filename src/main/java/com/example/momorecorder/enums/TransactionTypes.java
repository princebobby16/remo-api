package com.example.momorecorder.enums;


public enum TransactionTypes {
    DEPOSIT("DEPOSIT"),
    WITHDRAWAL("WITHDRAWAL"),
    TRANSFER("TRANSFER"),
    AIRTIME("AIRTIME");

    private final String transactionType;

    TransactionTypes(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

}
