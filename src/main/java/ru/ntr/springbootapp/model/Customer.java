package ru.ntr.springbootapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Order> orders;

    public String getProducts() {
        return orders.stream()
                .flatMap(p -> p.getProducts().stream())
                .distinct()
                .map(p -> p.getName())
                .sorted()
                .collect(Collectors.joining(", "));
    }

}
