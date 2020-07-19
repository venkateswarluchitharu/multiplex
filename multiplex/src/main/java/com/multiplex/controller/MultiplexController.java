package com.multiplex.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.multiplex.exception.UserNotFoundException;
import com.multiplex.model.Multiplex;
import com.multiplex.service.MultiplexService;
import com.multiplex.service.MultiplexServiceImpl;

@RestController
@RequestMapping("/multiplex")
public class MultiplexController {
	
	@Autowired
	MultiplexServiceImpl multiplexServiceImpl;
	
	@PostMapping("/save")
	public  ResponseEntity<Multiplex> createMultiplex(@Valid @RequestBody Multiplex multiplex) {
		Multiplex savedMultiplex = multiplexServiceImpl.saveMultiplex(multiplex);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().pathSegment("/{id}")
	.buildAndExpand(savedMultiplex.getMultiplex_id()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Multiplex>> getAllMultiplex() {
		
		List<Multiplex> multiplexs= multiplexServiceImpl.getAllMultiplex();
		if(multiplexs.isEmpty()) {
			throw new UserNotFoundException("no contacts are there!");
		}
		else {
		
		return new ResponseEntity<List<Multiplex>>(multiplexs, HttpStatus.FOUND);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Multiplex> getMovieByID(@PathVariable("id") long id) {
		
		Multiplex multiplexFindByID= multiplexServiceImpl.getMultiplexByID(id);
		if(multiplexFindByID==null) {
			throw new UserNotFoundException(id+" contact not found");
		}
		else {
		return new ResponseEntity<Multiplex>(multiplexFindByID, HttpStatus.FOUND);
		}
	}
	
	@PutMapping("/get/{uid}") 
	  public ResponseEntity<Multiplex> updateMultiplex(@PathVariable("mid") Long uid, @RequestBody Multiplex multiplexinfo)
	  { 
	  Multiplex multiplex = multiplexServiceImpl.getMultiplexByID(uid);
	  BeanUtils.copyProperties(multiplexinfo, multiplex); 
	  multiplexServiceImpl.saveMultiplex(multiplex);
	  //return
	   URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().build()
				.toUri();
	  	return	ResponseEntity.created(location).build();
	  
	  }
	
	  @DeleteMapping("/get/{mid}")
			public ResponseEntity<Multiplex> deleteUser(@PathVariable("mid") Long mid) {
				Multiplex multiplexFindByID= multiplexServiceImpl.getMultiplexByID(mid);
			
				if(multiplexFindByID==null) {
					throw new UserNotFoundException(mid+" contact not found");
				}
				else {
					multiplexServiceImpl.deleteMultiplexByID(mid);
				return new ResponseEntity<Multiplex>(HttpStatus.OK);
				}
			}

}
