package com.qa.ims.persistence.dao;

import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;

public class ItemDAO implements Dao<Item> {
public static final Logger LOGGER = LogManager.getLogger();

@Override
public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
	Long id = resultSet.getLong(0)
}
}
