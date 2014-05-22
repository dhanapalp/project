/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hex.fre.qrm.csp.mb;

import java.util.Comparator;
import org.primefaces.model.SortOrder;

public class LazySorter implements Comparator<OpenPool> {

    private String sortField;
    
    private SortOrder sortOrder;
    
    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public int compare(OpenPool OpenPool1, OpenPool OpenPool2) {
        try {
            Object value1 = OpenPool.class.getField(this.sortField).get(OpenPool1);
            Object value2 = OpenPool.class.getField(this.sortField).get(OpenPool2);

            int value = ((Comparable)value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
