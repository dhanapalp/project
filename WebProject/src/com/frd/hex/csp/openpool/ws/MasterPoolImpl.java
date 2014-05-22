package com.frd.hex.csp.openpool.ws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.naming.InitialContext;

import com.frd.hex.csp.finalpool.model.MasterPoolData;

import pack.MasterPoolBeanRemote;

public class MasterPoolImpl implements MasterPool {

	@Override
	public MasterPoolData selectPool(MasterPoolData masterPoolData){

		System.out.println("MasterPoolData Impl...............");

		try {
				InitialContext ctx;
				MasterPoolBeanRemote bk = null;
				try {
					ctx = new InitialContext();
					bk = (MasterPoolBeanRemote) ctx
							.lookup("MasterPoolBeanRemote#pack.MasterPoolBeanRemote");
					System.out.println("connection over");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//---------------------------------------------------
				
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					//get current date time with Date()
					Date date = new Date();
					System.out.println(dateFormat.format(date));
					 
					//get current date time with Calendar()
					Calendar cal = Calendar.getInstance();
					System.out.println(dateFormat.format(cal.getTime()));
				
				//---------------------------------------------------
				
				String op = "add";
				boolean sendToDB2 = false;
				try {
					//openPoolData.setCreated_date("05/08/2014");
					//finalPoolData.setCreated_date(cal.getTime());
					//openPoolData.setPool_status("initial");
					bk.select(masterPoolData);
					System.out.println( "Master Pool Table data selected" );
				}
				catch (Exception e) {
					sendToDB2 = false;
					System.out.println( "ORacle select issueeeeee "+e.getMessage() );
				}
				
		}
		catch (Exception e)
		{
			System.out.println("Exception..."+e.getMessage());
			e.printStackTrace();
		}
		
		return masterPoolData;
	}
	
}
