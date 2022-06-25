package com.example.momorecorder.repository;

import com.example.momorecorder.model.MomoRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;
import java.util.UUID;

public interface MomoRecordsRepository extends JpaRepository<MomoRecords, UUID> {

    @Query(value = "select sum(commission) totalCommission, current_date as cDate from momo_records.momo_records where date = current_date;", nativeQuery = true)
    Tuple getDailyCommission();

    @Query(value = "select sum(commission) as totalCommission from momo_records.momo_records r where date_part('month', r.date) = date_part('month', current_date)", nativeQuery = true)
    Tuple getMonthlyCommission();

    @Query(value = "select sum(commission) totalCommission, date_part('month', r.date) as cDate from momo_records.momo_records r where date_part('month', r.date) = date_part('month', current_date) group by r.date;", nativeQuery = true)
    Tuple getAllMonthlyCommissions();

    @Query(value = "select * from momo_records.momo_records mr where mr.date = current_date;", nativeQuery = true)
    List<MomoRecords> getDailyTransactions();

    @Query(value = "select count(id) as totalTransactions from momo_records.momo_records where date = current_date;", nativeQuery = true)
    Tuple countDailyTransactions();

}