package br.com.santander.InternetBanking.repository;

import br.com.santander.InternetBanking.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Override
    Page<Client> findAll(Pageable pageable);
}
