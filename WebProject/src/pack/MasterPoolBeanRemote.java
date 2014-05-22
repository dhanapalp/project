package pack;

import java.util.List;

import javax.ejb.Remote;

import com.frd.hex.csp.finalpool.model.MasterPoolData;
import com.hex.exception.HexApplicationException;


@Remote
public interface MasterPoolBeanRemote {

	//public OpenPoolData select(OpenPoolData openPoolData) throws HexApplicationException;
	public MasterPoolData select(MasterPoolData masterPoolData) throws HexApplicationException;
	public List<MasterPoolData> getAllPool() throws HexApplicationException;
	 ;
	
}