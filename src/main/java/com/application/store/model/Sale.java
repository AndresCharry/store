package com.application.store.model;

import com.application.store.dto.SaleRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDate date;

    @OneToMany(
            mappedBy = "sale",
            cascade = CascadeType.PERSIST
    )
    private List<SaleDetails> details;

    @ManyToOne
    @JoinColumn(
            name = "fk_customer_id",
            referencedColumnName = "id"
    )
    private Customer customer;

    public Sale(SaleRequestDTO saleRequestDTO) {
        this.details = saleRequestDTO.saleDetails()
                                     .stream()
                                     .map(SaleDetails::new)
                                     .toList();
        this.customer = new Customer();
    }

    public BigDecimal getTotal() {
        if (details == null || details.isEmpty()) return BigDecimal.ZERO;

        return details.stream()
                .map(SaleDetails::getSubtotal)
                .reduce(BigDecimal.ZERO, (current, total) -> total.add(current));
    }
}
