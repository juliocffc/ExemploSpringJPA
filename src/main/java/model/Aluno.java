package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@Table(name="aluno")
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int ra;

	@Column(length=45)
	private String contato;

	@Column(length=45)
	private String nome;

	public Aluno() {
	}

	public int getRa() {
		return this.ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}