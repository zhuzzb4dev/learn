package com.mo.persist.model.req;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RuleAddReqGroupSequenceProvider implements DefaultGroupSequenceProvider<RuleDetailAddReq> {
    @Override
    public List<Class<?>> getValidationGroups(RuleDetailAddReq ruleDetailAddReq) {
        List<Class<?>> defaultGroupSequence = new ArrayList<>();
        defaultGroupSequence.add(RuleDetailAddReq.class);
        if (Objects.nonNull(ruleDetailAddReq)) {
            Integer rewardType = ruleDetailAddReq.getRewardType();
            if (Integer.valueOf(1).equals(rewardType)){
                defaultGroupSequence.add(RuleDetailAddReq.GroupOnRewardType1.class);
            } else if (Integer.valueOf(2).equals(rewardType)) {
                defaultGroupSequence.add(RuleDetailAddReq.GroupOnRewardType2.class);
            }
        }
        return defaultGroupSequence;
    }
}
