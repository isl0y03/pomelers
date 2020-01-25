package com.pomelers.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import com.pomelers.domain.kbn.EnumField;
import com.pomelers.domain.kbn.EnumFieldConvertor;

public abstract class AbstractEnumTypeHandler<T extends Enum<T> & EnumField> extends BaseTypeHandler<T> {

    private final Class<T> clazz;

    public AbstractEnumTypeHandler(final Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void setNonNullParameter(final PreparedStatement ps, final int i, final T parameter,
            final JdbcType jdbcType)
            throws SQLException {
        if (jdbcType == null) {
            ps.setString(i, parameter.value());
        } else {
            ps.setObject(i, parameter.value(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public T getNullableResult(final ResultSet rs, final String columnName) throws SQLException {
        final String s = rs.getString(columnName);
        return s == null ? null : EnumFieldConvertor.toEnum(this.clazz, s);
    }

    @Override
    public T getNullableResult(final ResultSet rs, final int columnIndex) throws SQLException {
        final String s = rs.getString(columnIndex);
        return s == null ? null : EnumFieldConvertor.toEnum(this.clazz, s);
    }

    @Override
    public T getNullableResult(final CallableStatement cs, final int columnIndex) throws SQLException {
        final String s = cs.getString(columnIndex);
        return s == null ? null : EnumFieldConvertor.toEnum(this.clazz, s);
    }

}
