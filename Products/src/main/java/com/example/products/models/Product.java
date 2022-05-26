package com.example.products.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Product;

    @Column(name = "Title")
    //@NotBlank(message = "Not empty")
    private String title;

    @Column(name = "Short description")
    private String shortDescription;

    @Column(name = "Long description")
    private String longDescription;

    @Column(name = "Money")
    //@Min(0)
    private float money;

    @Column(name = "Slug")
    private String slug;

    @Column(name = "Brand")
   // @NotNull
    private String brand;

   /// @Min(0)
    @Column(name = "Status")
    private Integer status;

    @Column(name = "Type")
    private String type;

    @Column(name = "Gender")
    //@NotNull
    private String gender;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product" ,  cascade =  CascadeType.ALL)
    // whenever you do any operation on the parent all those operations would also get cascaded to the child.
    private List<ProductColor> productColorList;

    //Product Size
    @OneToMany(mappedBy = "product" ,  cascade =  CascadeType.ALL)
    private List<ProductSize> productSizes;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private List<ProductRate> productRates;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL
            , fetch = FetchType.LAZY)
    //Will get initialized only when we explicitly call it,
    // using a getter or some other method:
    private List<Image> imageList;


}
