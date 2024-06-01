package com.application.store.model;

import com.application.store.dto.SaleRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDate date;

    @OneToMany(
            mappedBy = "sale",
            cascade = CascadeType.ALL
    )
    private List<SaleDetails> saleDetails;

    @ManyToOne
    @JoinColumn(
            name = "fk_customer_id",
            referencedColumnName = "id"
    )
    private Customer customer;

    public Sale(SaleRequestDTO saleRequestDTO) {
        this.saleDetails = saleRequestDTO.saleDetails()
                                     .stream()
                                     .map(SaleDetails::new)
                                     .toList();
        this.customer = new Customer(saleRequestDTO.customerId());
    }

    public BigDecimal getTotal() {
        if (saleDetails == null || saleDetails.isEmpty()) return BigDecimal.ZERO;

        return saleDetails.stream()
                .map(SaleDetails::getSubtotal)
                .reduce(BigDecimal.ZERO, (current, total) -> total.add(current));
    }
}
