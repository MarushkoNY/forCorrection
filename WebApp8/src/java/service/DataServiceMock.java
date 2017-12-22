/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import WSGen.Data;
import java.util.ArrayList;
import javax.inject.Qualifier;
import util.ServiceDef;

/**
 *
 * @author Nikolay
 */
@ServiceDef(mode = 2)
public class DataServiceMock implements Service{
    
    private static ArrayList<Data> dataList = new ArrayList<>();
    
    public void storeData(Data data){
        dataList.add(data);
    }
    
    public Data getData(){
        if (dataList.size() == 0){
            return new Data();
        }
        return dataList.get(dataList.size()-1);
    }
    
}
