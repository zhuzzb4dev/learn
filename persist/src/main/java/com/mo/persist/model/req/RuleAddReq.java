package com.mo.persist.model.req;

import com.mo.persist.group.SecondGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class RuleAddReq {

    @NotBlank(message = "规则名称不能为空")
    @Length(max = 64, message = "规则名称最长64位")
    private String ruleName;

    @NotNull(message = "规则开始时间不能为空")
    private Date startTime;

    @NotNull(message = "规则结束时间不能为空")
    private Date endTime;

    @AssertTrue(message = "规则结束时间必须大于开始时间",groups = {SecondGroup.class})
    public boolean isStartTimeBeforeEndTime() {
        return startTime.before(endTime);
    }

    @NotEmpty(message = "规则详情不能为空")
    List<@Valid RuleDetailAddReq> details;

}
