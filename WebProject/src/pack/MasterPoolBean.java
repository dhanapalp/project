package pack;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.frd.hex.csp.finalpool.model.MasterPoolData;
import com.hex.exception.HexApplicationException;

@Stateless(mappedName = "MasterPoolBeanRemote")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MasterPoolBean implements MasterPoolBeanRemote {

	@PersistenceUnit(unitName = "CspOpenpoolJTA")
	private EntityManagerFactory factory;
	
	@Override
    public List<MasterPoolData> getAllPool() throws HexApplicationException {
		//System.out.println("00 getAllPool()");
		EntityManager em = null;
		List<MasterPoolData> masterPoolList = new ArrayList<MasterPoolData>();
		//System.out.println("11 getAllPool()");
		try {
			em = factory.createEntityManager();
			//System.out.println("22 getAllPool()");
			System.out.println("getAllPool masterPoolDataList size: "+masterPoolList.size());
			
			masterPoolList = em.createNamedQuery("MasterPoolData.getAllPool", MasterPoolData.class)
                    .getResultList(); 
			
			System.out.println("Author object Record Found Successfully: "+masterPoolList.size());	
		}
		catch ( Exception exception ) {
			throw new HexApplicationException ( exception );
		}
		finally {         
			em.close();
	    }
		
		return masterPoolList;
    }
	
	@Override
	public MasterPoolData select(MasterPoolData masterPoolData) throws HexApplicationException {
		
		System.out.println("MasterPoolData: Inside select Methode");
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			MasterPoolData result = (MasterPoolData) em.find( MasterPoolData.class, masterPoolData.getPool_number());
			
			System.out.println("Author object Record Found Successfully");	
			return result;
		}
		catch ( Exception exception ) {
			throw new HexApplicationException ( exception );
		}
		finally {         
			em.close();
	    }
	}
	
}