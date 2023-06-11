package br.com.diego.test_form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diego.test_form.model.SintomasModel;

@Repository
public interface SintomasRepository extends JpaRepository<SintomasModel, Long> {

}
