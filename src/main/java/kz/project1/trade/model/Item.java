package kz.project1.trade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String exterior;
    private Double floatValue;
    private String imageUrl;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    private Offer offer;
}
