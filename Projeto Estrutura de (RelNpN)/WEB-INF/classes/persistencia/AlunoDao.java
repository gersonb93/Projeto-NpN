package persistencia;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import entidade.Aluno;

public class AlunoDao {

	Session s;
	Transaction t;
	
	public void save(Aluno a) throws Exception {
		s = HibernateUtil.getSessionFactory().openSession();
		t = s.beginTransaction();
		s.save(a);
		t.commit();
		s.close();
	}
	
	public List<Aluno> findAll() {
		s = HibernateUtil.getSessionFactory().openSession();
		Criteria c = s.createCriteria(Aluno.class);
		c = c.addOrder(Order.asc("nome"));
		
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<Aluno> lista = c.list();
		s.close();
		return lista;
	}
	
}
