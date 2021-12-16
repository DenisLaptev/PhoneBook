package com.nx.phone_book.data.ui_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Denys Laptiev
 * Date: 12/14/2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneModel {

    private Long id;
    private String number;
    private String userName;
}
