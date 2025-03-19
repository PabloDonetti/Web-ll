package dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity //entidade de domínio
public class Professor extends Pessoa {
	
	//private static final long serialVersionUID = 1L; //Id padrão do Serializable
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int matriculaProfessor;
	
	public Professor() {
		this("","",0);
	}
	
	public Professor(String nome, String cpf, int matriculaProfessor) {
		super(nome,cpf);
		setMatriculaProfessor(matriculaProfessor);
	}
	
	public int getMatriculaProfessor() {
		return this.matriculaProfessor;
	}

	public void setMatriculaProfessor(int matriculaProfessor) {
		this.matriculaProfessor = matriculaProfessor;
	}
	
	@Override
	public String toString() {
		return "Professor [idPessoa= " + super.getIdPessoa() + ", nome= " + super.getNome() + ", matriculaProfessor= "
		+ getMatriculaProfessor() + "]";
	}
	/*
	public void imprimeDados() {
		System.out.println("Nome: "+ super.getNome());
		System.out.println("CPF: "+ super.getCpf());
		System.out.println("Matricula Professor: "+ getMatriculaProfessor());
	}
	*/

}