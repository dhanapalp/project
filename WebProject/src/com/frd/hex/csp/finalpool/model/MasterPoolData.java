package com.frd.hex.csp.finalpool.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */

@Entity
@Table(name="CSP_MASTERPOOL")
@NamedQueries({
	 @NamedQuery(name="MasterPoolData.getAllPool", query="SELECT masterPoolData FROM MasterPoolData masterPoolData")
}) 
public class MasterPoolData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3082456659327665104L;

	@Id
	@Column(name="POOL_ID")
	private Long pool_id;
	
	@Column(name="POOL_NUMBER")
	private String pool_number;

	@Column(name="COUPON")
	private int coupon;
	
	@Column(name="INITIAL_DISCLOSURE_DATE")
	private String initial_disclosure_date; 
	
	@Column(name="FINAL_DISCLOSURE_DATE")
	private String final_disclosure_date;
	
	@Column(name="PLANNED_SETTLEMENT")	
	private String planned_settlement;
	
	@Column(name="ML_FLAG")	
	private String ml_flag; 

	@Column(name="MARKET_POOL_FLAG")
	private String market_pool_flag; 

	@Column(name="ML_GIANT_POOL_NUMBER")
	private String ml_giant_pool_number; 

	@Column(name="ARM_INDEX_CODE")
	private String arm_index_code; 

	@Column(name="ARM_PLKAN_NUMBER")
	private String arm_plkan_number; 

	@Column(name="CREATION_DATETIME")
	private String creation_datetime;

	@Column(name="SOA_PROXY_TRANS_ID")
	private String soa_proxy_trans_id;
	
	@Column(name="SEC_MAN_TRANS_ID")
	private String sec_man_trans_id;
	
	@Column(name="CSP_TRANS_ID")
	private String csp_trans_id;
	
	@Column(name="POOL_STATUS")
	private String pool_status;

	@Column(name="FACE_AMOUNT")
	private String face_amount;
	
	@Column(name="POOLING_LOAN_UPB")
	private String pooling_loan_upb;
	
	@Column(name="CREATED_DATE")
	private String created_date;
	
	@Column(name="MODIFIED_DATE")
	private String modified_date;

	public String getPool_number() {
		return pool_number;
	}

	public void setPool_number(String pool_number) {
		this.pool_number = pool_number;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public String getInitial_disclosure_date() {
		return initial_disclosure_date;
	}

	public void setInitial_disclosure_date(String initial_disclosure_date) {
		this.initial_disclosure_date = initial_disclosure_date;
	}

	public String getFinal_disclosure_date() {
		return final_disclosure_date;
	}

	public void setFinal_disclosure_date(String final_disclosure_date) {
		this.final_disclosure_date = final_disclosure_date;
	}

	public String getPlanned_settlement() {
		return planned_settlement;
	}

	public void setPlanned_settlement(String planned_settlement) {
		this.planned_settlement = planned_settlement;
	}

	public String getMl_flag() {
		return ml_flag;
	}

	public void setMl_flag(String ml_flag) {
		this.ml_flag = ml_flag;
	}

	public String getMarket_pool_flag() {
		return market_pool_flag;
	}

	public void setMarket_pool_flag(String market_pool_flag) {
		this.market_pool_flag = market_pool_flag;
	}

	public String getMl_giant_pool_number() {
		return ml_giant_pool_number;
	}

	public void setMl_giant_pool_number(String ml_giant_pool_number) {
		this.ml_giant_pool_number = ml_giant_pool_number;
	}

	public String getArm_index_code() {
		return arm_index_code;
	}

	public void setArm_index_code(String arm_index_code) {
		this.arm_index_code = arm_index_code;
	}

	public String getArm_plkan_number() {
		return arm_plkan_number;
	}

	public void setArm_plkan_number(String arm_plkan_number) {
		this.arm_plkan_number = arm_plkan_number;
	}

	public String getCreation_datetime() {
		return creation_datetime;
	}

	public void setCreation_datetime(String creation_datetime) {
		this.creation_datetime = creation_datetime;
	}

	public String getSoa_proxy_trans_id() {
		return soa_proxy_trans_id;
	}

	public void setSoa_proxy_trans_id(String soa_proxy_trans_id) {
		this.soa_proxy_trans_id = soa_proxy_trans_id;
	}

	public String getSec_man_trans_id() {
		return sec_man_trans_id;
	}

	public void setSec_man_trans_id(String sec_man_trans_id) {
		this.sec_man_trans_id = sec_man_trans_id;
	}

	public String getCsp_trans_id() {
		return csp_trans_id;
	}

	public void setCsp_trans_id(String csp_trans_id) {
		this.csp_trans_id = csp_trans_id;
	}

	public String getPool_status() {
		return pool_status;
	}

	public void setPool_status(String pool_status) {
		this.pool_status = pool_status;
	}

	public String getFace_amount() {
		return face_amount;
	}

	public void setFace_amount(String face_amount) {
		this.face_amount = face_amount;
	}

	public String getPooling_loan_upb() {
		return pooling_loan_upb;
	}

	public void setPooling_loan_upb(String pooling_loan_upb) {
		this.pooling_loan_upb = pooling_loan_upb;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public Long getPool_id() {
		return pool_id;
	}

	public void setPool_id(Long pool_id) {
		this.pool_id = pool_id;
	}


	
}