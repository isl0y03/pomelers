package com.pomelers.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import com.pomelers.domain.kbn.Visibility;

@MappedTypes(Visibility.class)
public class VisibilityTypeHandler extends EnumTypeHandler<Visibility> {

    public VisibilityTypeHandler() {
        super(Visibility.class);
    }

    @Override
    public void setNonNullParameter(final PreparedStatement ps, final int i, final Visibility parameter,
            final JdbcType jdbcType)
            throws SQLException {
        if (jdbcType == null) {
            ps.setString(i, parameter.toString());
        } else {
            ps.setObject(i, parameter.toString(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public Visibility getNullableResult(final ResultSet rs, final String columnName) throws SQLException {
        final String s = rs.getString(columnName);
        return s == null ? null : Visibility.toEnum(s);
    }

    @Override
    public Visibility getNullableResult(final ResultSet rs, final int columnIndex) throws SQLException {
        final String s = rs.getString(columnIndex);
        return s == null ? null : Visibility.toEnum(s);
    }

    @Override
    public Visibility getNullableResult(final CallableStatement cs, final int columnIndex) throws SQLException {
        final String s = cs.getString(columnIndex);
        return s == null ? null : Visibility.toEnum(s);
    }

}
