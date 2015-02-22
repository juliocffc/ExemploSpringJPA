package demo.controllers;

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
	

	@RequestMapping(value="/alunos/{ra}",method=RequestMethod.GET)
	public Aluno getAluno(@PathVariable Integer ra){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Teste4");
		EntityManager em = emf.createEntityManager();
		Aluno novo =  (Aluno) em.createQuery("Select A From Aluno A Where A.ra = :ra")
				.setParameter("ra",ra).getSingleResult();
		em.close();
		emf.close();
		return novo;
	}
	

	@RequestMapping(value="/alunos",method=RequestMethod.POST)
	public String criarAluno(@RequestBody()  Aluno novo){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Teste4");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(novo);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return "Aluno:"+novo.getNome();
	}
	
}
