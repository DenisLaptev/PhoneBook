package com.nx.phone_book.data.ui_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Denys Laptiev
 * Date: 12/14/2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private Long id;
    private String name;
    private List<String> phones;
    private String phonesString;

    public String aggregatePhones(List<String> phones) {
        String phonesString = "";
        if (phones == null || phones.isEmpty()) {
            phonesString = Model.NO_DATA;
        }else if (phones.size() == 1) {
            phonesString = phones.get(0);
        }else {
            StringBuilder phonesStringBuilder = new StringBuilder();
            for (int i = 0; i < phones.size() - 1; i++) {
                phonesStringBuilder.append(phones.get(i)).append(", ");
            }
            phonesStringBuilder.append(phones.get(phones.size() - 1));
            phonesString = String.valueOf(phonesStringBuilder);
        }
        return phonesString;
    }
}
