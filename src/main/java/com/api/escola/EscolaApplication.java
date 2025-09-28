package com.api.escola;

import com.api.escola.model.*;
import com.api.escola.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@SpringBootApplication
public class EscolaApplication implements CommandLineRunner {

	private final AlunoRepository alunoRepository;
	private final ProfessorRepository professorRepository;
	private final TurmaRepository turmaRepository;
	private final InscricaoRepository inscricaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Professores
		Professor prof1 = professorRepository.save(new Professor(
				null, "Carlos Ribeiro", "carlos@email.com", null));
		Professor prof2 = professorRepository.save(new Professor(
				null, "Maria Oliveira", "maria@email.com", null));

		// Turmas
		Turma turma1 = turmaRepository.save(new Turma(
				null, 2025, "Matutino", prof1, null));
		Turma turma2 = turmaRepository.save(new Turma(
				null, 2025, "Noturno", prof2, null));

		// Alunos
		Aluno aluno1 = alunoRepository.save(new Aluno(
				null, "João Silva", "joao@email.com", null));
		Aluno aluno2 = alunoRepository.save(new Aluno(
				null, "Ana Souza", "ana@email.com", null));
		Aluno aluno3 = alunoRepository.save(new Aluno(
				null, "Pedro Santos", "pedro@email.com", null));

		// Inscrições
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno1, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno2, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno2, turma2));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno3, turma2));

		System.out.println("Banco populado com dados iniciais de Alunos, Professores, Turmas e Inscrições!");
	}
}