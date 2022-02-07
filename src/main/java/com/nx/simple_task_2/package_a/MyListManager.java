package com.nx.simple_task_2.package_a;

import java.util.ArrayList;
import java.util.List;


//ComponentA
public class MyListManager {

    public void manageMyList(SorterInterf sorterInterf){
        List<String> list = new ArrayList<>();
        sorterInterf.sort(list);
    }

}
