package com.multiplex.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.multiplex.entity.MultiplexEntity;
import com.multiplex.model.Multiplex;
import com.multiplex.repository.MultiplexRepository;

@Service
public class MultiplexServiceImpl implements MultiplexService{
	
	@Autowired
	MultiplexRepository multiplexepo;
	
	@Override
	public Multiplex saveMultiplex(Multiplex multiplex) {
		MultiplexEntity multiplexEntity = new MultiplexEntity();
		BeanUtils.copyProperties(multiplex, multiplexEntity);
		MultiplexEntity saveEntity = multiplexepo.save(multiplexEntity);
		BeanUtils.copyProperties(saveEntity, multiplex);
		return multiplex;
		
	}
	
	@Override
	public List<Multiplex> getAllMultiplex() {
		List<MultiplexEntity> findAll = multiplexepo.findAll();

		return findAll.stream().map(multiplexEntity -> {
			Multiplex multiplex = new Multiplex();
			BeanUtils.copyProperties(multiplexEntity, multiplex);
			return multiplex;
		}).collect(Collectors.toList()).stream()
				.collect(Collectors.toList());

	}
	
	@Override
	public Multiplex getMultiplexByID(Long id) {
		
		Optional<MultiplexEntity> findById = multiplexepo.findById(id);
		if(findById.isPresent()) {
			MultiplexEntity multiplexEntity = findById.get();
	
			Multiplex multiplex = new Multiplex();
		
			BeanUtils.copyProperties(multiplexEntity, multiplex);
			return multiplex;
		}
		return null;
	}
	
	@Override
	public void deleteMultiplexByID(Long id) {
		multiplexepo.deleteById(id);
		
	}

}
