package com.nx.simple_task_case2.package_b;

import com.nx.simple_task_case2.package_a.InterfaceA;


public class ComponentB implements InterfaceA {

    @Override
    public void doWorkUnit() {
        System.out.println("doWorkUnit method of ComponentB");
    }
}
