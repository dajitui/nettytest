package com.dream.springbootframe.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

/**
 *
 */
public class BaseImpl<E> implements Base<E> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    private static Class TABLE_NAME = TableName.class;
    private static Class COLUMN_NAME = ColumnName.class;
    private static String GET = "get";
    private static String INSERT_INTO = "insert into ";
    private static String LEFT_BRACKET = "(";
    private static String RIGHT_BRACKET = ")";
    private static String COMMA = ",";
    private static String ID = "id";
    private static String QUESTION = "?";
    public static String VALUES = " values";
    public static String SQL = "sql";

    public int save(E e) {
        Class clazz = e.getClass();
        if (clazz.isAnnotationPresent(TABLE_NAME)) {
            String table = ((TableName)clazz.getAnnotation(TABLE_NAME)).value();
            StringBuffer front = new StringBuffer(INSERT_INTO + table + LEFT_BRACKET);
            StringBuffer back = new StringBuffer(VALUES + LEFT_BRACKET);
            List<Object> columnValue = new ArrayList<>();
            Arrays.asList(clazz.getDeclaredFields()).forEach(f -> {
                if (f.isAnnotationPresent(COLUMN_NAME)) {
                    front.append(((ColumnName)f.getAnnotation(COLUMN_NAME)).value()).append(COMMA);
                    back.append(QUESTION).append(COMMA);
                    try {
                        columnValue.add(clazz.getMethod(GET + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1)).invoke(e));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            front.deleteCharAt(front.length() - 1).append(RIGHT_BRACKET).append(back.deleteCharAt(back.length() - 1).append(RIGHT_BRACKET));

            return jdbcTemplate.update(front.toString(), columnValue.toArray());
        }


        return 0;
    }





}
