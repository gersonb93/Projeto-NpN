package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import persistencia.AlunoDao;
import persistencia.DisciplinaDao;

import entidade.Aluno;
import entidade.Disciplina;

@ManagedBean(name = "alunomb")
@RequestScoped
public class ManagerAluno {

	private Aluno aluno;
	private Map<String, Integer> disciplinas;
	private List<String> disciplinasAluno;
	private List<Aluno> listaAluno;

	public ManagerAluno() {

		aluno = new Aluno();
		disciplinasAluno = new ArrayList<String>();

		listaAluno = new ArrayList<Aluno>();

		disciplinas = new HashMap<String, Integer>();
		for (Disciplina d : new DisciplinaDao().findAll()) {
			disciplinas.put(d.getNome(), d.getIdDisciplina());
		}
	}

	public List<Aluno> getListaAluno() {
		listaAluno = new AlunoDao().findAll();
		return listaAluno;
	}

	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}

	public Map<String, Integer> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Map<String, Integer> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<String> getDisciplinasAluno() {
		return disciplinasAluno;
	}

	public void setDisciplinasAluno(List<String> disciplinasAluno) {
		this.disciplinasAluno = disciplinasAluno;
	}

	public void cadastrar() {

		FacesMessage msg = null;
		try {

			if (disciplinasAluno.size() > 0) {
				aluno.setDisciplinas(new ArrayList<Disciplina>());
				for (String id : disciplinasAluno) {
					Disciplina d = new Disciplina();
					d.setIdDisciplina(Integer.parseInt(id));
					aluno.getDisciplinas().add(d);
				}

				AlunoDao ad = new AlunoDao();
				ad.save(aluno);
				aluno = new Aluno();
				disciplinasAluno.clear();

				msg = new FacesMessage("Aluno cadastrado com sucesso.");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);

			} else {
				msg = new FacesMessage("Selecione no minimo 1(uma) disciplina.");
				msg.setSeverity(FacesMessage.SEVERITY_WARN);
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro: " + e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
		FacesContext.getCurrentInstance().addMessage("formCadastro", msg);
	}

}
