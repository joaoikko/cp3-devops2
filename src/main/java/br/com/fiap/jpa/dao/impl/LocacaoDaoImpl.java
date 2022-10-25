package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.LocacaoDao;
import br.com.fiap.jpa.entity.Locacao;

public class LocacaoDaoImpl extends GenericDaoImpl<Locacao, Integer> implements LocacaoDao{

	public LocacaoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
