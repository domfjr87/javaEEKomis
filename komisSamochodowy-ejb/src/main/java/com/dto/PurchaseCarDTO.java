/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Dominik
 */
@Entity
@Table(name="PURCHASE_CAR", schema="PROJEKT")
public class PurchaseCarDTO implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    @ManyToOne @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID")
    private CarDTO car;
    @ManyToOne @JoinColumn(name = "ID_PURCHASE", referencedColumnName = "ID")
    private PurchaseDTO purchase;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarDTO getProduct() {
        return car;
    }

    public void setProduct(CarDTO product) {
        this.car = product;
    }

    public PurchaseDTO getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseDTO purchase) {
        this.purchase = purchase;
    }
    
}
