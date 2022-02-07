package com.nx.simple_task.package_a;

import com.nx.simple_task.package_b.ComponentB;

/**
 * @author Denys Laptiev
 * Date: 12/27/2021
 */
public class ComponentA {

    public void doWork(ComponentB task){
        task.doWorkUnit();
    }
}
