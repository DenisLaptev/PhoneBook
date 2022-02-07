package com.nx.simple_task_2;

import com.nx.simple_task_2.package_a.MyListManager;
import com.nx.simple_task_2.package_a.SorterInterf;
import com.nx.simple_task_2.package_b.SorterCustom;


public class Application {

    public static void main(String[] args) {

        SorterInterf sorterInterf = new SorterCustom();

        MyListManager myListManager = new MyListManager();
        myListManager.manageMyList(sorterInterf);
    }
}
