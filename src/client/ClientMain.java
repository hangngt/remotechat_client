package client;

import controller.ClientController;

public class ClientMain {
	public static void main(String[] args) {
		ClientController clientcontroll = new ClientController();
		clientcontroll.start();
	}
}
