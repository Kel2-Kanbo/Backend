package com.example.officebookingsystem.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "buildings", uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
})
public class Building {
        @Id
        @SequenceGenerator(name = "building_sequence", sequenceName = "building_sequence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "building_sequence")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "complex_id")
        private Complex complex;

        @NotBlank
        private String name;

        private String picture;

        @NotBlank
        private String address;

        @NotBlank
        private String description;

}
