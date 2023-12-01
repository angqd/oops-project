package com.example.demo3.Conversations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationsRepo extends JpaRepository<Conversations,Long> {

    Conversations findByPidAndBuyerId(long pid, long buyerId);
}
