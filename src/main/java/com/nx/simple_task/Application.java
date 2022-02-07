package com.nx.simple_task;

import com.nx.simple_task.package_a.ComponentA;
import com.nx.simple_task.package_b.ComponentB;

/**
 * @author Denys Laptiev
 * Date: 12/27/2021
 */
public class Application {

    public static void main(String[] args) {
        ComponentA componentA = new ComponentA();
        ComponentB componentB = new ComponentB();
        componentA.doWork(componentB);
    }
}
