package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Compte;
import model.Equipage;

public class DAOCompte implements IDAO<Compte,Integer>{
	public Compte findById(Integer id) {
		return null;
	}

	public Compte findByLoginAndPassword(String login, String password){
		return null;
	}

	public List<Compte> findAll(){
		return null;
	}
	
	public List<Compte> findAllById(Integer id){
		return null;
	}
	
	public List<Equipage> findAllByEquipage(Integer id){
		return null;
	}
	
	public void insert(Compte o) {

	}
	public void update(Compte o) {

	}
	public void delete(Integer id) {

	}
}
