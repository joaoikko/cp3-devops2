package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ManutencaoDao;
import br.com.fiap.jpa.entity.Manutencao;

public class ManutencaoDaoImpl extends GenericDaoImpl<Manutencao, Integer> implements ManutencaoDao{

	public ManutencaoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
