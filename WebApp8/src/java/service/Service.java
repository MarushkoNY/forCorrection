/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import service.Data;

/**
 *
 * @author Nikolay
 */

public interface Service {
    
    public Data getData();
    public void storeData(Data data);
}
