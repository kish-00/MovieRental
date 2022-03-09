package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private int categoryId;

    @Column(name = "nameOfCategory", nullable = false)
    private String name;

    @Column(name="lastUpdate", nullable = false)
    private Timestamp lastUpdate;

    @ManyToMany(mappedBy = "categories")
    private List<Film> films;

}
