package com.thiagofarias.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagofarias.cursomc.domain.Pedido;
import com.thiagofarias.cursomc.repositories.PedidoRepository;
import com.thiagofarias.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+id+ ", Tipo: "+Pedido.class.getName()
				));
		
	}
	
}