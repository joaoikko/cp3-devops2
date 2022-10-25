package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CarroDao;
import br.com.fiap.jpa.entity.Carro;

public class CarroDaoImpl extends GenericDaoImpl<Carro, Integer> implements CarroDao{

	public CarroDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
