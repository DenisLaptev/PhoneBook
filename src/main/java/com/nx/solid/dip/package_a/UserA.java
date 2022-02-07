package com.nx.solid.dip.package_a;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Denys Laptiev
 * Date: 12/27/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserA {

    private Long id;
    private String name;
    private List<Long> numbers;
}
