package com.unicomerjam.api.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicomerjam.api.db.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	

}
