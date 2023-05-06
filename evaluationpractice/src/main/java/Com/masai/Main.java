package Com.masai;


import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class Main {

	static EntityManagerFactory emf;
	
	static {
		emf=Persistence.createEntityManagerFactory("Raushan");
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c;
		
		do {
			System.out.println("1.Add Author details");
			System.out.println("2. Display Author details BY Id");
			System.out.println("3. delete Author details");
			System.out.println("4. Update Author details");
			System.out.println("5. Display Author details");
			System.out.println("0. Exit");
			
			c=sc.nextInt();
			
			switch (c) {
			case 1: 
				
				AddUi(sc);
				break;
case 2: 
				
				Display(sc);
				break;
case 3: 
	
	Delete(sc);
	break;
case 4: 
	
	Update(sc);
	break;
case 5: 
	
	Printall(sc);
	break;
case 0: 
	
	System.out.println("Thanks");
	break;
	
				
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + c);
			}
			
			
			
		}while(c!=0);
		sc.close();
	}


	private static void Printall(Scanner sc) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		
		String q="select e from Author e";
		
		Query t=em.createQuery(q);
		
		List<Author> list=t.getResultList();
		
		list.forEach(System.out::println);
		
		
	}


	private static void Update(Scanner sc) {
EntityManager em=emf.createEntityManager();
		
Author a=null;
		System.out.println("Enter id");
		String id=sc.next();
		System.out.println("Enter rating");
		double rating=sc.nextDouble();
		
		a=em.find(Author.class, id);
		
		if(a==null)
		{
			System.out.println("NO author for given id");
		}
		
		
		else {
			a.setRating(rating);
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		try {
		em.merge(a);
		System.out.println("Updated  successfully");
		}
		catch(IllegalAccessError e)
		{	
			System.out.println(e.getMessage());
		}
	finally{	
	et.commit();
		em.close();
	}
		
	}
	
		
		
	}


	private static void Delete(Scanner sc) {
		EntityManager em=emf.createEntityManager();
		
		Author a=null;
				System.out.println("Enter id");
				String id=sc.next();
				
				
				a=em.find(Author.class, id);
				
				if(a==null)
				{
					System.out.println("NO author for given id");
				}
				
				
				else {
				
				EntityTransaction et=em.getTransaction();
				
				et.begin();
				try {
				em.remove(a);
				System.out.println("Deleted  successfully");
				}
				catch(IllegalAccessError e)
				{	
					System.out.println(e.getMessage());
				}
			finally{	
			et.commit();
				em.close();
			}
				
			}
			
		
	}


	private static void Display(Scanner sc) {
	EntityManager em=emf.createEntityManager();
		
		Author a=null;
				System.out.println("Enter id");
				String id=sc.next();
				
				
				a=em.find(Author.class, id);
				
				if(a==null)
				{
					System.out.println("NO author for given id");
				}
				
				
				else {
				
				EntityTransaction et=em.getTransaction();
				
				et.begin();
				try {
			List<Author> list=new ArrayList<>();
			list.add(a);
			System.out.println("Author List");
			list.forEach(System.out::println);
				
				}
				catch(IllegalAccessError e)
				{	
					System.out.println(e.getMessage());
				}
			finally{	
			et.commit();
				em.close();
			}
				
			}
		
		
	}


	private static void AddUi(Scanner sc) {
EntityManager em=emf.createEntityManager();
		
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter rating");
		double rating=sc.nextDouble();
		
		Author au=new Author(name,rating);
		
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		try {
		em.persist(au);
		System.out.println("Added successfully");
		}
		catch(PersistenceException e)
		{	
			System.out.println("Not added");
		}
	finally{	
	et.commit();
		em.close();
	}
		
	}
	
}
