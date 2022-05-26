package com.example.products.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ProductsSize")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_product_size;

    @Column(name = "Value")
    private Integer value;

    @Column(name = "CurrentNumber")
    private Integer currentNumber;

    @Column(name = "Status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
