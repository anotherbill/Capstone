/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.interfaces;

import com.google.visualization.datasource.datatable.DataTable;

/**
 *
 * @author apprentice
 */
public interface ReportInterface {
    
    public DataTable usageReport();
    
    public DataTable assetDamageReport();
    
    //any other reports get defined here
}
