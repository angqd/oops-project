package com.example.demo3.Conversations;

import com.example.demo3.Exceptions.ProductNotFoundException;
import com.example.demo3.Product.Product;
import com.example.demo3.Product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConversationsService {

    @Autowired
    private final ProductRepo productRepo;
    @Autowired
    private final ConversationsRepo conversationsRepo;

    public ConversationsService(ProductRepo productRepo, ConversationsRepo conversationsRepo) {
        this.productRepo = productRepo;
        this.conversationsRepo = conversationsRepo;
    }

    public Long newConvo(long pid, long buyerId) {
        Conversations existingConvo = conversationsRepo.findByPidAndBuyerId(pid,buyerId);
        if(existingConvo!=null){
            return existingConvo.getId();
        } else{
            Conversations newConvo = new Conversations();
            Optional<Product> productOptional = productRepo.findById(pid);
            long sellId = 0;
            if(productOptional.isPresent()){
                sellId = productOptional.get().getUid();
            }else{
                throw new ProductNotFoundException("No product foudn with pi "+pid);
            }
            newConvo.setPid(pid);
            newConvo.setBuyerId(buyerId);
            newConvo.setSellid(sellId);
            conversationsRepo.save(newConvo);
            return newConvo.getId();
        }
    }

    public List<Conversations> getConversations(long uid) {
        return conversationsRepo.findBySellidOrBuyerId(uid,uid);
    }
}
