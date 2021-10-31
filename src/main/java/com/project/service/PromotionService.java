package com.project.service;

import com.project.model.BaseResponse;
import com.project.model.entity.Promotion;
import com.project.model.request.PromotionRequest;
import com.project.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    public Object getAll(){
      return   promotionRepository.getAll();
    }
    public Object addPromotion(PromotionRequest request){
        List<Promotion> promotionList=promotionRepository.addPromotion(
                request.getDescription()
        );
        if (promotionList.size()>0){
            return new BaseResponse(400,"NOT SUCCESS");
        }else {
            Promotion promotion=new Promotion();
            promotion.setApply(request.getApply());
            promotion.setDescriptions(request.getDescription());
            promotion=promotionRepository.save(promotion);
            return new BaseResponse(BaseResponse.SUCCESS,"SUCCESs",promotion);
        }

    }
}
