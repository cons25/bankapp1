package com.company1.bankapp1.controllers;

import com.company1.bankapp1.core.exceptions.NotYetImplementedException;


public class CommandHandler {


	public static final String COMMAND_CREATE_USER = "create-user";
	public static final String COMMAND_UPDATE_USER = "update-user";
	public static final String COMMAND_DELETE_USER = "delete-user";

	public static void handleCommand(String[] args) {

		String command = identifyCommand(args);
		String[] data = identifyData(args);
		switch (command) {
			case COMMAND_CREATE_USER:
				handleCreateUser(data);
				break;
			case COMMAND_UPDATE_USER:
				handleUpdateUser(data);
				break;
			case COMMAND_DELETE_USER:
				handleDeleteUser(data);
				break;
			default:
				throw new NotYetImplementedException();
		}


	}

	private static String identifyCommand(String[] args) {
		// temporary plug-in
		return COMMAND_CREATE_USER;
	}

	private static String[] identifyData(String[] args) {
		// temporary plug-in
		return new String[] {"abc", "def", "jcf"};
	}



	private static void handleCreateUser(String[] data) {

	}


	private static void handleUpdateUser(String[] data) {

	}

	private static void handleDeleteUser(String[] data) {

	}


}
