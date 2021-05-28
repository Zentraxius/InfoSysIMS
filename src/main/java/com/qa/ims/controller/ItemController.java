package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDao;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDao itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter a first name");
		String firstNameTemp = utils.getString();
		String firstName = firstNameTemp.substring(0,1).toUpperCase() + firstNameTemp.substring(1);
		LOGGER.info("Please enter a surname");
		String surnameTemp = utils.getString();
		String surname = surnameTemp.substring(0,1).toUpperCase() + surnameTemp.substring(1);
		LOGGER.info("Please enter the age");
		String tempAge = utils.getString();
		int itemAge = Integer.parseInt(tempAge);
		Item item = itemDAO.create(new Item(firstName, surname, itemAge));
		LOGGER.info("Item created");
		return item;
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a first name");
		String firstName = utils.getString();
		LOGGER.info("Please enter a surname");
		String surname = utils.getString();
		LOGGER.info("Please enter the age");
		String tempAge = utils.getString();
		int itemAge = Integer.parseInt(tempAge);
		Item item = itemDAO.update(new Item(id, firstName, surname, itemAge));
		LOGGER.info("Item Updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}

}
