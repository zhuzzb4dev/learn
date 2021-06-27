package com.mo.persist.group;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, SecondGroup.class, ThirdGroup.class, ForthGroup.class})
public interface CommonGroupSequence {
}
