package com.nougat.domain.entities;

import com.nougat.domain.common.BaseEntity;
import com.nougat.domain.constants.PaymentMethod;
import com.nougat.domain.constants.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "order")
@Entity
public class Payment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private String transactionId;
    private LocalDateTime paymentDate;
}
