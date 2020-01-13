package com.pomelers.domain.model.validator;

import javax.validation.GroupSequence;
import com.pomelers.domain.model.validator.ValidationGroups.Attribute;
import com.pomelers.domain.model.validator.ValidationGroups.Relation;

@GroupSequence({Attribute.class, Relation.class})
public interface ValidationGroups {

    public interface Attribute {
    }
    public interface Relation {
    }

}
