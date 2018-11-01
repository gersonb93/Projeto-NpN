package config;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CriacaoTabelas {

	public static void main(String[] args) {
		
		new SchemaExport(new AnnotationConfiguration()
			.configure("config/oracle_hibernate.cfg.xml")).create(true, true);
	}
}
