package demo.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/teste")
public class TesteController {

	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String sayHello(){
		return "Hello Word";
	}
	

	@RequestMapping(value="/aluno/{ra}",method=RequestMethod.GET)
	public Aluno getAluno(@PathVariable Integer ra){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Teste4");
		EntityManager em = emf.createEntityManager();
		Aluno novo =  (Aluno) em.createQuery("Select A From Aluno A Where A.ra = :ra")
				.setParameter("ra",ra).getSingleResult();
		em.close();
		emf.close();
		return novo;
	}

	@RequestMapping(value="/aluno/{ra}",method=RequestMethod.DELETE)
	public void deleteAluno(@PathVariable Integer ra){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Teste4");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.createQuery("Delete From Aluno A Where A.ra = :ra")
				.setParameter("ra",ra).executeUpdate();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	@RequestMapping(value="/aluno",method=RequestMethod.GET)
	public List<Aluno> retornarAlunos(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Teste4");
		EntityManager em = emf.createEntityManager();
		List<Aluno> lista = em.createNamedQuery("Aluno.findAll").getResultList();
		em.close();
		emf.close();
		return lista;
	}


	@RequestMapping(value="/aluno",method=RequestMethod.POST)
	public Aluno criarAluno(@RequestBody  Aluno novo){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Teste4");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(novo);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return novo;
	}
	
}
