package com.example.momorecorder.service;

import com.example.momorecorder.model.MomoRecords;
import com.example.momorecorder.repository.MomoRecordsRepository;
import com.example.momorecorder.request.MomoRecordsDto;
import com.example.momorecorder.response.TransactionResponse;
import com.example.momorecorder.response.TransactionsCount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.Tuple;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MomoRecordsService {
    private final MomoRecordsRepository recordsRepository;

    public MomoRecords save(MomoRecordsDto dto) {
        MomoRecords records = MomoRecords.builder()
                .amount(dto.getAmount())
                .commission(dto.getCommission())
                .date(new Date(System.currentTimeMillis()))
                .transactionType(dto.getTransactionType().getTransactionType())
                .phoneNumber(dto.getPhoneNumber())
                .id(UUID.randomUUID())
                .build();

        return recordsRepository.save(records);
    }

    public List<MomoRecords> findAll() {
        return recordsRepository.findAll();
    }

    public MomoRecords findOneById(String id) {
        return recordsRepository.findById(UUID.fromString(id)).orElse(new MomoRecords());
    }

    public TransactionsCount countDailyTransactions() {
        Tuple tuple = recordsRepository.countDailyTransactions();
        Number total = tuple.get("totalTransactions", BigInteger.class) == null ? 0 : tuple.get("totalTransactions", BigInteger.class);
        return new TransactionsCount(new Date(System.currentTimeMillis()), total);
    }

    public TransactionResponse getDailyCommission() {
        Tuple tuple = recordsRepository.getDailyCommission();
        float commission;
        commission = tuple.get("totalCommission", Float.class) == null ? (float) 0.0 : tuple.get("totalCommission", Float.class);

        return new TransactionResponse(
                tuple.get("cDate", Date.class),
                commission
        );
    }

    public TransactionResponse getMonthlyCommission() {
        Tuple tuple = recordsRepository.getMonthlyCommission();
        float commission;

        commission = tuple.get("totalCommission", Float.class) == null ? (float) 0.0 : tuple.get("totalCommission", Float.class);

        return new TransactionResponse(
                new Date(System.currentTimeMillis()),
                commission
        );
    }

    public List<MomoRecords> findAllDailyTransaction() {
        return recordsRepository.getDailyTransactions();
    }

}
