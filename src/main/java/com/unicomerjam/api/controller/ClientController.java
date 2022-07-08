package com.unicomerjam.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicomerjam.api.db.entity.Client;
import com.unicomerjam.api.db.repo.ClientRepository;
import com.unicomerjam.api.excp.NoRecordFoundException;

@RestController
@RequestMapping("/api/client/")
public class ClientController {

	@Autowired
	private ClientRepository cRepo;

	// DEFAULT GET
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseWrapper<List<Client>>> getClients() {

		List<Client> clients = cRepo.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<List<Client>>(0, "OK", clients));

	}

	// GET
	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseWrapper<Client>> getClient(@PathVariable Long id) throws NoRecordFoundException {

		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Client>(0, "OK",
				cRepo.findById(id).orElseThrow(() -> new NoRecordFoundException("No record found with id: " + id))));

	}
	
	// POST
	@PostMapping(value = "save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseWrapper<Void>> saveClient(@Valid @RequestBody Client client) {
		
		cRepo.saveAndFlush(client);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Void>(0, "OK", null));
		
	}
	
	// UPDATE
	@PostMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseWrapper<Void>> updateClient(@Valid @RequestBody Client client) throws NoRecordFoundException {
		
		if(client.getId() == null || client.getId().equals(0L)) {
			throw new NoRecordFoundException("No record found");
		}
		
		cRepo.findById(client.getId()).orElseThrow(() -> new NoRecordFoundException("No record found with id: " + client.getId()));
		cRepo.saveAndFlush(client);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<Void>(0, "OK", null));
		
	}
	

}
