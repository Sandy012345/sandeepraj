package com.te.MavinProject2.login.register;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.JpaHibernate.MavinProject2.Account;
import com.te.JpaHibernate.MavinProject2.Inbox;

public class LoginRegister {

	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to Gmail login Page");

		System.out.println("Enter the username");
		String username = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();

		if (username.equals(username) && password.equals(password)) {

			System.out.println("login successfull");
			LoginRegister.compose();

		} else {
			System.out.println("user does not exists");
		}

	}

	public void Register() {

		Account acc = new Account();
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		Scanner sc2 = new Scanner(System.in);
		System.out.println("Welcome to Gmail for registeration");
		System.out.println("Enter the id");
		int id = sc2.nextInt();
		System.out.println("enter the user name");
		String name = sc2.next();
		sc2.nextLine();
		System.out.println("enter the password");
		String password = sc2.next();
		sc2.nextLine();
		System.out.println("Enter the Email");
		String email = sc2.next();

		acc.setId(id);
		acc.setName(name);
		acc.setPassword(password);
		acc.setEmail(email);

		factory = Persistence.createEntityManagerFactory("gmailLogin");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(acc);
		transaction.commit();
		System.out.println("Registeration successfull");
	}

	public static void compose() {

		Inbox in = new Inbox();
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		Scanner sc = new Scanner(System.in);

		System.out.println("A.Compose a msg\nB.Inbox\nC.logout");

		String a = sc.next();
		switch (a) {
		case "A":
			System.out.println("Enter the reciver id");
			int reciverid = sc.nextInt();
			System.out.println("Enter the reciver userid");
			int userid = sc.nextInt();
			sc.nextLine();
			System.out.println("enter the message ur message");
			String msg = sc.next();
			in.setMessage_id(reciverid);
			in.setUser_id(userid);
			in.setMessage(msg);
			factory = Persistence.createEntityManagerFactory("gmailLogin");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(in);
			transaction.commit();
			System.out.println("message sent successfully");
			break;
		case "B":

			factory = Persistence.createEntityManagerFactory("gmailLogin");
			manager = factory.createEntityManager();
			String readall = "from  Inbox";
			Query query = manager.createQuery(readall);
			java.util.List<Inbox> l = query.getResultList();
			System.out.println("the sent messages");
			for (Inbox inbox : l) {

				System.out.println(inbox);
			
			}
			break;
		default:System.out.println("logout successfull");
				
		}

	}

	public static void update() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee id u wanna update");
		int id = sc.nextInt();
		System.out.println("Enter the name u wish to update");
		String name = sc.next();

		factory = Persistence.createEntityManagerFactory("gmailLogin");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();

		String updateData = "update Employ set name= :name where id=:id";
		Query query = manager.createQuery(updateData);

		query.setParameter("id", id);
		query.setParameter("name", name);
		transaction.commit();

	}
}