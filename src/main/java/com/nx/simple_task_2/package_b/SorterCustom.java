package com.nx.simple_task_2.package_b;

import com.nx.simple_task_2.package_a.SorterInterf;

import java.util.List;


//i.e. class ComponentB implements ComponentAInterf
public class SorterCustom implements SorterInterf {

    @Override
    public void sort(List<String> list) {
        System.out.println("method sort of SorterCustom");
    }
}
