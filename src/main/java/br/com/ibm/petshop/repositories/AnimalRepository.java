package br.com.ibm.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ibm.petshop.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
