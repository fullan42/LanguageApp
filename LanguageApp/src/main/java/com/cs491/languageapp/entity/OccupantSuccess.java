package com.cs491.languageapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OccupantSuccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isTrue;
    private LocalDateTime localDateTime;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn//YAZILAN her şey column olarak döndüğü için o columnların dönmesi için join column anotosyonu kullanılıyor
    private Word word;

    @ManyToOne(cascade =CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn
    private Occupant occupant;




}
