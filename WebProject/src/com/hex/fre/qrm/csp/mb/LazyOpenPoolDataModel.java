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
package com.hex.fre.qrm.csp.mb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.frd.hex.csp.finalpool.model.MasterPoolData;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class LazyOpenPoolDataModel extends LazyDataModel<MasterPoolData> {
    
    private List<MasterPoolData> datasource;
    
    public LazyOpenPoolDataModel(List<MasterPoolData> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public MasterPoolData getRowData(String rowKey) {
        for(MasterPoolData masterPoolData : datasource) {
            if(masterPoolData.getPool_number().equals(rowKey))
                return masterPoolData;
        }

        return null;
    }

    @Override
    public Object getRowKey(MasterPoolData masterPoolData) {
        return masterPoolData.getPool_number();
    }

    @Override
    public List<MasterPoolData> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<MasterPoolData> data = new ArrayList<MasterPoolData>();

        //filter
        for(MasterPoolData masterPoolData : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(masterPoolData.getClass().getField(filterProperty).get(masterPoolData));

                    if(filterValue == null || fieldValue.startsWith(filterValue)) {
                        match = true;
                    }
                    else {
                        match = false;
                        break;
                    }
                } catch(Exception e) {
                    match = false;
                } 
            }

            if(match) {
                data.add(masterPoolData);
            }
        }

        //sort
/*        if(sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        }
*/
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}