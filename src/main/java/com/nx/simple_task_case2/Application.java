package com.nx.simple_task_case2;


import com.nx.simple_task_case2.package_a.ComponentA;
import com.nx.simple_task_case2.package_a.InterfaceA;
import com.nx.simple_task_case2.package_b.ComponentB;


public class Application {

    public static void main(String[] args) {
        ComponentA componentA = new ComponentA();
        InterfaceA componentB = new ComponentB();
        componentA.doWork(componentB);
    }
}
