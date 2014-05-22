package com.hex.fre.qrm.csp.mb;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import pack.MasterPoolBeanRemote;

import com.frd.hex.csp.finalpool.model.MasterPoolData;
import com.hex.exception.HexApplicationException;
import com.hex.fre.qrm.csp.datamodel.PoolDataModel;

@ManagedBean
@SessionScoped
public class BroadCastPoolBean {

    private final static List<String> VALID_COLUMN_KEYS = Arrays.asList("pool_id","pool_number","coupon",
    		"initial_disclosure_date", "final_disclosure_date","planned_settlement","ml_flag", "market_pool_flag", 
    		"ml_giant_pool_number", "arm_index_code", "arm_plkan_number", "creation_datetime","soa_proxy_trans_id",
    		"sec_man_trans_id","csp_trans_id","pool_status","face_amount","pooling_loan_upb","created_date","modified_date");

	private Map<String,String> cities = new HashMap<String, String>();

	List<OpenPool> openPoolList = new ArrayList<OpenPool>();
	private LazyDataModel<MasterPoolData> lazyModel;
	
	private MasterPoolData selectedPool;
	private List<MasterPoolData> masterPoolDataList = null;
	private MasterPoolData masterPoolData = null;

	private List<OpenPool> filteredCars;
	private OpenPool selectedCar;
	//private MasterPoolData selectedPool;
	
	private PoolDataModel poolDataModel;
    
	private List<ColumnModel> columns = new ArrayList<ColumnModel>();
	private String columnTemplate = "pool_number coupon initial_disclosure_date final_disclosure_date";
	
    //private List<ColumnModel> columns = new ArrayList<ColumnModel>();;
	private List<String> selectedPools = null;  
    private Map<String,String> poolsData = null;
	private List<MasterPoolData> filteredCars2;

