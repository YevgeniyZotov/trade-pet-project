package kz.project1.trade.model;

import jakarta.persistence.*;
import kz.project1.trade.model.enums.OfferStatus;
import lombok.Data;

@Entity
@Table(name = "offers")
@Data
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OfferStatus status = OfferStatus.ACTIVE;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
