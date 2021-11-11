package Conn.Rj.Coustom;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class Coustom_Generator implements IdentifierGenerator {

	
	public Coustom_Generator()
	{
		System.out.println("Coustom_Generator.0 Parms Constructure");
	}
	
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		System.out.println("Coustom_Generator.generate()");
		
		Integer idval=new Random().nextInt(20000);
		
		return idval;
	}
  
	
	
}
