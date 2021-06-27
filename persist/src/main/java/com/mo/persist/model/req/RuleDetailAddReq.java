package com.mo.persist.model.req;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.NotNull;

@Data
@Builder
@GroupSequenceProvider(RuleAddReqGroupSequenceProvider.class)
public class RuleDetailAddReq {
    @NotNull(message = "rewardType can not be null")
    @Range(min = 1,max = 2,message = "rewardType only can be 1 or 2")
    private Integer rewardType;

    @NotNull(groups = {GroupOnRewardType1.class}, message = "when rewardType is 1,cashValue can not be null")
    private Integer cashValue;

    @NotNull(groups = {GroupOnRewardType2.class}, message = "when rewardType is 2,couponValue can not be null")
    private Integer couponValue;

    public interface GroupOnRewardType1{}
    public interface GroupOnRewardType2{}
}
