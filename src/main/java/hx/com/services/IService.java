package hx.com.services;

import java.util.ArrayList;

import hx.com.modle.User;


public interface IService {
	public void addUser(User user);
	public void deleteUser(String userId);
	public ArrayList<User> getAllUsers();
	public void updateUser(User user);
	public ArrayList<User> getAllUsersByName(String name);
}
