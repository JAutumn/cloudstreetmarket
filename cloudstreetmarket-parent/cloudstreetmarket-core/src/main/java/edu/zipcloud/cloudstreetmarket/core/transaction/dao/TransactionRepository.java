package edu.zipcloud.cloudstreetmarket.core.transaction.dao;

import java.util.Date;

import edu.zipcloud.cloudstreetmarket.core.transaction.entity.Transaction;
import edu.zipcloud.cloudstreetmarket.core.user.entity.User;

public interface TransactionRepository {

    Iterable<Transaction> findAll();

    Iterable<Transaction> findByUser(User user);

    Iterable<Transaction> findRecentTransactions(Date from);

    Iterable<Transaction> findRecentTransactions(int nb);

}
