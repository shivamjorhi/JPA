package com.cg.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.bean.Account;

public class AccountDAOImpl implements AccountDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();

	public boolean addAccount(Account ob) {
		em.getTransaction().begin();
		em.persist(ob);
		em.flush();
		em.getTransaction().commit();
		return true;
	}

	@Override
	public Account findAccount(Long mobileno) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Account ob = em.find(Account.class, mobileno);
		em.getTransaction().commit();
		return ob;
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Query q = em.createQuery("from Account a"); // That's \"JPQL\" not SQL !!!
		em.getTransaction().commit();
		return q.getResultList();

	}

	@Override
	public void deleteAccount(Account ob) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(ob);
		em.getTransaction().commit();
	}

	@Override
	public boolean updateAccount(Account ob) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.merge(ob);
		em.getTransaction().commit();
		return true;
	}
	/*	
	
		
	
		
		
	*/
}
