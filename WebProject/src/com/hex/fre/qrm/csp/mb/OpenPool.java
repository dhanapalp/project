/*
 * Copyright 2009 Prime Technology.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hex.fre.qrm.csp.mb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

@ManagedBean
public class OpenPool {

	private String poolNumber;
	private String coupon;
	private String initialPublicDate;
	private String finalPublicDate;
	private String plannedSettlementDate;
	private String multiLenderDisclosureFlag;
	private String marketPoolFlag;
	private String multiLenderGiantPoolNumber;
	private String armIndexCode;
	private String armPlanNumber;
	private String creationDateTime;
	private String status;
	
	public OpenPool() {
		super();
	}

	public OpenPool(String poolNumber, String coupon, String initialPublicDate,
			String finalPublicDate, String plannedSettlementDate,
			String multiLenderDisclosureFlag, String marketPoolFlag,
			String multiLenderGiantPoolNumber, String armIndexCode,
			String armPlanNumber, String creationDateTime, String status) {
		super();
		this.poolNumber = poolNumber;
		this.coupon = coupon;
		this.initialPublicDate = initialPublicDate;
		this.finalPublicDate = finalPublicDate;
		this.plannedSettlementDate = plannedSettlementDate;
		this.multiLenderDisclosureFlag = multiLenderDisclosureFlag;
		this.marketPoolFlag = marketPoolFlag;
		this.multiLenderGiantPoolNumber = multiLenderGiantPoolNumber;
		this.armIndexCode = armIndexCode;
		this.armPlanNumber = armPlanNumber;
		this.creationDateTime = creationDateTime;
		this.status = status;
	}

	public String getPoolNumber() {
		return poolNumber;
	}

	public void setPoolNumber(String poolNumber) {
		this.poolNumber = poolNumber;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getInitialPublicDate() {
		return initialPublicDate;
	}

	public void setInitialPublicDate(String initialPublicDate) {
		this.initialPublicDate = initialPublicDate;
	}

	public String getFinalPublicDate() {
		return finalPublicDate;
	}

	public void setFinalPublicDate(String finalPublicDate) {
		this.finalPublicDate = finalPublicDate;
	}

	public String getPlannedSettlementDate() {
		return plannedSettlementDate;
	}

	public void setPlannedSettlementDate(String plannedSettlementDate) {
		this.plannedSettlementDate = plannedSettlementDate;
	}

	public String getMultiLenderDisclosureFlag() {
		return multiLenderDisclosureFlag;
	}

	public void setMultiLenderDisclosureFlag(String multiLenderDisclosureFlag) {
		this.multiLenderDisclosureFlag = multiLenderDisclosureFlag;
	}

	public String getMarketPoolFlag() {
		return marketPoolFlag;
	}

	public void setMarketPoolFlag(String marketPoolFlag) {
		this.marketPoolFlag = marketPoolFlag;
	}

	public String getMultiLenderGiantPoolNumber() {
		return multiLenderGiantPoolNumber;
	}

	public void setMultiLenderGiantPoolNumber(String multiLenderGiantPoolNumber) {
		this.multiLenderGiantPoolNumber = multiLenderGiantPoolNumber;
	}

	public String getArmIndexCode() {
		return armIndexCode;
	}

	public void setArmIndexCode(String armIndexCode) {
		this.armIndexCode = armIndexCode;
	}

	public String getArmPlanNumber() {
		return armPlanNumber;
	}

	public void setArmPlanNumber(String armPlanNumber) {
		this.armPlanNumber = armPlanNumber;
	}

	public String getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
