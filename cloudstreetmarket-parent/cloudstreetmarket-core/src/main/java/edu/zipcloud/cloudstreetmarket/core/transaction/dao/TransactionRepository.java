package edu.zipcloud.cloudstreetmarket.core.transaction.dao;

import java.util.Date;

import edu.zipcloud.cloudstreetmarket.core.transaction.entity.Transaction;
import edu.zipcloud.cloudstreetmarket.core.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionRepository {

    Page<Transaction> findAll(Pageable pageable);
    Iterable<Transaction> findByUser(User user);
    Iterable<Transaction> findTransactions(Date from);
    Iterable<Transaction> findTransactions(int nb);

}
