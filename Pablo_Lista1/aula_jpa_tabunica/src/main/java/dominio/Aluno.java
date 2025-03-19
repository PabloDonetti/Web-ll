package dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity //entidade de domínio
public class Aluno extends Pessoa {
	
	//private static final long serialVersionUID = 1L; //Id padrão do Serializable
	
	private int matriculaAluno;
	
	public Aluno() {
		this("","",0);
	}
	
	public Aluno(String nome, String cpf, int matriculaAluno) {
		super(nome,cpf);
		setMatriculaAluno(matriculaAluno);
	}
	
	public int getMatriculaAluno() {
		return this.matriculaAluno;
	}

	public void setMatriculaAluno(int matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	
	@Override
	public String toString() {
		return "Aluno [idPessoa= " + super.getIdPessoa() + ", nome= " + super.getNome() + ", matriculaAluno= "
		+ getMatriculaAluno() + "]";
	}
	/*
	public void imprimeDados() {
		System.out.println("Nome: "+ super.getNome());
		System.out.println("CPF: "+ super.getCpf());
		System.out.println("Matricula Aluno: "+ getMatriculaAluno());
	}
	*/
}