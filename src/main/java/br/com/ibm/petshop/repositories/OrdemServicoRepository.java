package br.com.ibm.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ibm.petshop.models.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

}