    public String onRowSelectNavigate(SelectEvent event) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedCar", event.getObject());
        return "carDetail?faces-redirect=true";
    }

	public BroadCastPoolBean() {
		System.out.println("BroadCastPoolBean consteuctor....");
		
		System.out.println("BroadCastPoolBean....");
		selectedPools = new ArrayList<String>();
		selectedPools.add("pool_number");
		selectedPools.add("coupon");
		selectedPools.add("initial_disclosure_date");
		selectedPools.add("final_disclosure_date");

		poolsData = new HashMap<String, String>();  
		poolsData.put("pool_number", "pool_number");  
		poolsData.put("coupon", "coupon");  
		poolsData.put("initial_disclosure_date", "initial_disclosure_date");  
		poolsData.put("final_disclosure_date", "final_disclosure_date");
		poolsData.put("planned_settlement", "planned_settlement");  
		poolsData.put("ml_flag", "ml_flag");  
		poolsData.put("market_pool_flag", "market_pool_flag");  
		poolsData.put("ml_giant_pool_number", "ml_giant_pool_number");
		poolsData.put("arm_index_code", "arm_index_code");  
		poolsData.put("arm_plkan_number", "arm_plkan_number");  
		poolsData.put("creation_datetime", "creation_datetime");  
		poolsData.put("soa_proxy_trans_id", "soa_proxy_trans_id");
		poolsData.put("sec_man_trans_id", "sec_man_trans_id");  
		poolsData.put("csp_trans_id", "csp_trans_id");  
		poolsData.put("pool_status", "pool_status");  
		
		//Updating BroadCasting
		updateBroadCast();
		
		//Calling Columns
		createDynamicColumns();
	}

	public void updateBroadCast() {
		System.out.println("----------------------------------Refreshing updateBroadCast-----------------------------------------------");
		
		masterPoolDataList = new ArrayList<MasterPoolData>();
		System.out.println("masterPoolDataList size: "+masterPoolDataList.size());
		
		InitialContext ctx;
		MasterPoolBeanRemote bk = null;
		
		try {
			ctx = new InitialContext();
			bk = (MasterPoolBeanRemote) ctx
					.lookup("MasterPoolBeanRemote#pack.MasterPoolBeanRemote");
			//System.out.println("connection over");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//---------------------------------------------------
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			//get current date time with Date()
			Date date = new Date();
			//System.out.println(dateFormat.format(date));
			 
			//get current date time with Calendar()
			Calendar cal = Calendar.getInstance();
			System.out.println(dateFormat.format(cal.getTime()));
		
		//---------------------------------------------------
		
		String op = "add";
		boolean sendToDB2 = false;
		
		// Clearing MasterList
		masterPoolDataList.clear();
		
		try {
			masterPoolDataList = bk.getAllPool();
			System.out.print( "MasterPool Table data persisted, " );
			System.out.println(" masterPoolDataList size: "+masterPoolDataList.size());
		}
		catch (Exception e) {
			sendToDB2 = false;
			System.out.println( "ORacle Insert issueeeeee "+e.getMessage() );
			e.getStackTrace();
		}
		
		poolDataModel = new PoolDataModel(masterPoolDataList);
		System.out.println("masterPoolDataList inside size:: "+masterPoolDataList.size());
		lazyModel = new LazyOpenPoolDataModel(masterPoolDataList);
    }
	
	public void updateColumns() {
        //reset table state
        UIComponent table = FacesContext.getCurrentInstance().getViewRoot().findComponent(":form:poolColumn");
        //table.setValueExpression("sortBy", null);
        
        //update columns
        createDynamicColumns();
    }
    
    public void createDynamicColumns() {
        //String[] columnKeys = columnTemplate.split(" ");
    	//System.out.println("createDynamicColumns....");
        columns.clear();      

       //System.out.println("selectedPools size: "+selectedPools.size());
        
        //String[] columnKeys = null;
        String[] columnKeys = new String[selectedPools.size()]; 
        for(int i=0; i<selectedPools.size(); i++){
        	columnKeys[i] = selectedPools.get(i);
        }
        
        //System.out.println("columnKeys size: "+columnKeys.length);
        for(String columnKey : columnKeys) {
            String key = columnKey.trim();
            //System.out.println("key: "+key);
            if(VALID_COLUMN_KEYS.contains(key)) {
            	//System.out.println("valid column keys: "+key);
                columns.add(new ColumnModel(columnKey.toUpperCase(), columnKey));
            }
        }
        //System.out.println("columns size: "+columns.size());
    }
	
    public void displayLocation() {
        //FacesMessage msg = new FacesMessage("Selected", "City:" + city + ", Suburb: " + suburb);\
    	FacesMessage msg = new FacesMessage("Selected", "City:--- Suburb: ");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowSelect(SelectEvent event){
    	System.out.println("onRowSelect...");
    	FacesMessage msg = new FacesMessage("Row Selected: ",((MasterPoolData)event.getObject()).getPool_number());
    	System.out.println("Summary: "+msg.getSummary());
    }
    
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:panel");
    }
    
    public void resetFail() {
        //this.firstname = null;
        //this.surname = null;
        
        FacesMessage msg = new FacesMessage("Model reset, but it won't work.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	public List<OpenPool> getOpenPoolList() {
		return openPoolList;
	}

	public void setOpenPoolList(List<OpenPool> openPoolList) {
		this.openPoolList = openPoolList;
	}

	public LazyDataModel<MasterPoolData> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<MasterPoolData> lazyModel) {
		this.lazyModel = lazyModel;
	}

	public MasterPoolData getSelectedPool() {
		return selectedPool;
	}

	public void setSelectedPool(MasterPoolData selectedPool) {
		this.selectedPool = selectedPool;
	}

	public List<MasterPoolData> getMasterPoolDataList() {
		return masterPoolDataList;
	}

	public void setMasterPoolDataList(List<MasterPoolData> masterPoolDataList) {
		this.masterPoolDataList = masterPoolDataList;
	}

	public MasterPoolData getMasterPoolData() {
		return masterPoolData;
	}

	public void setMasterPoolData(MasterPoolData masterPoolData) {
		this.masterPoolData = masterPoolData;
	}

	public List<OpenPool> getFilteredCars() {
		return filteredCars;
	}

	public void setFilteredCars(List<OpenPool> filteredCars) {
		this.filteredCars = filteredCars;
	}

	public Map<String, String> getCities() {
		return cities;
	}

	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}

	public OpenPool getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(OpenPool selectedCar) {
		this.selectedCar = selectedCar;
	}

	public PoolDataModel getPoolDataModel() {
		return poolDataModel;
	}

	public void setPoolDataModel(PoolDataModel poolDataModel) {
		this.poolDataModel = poolDataModel;
	}

	static public class ColumnModel implements Serializable {

        private String header;
        private String property;

        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }

        public String getHeader() {
            return header;
        }

        public String getProperty() {
            return property;
        }
    }

	public List<ColumnModel> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnModel> columns) {
		this.columns = columns;
	}

	public String getColumnTemplate() {
		return columnTemplate;
	}

	public void setColumnTemplate(String columnTemplate) {
		this.columnTemplate = columnTemplate;
	}

	public List<String> getSelectedPools() {
		return selectedPools;
	}

	public void setSelectedPools(List<String> selectedPools) {
		this.selectedPools = selectedPools;
	}

	public Map<String, String> getPoolsData() {
		return poolsData;
	}

	public void setPoolsData(Map<String, String> poolsData) {
		this.poolsData = poolsData;
	}

	public List<MasterPoolData> getFilteredCars2() {
		return filteredCars2;
	}

	public void setFilteredCars2(List<MasterPoolData> filteredCars2) {
		this.filteredCars2 = filteredCars2;
	}

	public static List<String> getValidColumnKeys() {
		return VALID_COLUMN_KEYS;
	}

	
}