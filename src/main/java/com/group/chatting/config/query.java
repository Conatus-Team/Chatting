package com.group.chatting.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class query {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // Select Many Rows
    List<Map<String, Object>> results = jdbcTemplate.queryForList("SELECT * FROM table");

    // Select One Row
    Map<String, Object> result = jdbcTemplate.queryForMap("SELECT * FROM table");

    // Select Scalar value
    int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM table", Integer.class);

    // Insert
    int insertedRows = jdbcTemplate.update("INSERT INTO test (id, title) VALUES (1, 'title')");

    // Update
    int updatedRows = jdbcTemplate.update("UPDATE test SET title='title2' WHERE id=1");

    // Delete
    int deletedRows = jdbcTemplate.update("DELETE FROM test WHERE id=1");

}
