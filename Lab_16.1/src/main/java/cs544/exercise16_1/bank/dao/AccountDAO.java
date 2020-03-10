package cs544.exercise16_1.bank.dao;

import java.util.*;

import cs544.exercise16_1.bank.domain.Account;
import org.hibernate.SessionFactory;

import javax.persistence.Entity;


public class AccountDAO implements IAccountDAO {
	private SessionFactory sf;

	public AccountDAO() {
		sf=HibernateUtil.getSessionFactory();
	}

	public void saveAccount(Account account) {
		sf.getCurrentSession().save(account);
	}

	public void updateAccount(Account account) {

		sf.getCurrentSession().saveOrUpdate(account);


	}

	public Account loadAccount(long accountnumber) {
		Account retAccount=(Account) sf.getCurrentSession().get(Account.class,accountnumber);
		return retAccount;
	}

	public Collection<Account> getAccounts()
	{
		Collection<Account> retAccounts=sf.getCurrentSession().createQuery("from Account ac").list();
		return retAccounts;
	}

}
