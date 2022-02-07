package com.nx.phone_book.data.ui_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Denys Laptiev
 * Date: 1/18/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    private Long id;
    private String number;

    private String userName;
    private Long userId;
}
