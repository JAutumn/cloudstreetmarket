package edu.zipcloud.cloudstreetmarket.core.user.entity;

import edu.zipcloud.cloudstreetmarket.core.transaction.entity.Transaction;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User implements Serializable {
    private static final long serialVersionUID = 1990856213905768044L;

    @Id
    @Column(nullable = false)
    private String loginName;

    private String password;

    private String profileImg;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("id desc")
    private Set<Transaction> transactions = new LinkedHashSet<>();

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}