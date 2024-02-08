package com.BackendTask.IdentityReconciliation.Data;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class contactData {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "linkedId")
    private int linkedId;
    @Column(name = "linkPrecedence")
    private String linkPrecedence;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "updatedAt")
    private Date updatedAt;

    public contactData(int id, String phoneNumber, String email, int linkedId, String linkPrecedence, Date createdAt, Date updatedAt, Date deletedAt) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.linkedId = linkedId;
        this.linkPrecedence = linkPrecedence;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    @Column(name = "deletedAt")
    private Date deletedAt;

    public contactData(int id, String email, String phone, Date createdAt) {
        this.id = id;
        this.phoneNumber = phone;
        this.email = email;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLinkedId() {
        return linkedId;
    }

    public void setLinkedId(int linkedId) {
        this.linkedId = linkedId;
    }

    public String getLinkPrecedence() {
        return linkPrecedence;
    }

    public void setLinkPrecedence(String linkPrecedence) {
        this.linkPrecedence = linkPrecedence;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

}
