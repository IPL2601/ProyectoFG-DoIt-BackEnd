package com.doit.CRUD.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doit.CRUD.Model.Usuario;
import com.doit.CRUD.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public ArrayList<Usuario> getUsers() {
		return (ArrayList<Usuario>) usuarioRepository.findAll();
	}

	public Optional<Usuario> getUser(Integer id) {
		return usuarioRepository.findById(id);
	}

	public Usuario saveUser(Usuario user) {
		return usuarioRepository.save(user);
	}

	public Usuario regUser(Integer id) {
		Usuario userModificado = usuarioRepository.findById(id).orElse(null);
		userModificado.setUSU_REG(true);
		return userModificado;
	}

	public Usuario unRegUser(Integer id) {
		Usuario userModificado = usuarioRepository.findById(id).orElse(null);
		userModificado.setUSU_REG(false);
		return userModificado;
	}

}
