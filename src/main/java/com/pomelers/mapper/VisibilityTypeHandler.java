package com.pomelers.mapper;

import org.apache.ibatis.type.MappedTypes;
import com.pomelers.domain.kbn.Visibility;

@MappedTypes(Visibility.class)
public class VisibilityTypeHandler extends AbstractEnumTypeHandler<Visibility> {

    public VisibilityTypeHandler() {
        super(Visibility.class);
    }

}
