package br.com.diego.test_form.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.persistence.*;

@Data
@NoArgsConstructor

@Entity
public class SintomasModel {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Boolean dorDeCabeca;
        private Boolean vomito;
        private Boolean diarreia;
        private Boolean sangramento;
        private Boolean dorMuscular;

        public SintomasModel(Long id, Boolean dorDeCabeca, Boolean vomito, Boolean diarreia, Boolean sangramento,
                Boolean dorMuscular) {
            super();
            this.id = id;
            this.dorDeCabeca = dorDeCabeca;
            this.vomito = vomito;
            this.diarreia = diarreia;
            this.sangramento = sangramento;
            this.dorMuscular = dorMuscular;
        }

        
}
