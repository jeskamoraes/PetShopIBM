package br.com.ibm.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ibm.petshop.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
