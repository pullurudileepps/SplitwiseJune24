package com.example.SplitwiseJune24.Strategy;

import com.example.SplitwiseJune24.Model.Transaction;
import com.example.SplitwiseJune24.Model.User;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@Component
public class TwoHeadSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUp(Map<User, Double> userTotal) {
        PriorityQueue<Pair<User, Double>> maxHeap = new PriorityQueue<>((a, b) -> (int) (a.getSecond() - b.getSecond()));
        PriorityQueue<Pair<User, Double>> minHeap = new PriorityQueue<>((a, b) -> (int) (b.getSecond() - a.getSecond()));
        for (Map.Entry<User, Double> entry : userTotal.entrySet()) {
            if (entry.getValue() > 0) {
                maxHeap.add(Pair.of(entry.getKey(), entry.getValue()));
            } else {
                minHeap.add(Pair.of(entry.getKey(), entry.getValue()));
            }
        }
        List<Transaction> transactions = new ArrayList<>();
        while (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            Pair<User, Double> userToGetMoney = maxHeap.poll();
            Pair<User, Double> userToPay = minHeap.poll();
            double amountToBeTransferred = Math.min(Math.abs(userToPay.getSecond()), userToGetMoney.getSecond());

            Transaction transaction = new Transaction();
            transaction.setAmount(amountToBeTransferred);
            transaction.setPaidFrom(userToPay.getFirst());
            transaction.setPaidTo(userToGetMoney.getFirst());
            transactions.add(transaction);
            if (userToPay.getSecond() - amountToBeTransferred > 0) {
                maxHeap.add(Pair.of(userToPay.getFirst(), userToPay.getSecond() - amountToBeTransferred));
            }
            if (userToGetMoney.getSecond() + amountToBeTransferred < 0) {
                minHeap.add(Pair.of(userToGetMoney.getFirst(), userToGetMoney.getSecond() + amountToBeTransferred));
            }
        }
        return transactions;
    }
}
