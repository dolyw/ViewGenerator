package com.uframe.generator.util;

import java.util.*;
import java.sql.*;

public class SqlExecutorHelper
{
    public static List<Map> queryForList(final Connection conn, final String sql, final int limit) throws SQLException {
        final PreparedStatement ps = conn.prepareStatement(sql.trim());
        ps.setMaxRows(limit);
        ps.setFetchDirection(1000);
        final ResultSet rs = ps.executeQuery();
        return toListMap(limit, rs);
    }
    
    public static List<Map> toListMap(final int limit, final ResultSet rs) throws SQLException {
        final ResultSetMetaData rsmd = rs.getMetaData();
        int count = 0;
        final List<Map> list = new ArrayList<Map>();
        while (rs.next()) {
            final Map row = new HashMap();
            for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                row.put(rsmd.getColumnName(i), rs.getObject(i));
            }
            list.add(row);
            if (++count >= limit) {
                break;
            }
        }
        return list;
    }
}
