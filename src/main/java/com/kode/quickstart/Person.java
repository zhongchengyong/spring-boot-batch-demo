package com.kode.quickstart;

import lombok.Data;

import java.io.Serializable;

/**
 * Person实体类
 * Created by kodezhong on 2017/4/11.
 */
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = 368759655967340287L;

    private String firstName;

    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
