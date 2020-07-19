package com.multiplex.service;

import java.util.List;

import com.multiplex.model.Multiplex;


public interface MultiplexService {
	
	public Multiplex saveMultiplex(Multiplex multiplex);
	public List<Multiplex> getAllMultiplex();
	public Multiplex getMultiplexByID(Long id);
	public void deleteMultiplexByID(Long id);

}
