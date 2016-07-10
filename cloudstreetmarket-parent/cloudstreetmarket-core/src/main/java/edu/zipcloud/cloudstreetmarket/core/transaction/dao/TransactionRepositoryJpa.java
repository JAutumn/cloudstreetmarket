package edu.zipcloud.cloudstreetmarket.core.transaction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.zipcloud.cloudstreetmarket.core.transaction.entity.Transaction;

public interface TransactionRepositoryJpa extends JpaRepository<Transaction, Integer> {

    List<Transaction> findAll();

}
