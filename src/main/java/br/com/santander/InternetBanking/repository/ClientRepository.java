package br.com.santander.InternetBanking.repository;

import br.com.santander.InternetBanking.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
