/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author Dominik
 */
@Entity
@Table(name="PURCHASE", schema="PROJEKT")
public class PurchaseDTO implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne @JoinColumn(name = "ID_CUSTOMER", referencedColumnName = "ID")
    private CustomerDTO customer;
    @OneToMany(mappedBy = "purchase", cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private List<PurchaseCarDTO> purchaseItems = new LinkedList<PurchaseCarDTO>();
    private String purchaseDate;
    private String destinationAddress;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public void addPurchaseItem(PurchaseCarDTO pi) {
        purchaseItems.add(pi);
        pi.setPurchase(this);
    }

    public List<PurchaseCarDTO> getPurchaseItems() {
        return purchaseItems;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
    
}
