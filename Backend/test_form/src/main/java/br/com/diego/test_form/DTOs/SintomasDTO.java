package br.com.diego.test_form.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SintomasDTO {
        private Long id;
        private Boolean dorDeCabeca;
        private Boolean vomito;
        private Boolean diarreia;
        private Boolean sangramento;
        private Boolean dorMuscular;
}
