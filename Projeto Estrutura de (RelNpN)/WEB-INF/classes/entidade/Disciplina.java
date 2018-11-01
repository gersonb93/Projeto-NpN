package entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqdisc", sequenceName = "seqdisc")
public class Disciplina {

	@Id
	@GeneratedValue(generator = "seqdisc")
	private Integer idDisciplina;

	@Column(nullable = false, length = 20)
	private String nome;

	@Column(nullable = false)
	private Integer cargaHr;

	@ManyToMany(mappedBy = "disciplinas")
	private List<Aluno> alunos;

	public Disciplina() {
		// TODO Auto-generated constructor stub
	}

	public Disciplina(Integer idDisciplina, String nome, Integer cargaHr) {
		super();
		this.idDisciplina = idDisciplina;
		this.nome = nome;
		this.cargaHr = cargaHr;
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCargaHr() {
		return cargaHr;
	}

	public void setCargaHr(Integer cargaHr) {
		this.cargaHr = cargaHr;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
