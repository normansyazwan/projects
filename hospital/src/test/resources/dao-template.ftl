package ${m.basePackage}.dao.${m.className?uncap_first};

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ${m.className}Dao{
	
	private static final Logger log = LoggerFactory.getLogger(${m.className}Dao.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public ${m.className} get${m.className?cap_first}ById(Long ${m.className?uncap_first}Id) {
		log.info("Fetching record for ${m.className?uncap_first}Id: {}", ${m.className?uncap_first}Id);
		${m.className} ${m.className?lower_case} = null;
		Session session = this.sessionFactory.getCurrentSession();
		${m.className?lower_case} = (${m.className}) session.get(${m.className}.class, ${m.className?uncap_first}Id);
		return ${m.className?lower_case};
	}

}