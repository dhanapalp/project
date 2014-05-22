/*
 * Copyright 2009-2011 Prime Technology.
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
package com.hex.fre.qrm.csp.datamodel;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

import com.frd.hex.csp.finalpool.model.MasterPoolData;

public class PoolDataModel extends ListDataModel<MasterPoolData> implements SelectableDataModel<MasterPoolData>, Serializable {  

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PoolDataModel() {
    }

    public PoolDataModel(List<MasterPoolData> data) {
        super(data);
    }
    
    @Override
    public MasterPoolData getRowData(String rowKey) {
        
        List<MasterPoolData> cars = (List<MasterPoolData>) getWrappedData();
        
        for(MasterPoolData car : cars) {
            if(car.getPool_number().equals(rowKey))
                return car;
        }
        
        return null;
    }

    @Override
    public Object getRowKey(MasterPoolData car) {
        return car.getPool_number();
    }
    
}
