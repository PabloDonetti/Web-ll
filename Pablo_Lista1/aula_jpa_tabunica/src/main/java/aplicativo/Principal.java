package aplicativo;

import dominio.Pessoa;
import dominio.Professor;
import dominio.Aluno;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Principal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa"); //Instancia o EntityManagerFactory com as configurações de persistencia
		EntityManager em = emf.createEntityManager(); //Intancia o EntityManager
		
		Pessoa pessoa1 = new Pessoa("Lara", "XXX.XXX.XXX-XX");
		Pessoa pessoa2 = new Pessoa("Cecilia", "XXX.XXX.XXX-XX");
		
		Professor professor1 = new Professor("Rafael", "XXX.XXX.XXX-XX", 0001);
		Aluno aluno1 = new Aluno("Miguel", "XXX.XXX.XXX-XX", 0001);
		
		Professor professor2 = new Professor("Gabriel", "XXX.XXX.XXX-XX", 0001);
		Aluno aluno2 = new Aluno("Uriel", "XXX.XXX.XXX-XX", 0001);
		
		em.getTransaction().begin();// iniciar transação com banco de dados
		
		em.persist(pessoa1);
		em.persist(pessoa2);
		
		em.persist(professor1);
		em.persist(aluno1);
		
		em.persist(professor2);
		em.persist(aluno2);
		
		Query consultaPessoa = em.createQuery("select pessoa from Pessoa pessoa"); //consulta em jpql
		ArrayList<Pessoa> listaPessoa = (ArrayList<Pessoa>) consultaPessoa.getResultList();
		
		Query consultaP = em.createQuery("select professor from Professor professor"); //consulta em jpql
		ArrayList<Professor> listaP = (ArrayList<Professor>) consultaP.getResultList();
		
		Query consultaA = em.createQuery("select aluno from Aluno aluno"); //consulta em jpql
		ArrayList<Aluno> listaA = (ArrayList<Aluno>) consultaA.getResultList();
		
		em.getTransaction().commit();//confirmar as alterações realizadas
		
		emf.close();
		em.close();
		
		for(Pessoa objPessoa: listaPessoa) {
			System.out.println(objPessoa);
		}
		
		for(Professor objP: listaP) {
			System.out.println(objP);
		}
		
		for(Aluno objA: listaA) {
			System.out.println(objA);
		}
	}			
}