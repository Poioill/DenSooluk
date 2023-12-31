package com.example.denSooluk.Entity.polyclinicModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String capital;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn
    private Region region;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
    private List<Polyclinic> polyclinics = new ArrayList<>();

    @JsonIgnore
    public Region getRegion() {
        return region;
    }

    @JsonIgnore
    public void setRegion(Region region) {
        this.region = region;
    }

    public Long getRegion_id() {
        return region.getId();
    }


    public String getRegionName() {
        return region.getName();
    }
}
