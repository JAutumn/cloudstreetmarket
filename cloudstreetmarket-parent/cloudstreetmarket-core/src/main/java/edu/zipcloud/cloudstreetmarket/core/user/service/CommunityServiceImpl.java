package edu.zipcloud.cloudstreetmarket.core.user.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zipcloud.cloudstreetmarket.core.transaction.dao.TransactionRepository;
import edu.zipcloud.cloudstreetmarket.core.user.dto.UserActivityDTO;
import edu.zipcloud.cloudstreetmarket.core.user.entity.Action;

@Service(value = "communityServiceImpl")
public class CommunityServiceImpl implements ICommunityService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<UserActivityDTO> getLastUserPublicActivity(int number) {

        List<UserActivityDTO> result = new LinkedList<>();
        transactionRepository.findRecentTransactions(number).forEach(
                transaction -> result.add(
                        new UserActivityDTO(
                                transaction.getUser().getLoginName(),
                                transaction.getUser().getProfileImg(),
                                transaction.getType(),
                                transaction.getQuote().getStock().getCode(),
                                transaction.getQuantity(),
                                transaction.getType().equals(Action.BUY) ?
                                        new BigDecimal(transaction.getQuote().getAsk())
                                        : new BigDecimal(transaction.getQuote().getBid()),
                                transaction.getQuote().getDate()
                        ))
        );

        return result;
    }

}
