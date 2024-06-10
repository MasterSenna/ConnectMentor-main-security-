package com.connectMentor.auth.services;

import com.connectMentor.auth.Util.PasswordUtil;
import com.connectMentor.auth.domain.mentorado.Mentorado;
import com.connectMentor.auth.repositories.MentoradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentoradoService {

	@Autowired
	private MentoradoRepository repository;

	public void salvarMentorado(Mentorado mentorado) {
//		mentorado.setSenha(PasswordUtil.encode(mentorado.getSenha())); // Criptografando a senha antes de salvar
		repository.save(mentorado);
	}

	public Mentorado buscarIdMentorado(Long idMentorado) {
		Optional<Mentorado> mentorado = repository.findById(idMentorado);
		return mentorado.orElse(null);
	}

	public Mentorado buscarPorEmail(String email) {
		Optional<Mentorado> mentorado = repository.findByEmail(email);
		return mentorado.orElse(null);
	}

	public Mentorado buscarPorSenha(String senha) {
		Optional<Mentorado> mentorado = repository.findBySenha(senha);
		return mentorado.orElse(null);
	}
}
