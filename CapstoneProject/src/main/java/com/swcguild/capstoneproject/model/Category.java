/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstoneproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author apprentice
 */
@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue
    @Column(name="category_id")
    private int categoryId;
    
    @Column(name="category_name")
    private String categoryName;
    
}
