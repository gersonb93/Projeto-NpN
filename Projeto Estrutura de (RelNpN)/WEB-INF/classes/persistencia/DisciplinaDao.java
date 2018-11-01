package persistencia;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entidade.Disciplina;

public class DisciplinaDao {

	Session s;
	Transaction t;
	
	public void save(Disciplina d) throws Exception {
		s = HibernateUtil.getSessionFactory().openSession();
		t = s.beginTransaction();
		s.save(d);
		t.commit();
		s.close();
	}
	
	public List<Disciplina> findAll() {
		s = HibernateUtil.getSessionFactory().openSession();
		List<Disciplina> lista = s.createQuery("from Disciplina d order by d.nome").list();
		s.close();
		return lista;
	}
	
	// Inserir disciplinas.
	public static void main(String[] args) {
		try {
			List<Disciplina> lista = Arrays.asList(
					new Disciplina(null, "Oracle", 40),
					new Disciplina(null, "Java", 120),
					new Disciplina(null, "PHP", 40),
					new Disciplina(null, "UML", 20),
					new Disciplina(null, "Banco de Dados", 32));
			
			DisciplinaDao dd = new DisciplinaDao();
			for(Disciplina d : lista) {
				dd.save(d);
			}
			System.out.println("Disciplinas cadastradas.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}











