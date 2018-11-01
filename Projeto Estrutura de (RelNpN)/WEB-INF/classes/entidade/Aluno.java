package entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "seqaluno", sequenceName = "seqaluno")
public class Aluno {

	@Id
	@GeneratedValue(generator = "seqaluno")
	private Integer matricula;

	@Column(nullable = false, length = 30)
	private String nome;

	@Column(nullable = false, length = 40, unique = true)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date nascimento;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "AlunosInscritos",
			joinColumns = @JoinColumn(name = "matricula", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "idDisciplina", nullable = false))
	private List<Disciplina> disciplinas;

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
