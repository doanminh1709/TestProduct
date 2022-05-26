package com.example.products.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "New")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNew;

    @Column(name = "Content")
    private String content;

    @Column(name = "Status")
    private Integer status;

    @OneToMany(mappedBy = "news" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Image> imageList;


}
