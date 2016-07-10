package edu.zipcloud.cloudstreetmarket.core.user.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import edu.zipcloud.cloudstreetmarket.core.transaction.dao.TransactionRepository;
import edu.zipcloud.cloudstreetmarket.core.transaction.entity.Transaction;
import edu.zipcloud.cloudstreetmarket.core.user.dto.UserActivityDTO;
import edu.zipcloud.cloudstreetmarket.core.user.entity.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service(value="communityServiceImpl")
public class CommunityServiceImpl implements ICommunityService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Page<UserActivityDTO> getPublicActivity(Pageable pageable) {
        List<UserActivityDTO> result = new LinkedList<>();
        Page<Transaction> transactions = transactionRepository.findAll(pageable);

        transactions.forEach(
                transaction -> result.add(
                        new UserActivityDTO(
                                transaction.getUser().getLoginName(),
                                transaction.getUser().getProfileImg(),
                                transaction.getType(),
                                transaction.getQuote().getStock().getCode(),
                                transaction.getQuantity(),
                                transaction.getType().equals(Action.BUY) ? new BigDecimal(transaction.getQuote().getAsk()) 
                                                                         : new BigDecimal(transaction.getQuote().getBid()),
                                transaction.getQuote().getDate()
                        ))
        );

        return new PageImpl<>(result, pageable, transactions.getTotalElements());
    }
}
