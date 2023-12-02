package com.example.demo3.Conversations;

import com.example.demo3.Exceptions.ProductNotFoundException;
import com.example.demo3.Product.Product;
import com.example.demo3.Product.ProductRepo;
import com.example.demo3.User.BBuser;
import com.example.demo3.User.BBuserRepo;
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
    @Autowired
    private final BBuserRepo userRepo;

    public ConversationsService(ProductRepo productRepo, ConversationsRepo conversationsRepo, BBuserRepo userRepo) {
        this.productRepo = productRepo;
        this.conversationsRepo = conversationsRepo;
        this.userRepo = userRepo;
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
            Optional<BBuser> seller = userRepo.findById(sellId);
            Optional<BBuser> buyer = userRepo.findById(buyerId);

            newConvo.setPid(pid);
            newConvo.setBuyerId(buyerId);
            newConvo.setSellid(sellId);
            newConvo.setProductName(productOptional.get().getName());
            String sellUsername = userRepo.findUsernameById(sellId);
            String buyUsername = userRepo.findUsernameById(buyerId);
            newConvo.setSellUsername(sellUsername);
            newConvo.setBuyerUsername(buyUsername);

            conversationsRepo.save(newConvo);
            return newConvo.getId();
        }
    }

    public List<Conversations> getConversations(long uid) {
        return conversationsRepo.findBySellidOrBuyerId(uid,uid);
    }
}
