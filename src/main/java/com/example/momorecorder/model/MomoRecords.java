package com.example.momorecorder.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;


@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "momo_records", schema = "momo_records")
@NoArgsConstructor
@AllArgsConstructor
public class MomoRecords {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private String transactionType;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private Float amount;
    @Column(nullable = false)
    private Float commission;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

}
