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
	private final DisciplinaRepository disciplinaRepository;

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Disciplinas
		Disciplina discDW = disciplinaRepository.save(
				new Disciplina(null, "Desenvolvimento Web", 80, null)
		);
		Disciplina discBd1 = disciplinaRepository.save(
				new Disciplina(null, "Banco de Dados", 60, null)
		);
		Disciplina discBd2 = disciplinaRepository.save(
				new Disciplina(null, "Banco de Dados 2", 60, null)
		);

		// Professores
		Professor prof1 = professorRepository.save(new Professor(
				null, "Carlos Ribeiro", "carlos@email.com", null));
		Professor prof2 = professorRepository.save(new Professor(
				null, "Daniel Oliveira", "daniel@email.com", null));

		// Turmas
		Turma turma1 = turmaRepository.save(new Turma(null, 2025, "Matutino", prof1, null, discDW));
		Turma turma2 = turmaRepository.save(new Turma(null, 2025, "Noturno", prof1, null, discDW));
		Turma turma3 = turmaRepository.save(new Turma(null, 2025, "Matutino",  prof2, null, discBd1));
		Turma turma4 = turmaRepository.save(new Turma(null, 2025, "Noturno",  prof2, null, discBd1));
		Turma turma5 = turmaRepository.save(new Turma(null, 2025, "Matutino",  prof2, null, discBd2));
		Turma turma6 = turmaRepository.save(new Turma(null, 2025, "Matutino",  prof2, null, discBd2));

		// Alunos
		Aluno aluno1 = alunoRepository.save(new Aluno(
				null, "Juliana Moura", "juliana@email.com", null));
		Aluno aluno2 = alunoRepository.save(new Aluno(
				null, "Leon Rabello", "leon@email.com", null));
		Aluno aluno3 = alunoRepository.save(new Aluno(
				null, "Leonardo Brasil", "leonardo@email.com", null));
		Aluno aluno4 = alunoRepository.save(new Aluno(
				null, "Lucas Duarte", "lucas@email.com", null));
		Aluno aluno5 = alunoRepository.save(new Aluno(
				null, "Maria Julia Amancio", "maria@email.com", null));
		Aluno aluno6 = alunoRepository.save(new Aluno(
				null, "Matheus Maia", "matheus@email.com", null));
		Aluno aluno7 = alunoRepository.save(new Aluno(
				null, "Maisa Martins", "maisa@email.com", null));
		Aluno aluno8 = alunoRepository.save(new Aluno(
				null, "Pedro Guedes", "pedro@email.com", null));
		Aluno aluno9 = alunoRepository.save(new Aluno(
				null, "Rafael Alves", "rafael@email.com", null));
		Aluno aluno10 = alunoRepository.save(new Aluno(
				null, "Renan Gomes", "renan@email.com", null));
		Aluno aluno11 = alunoRepository.save(new Aluno(
				null, "Rodrigo Joao", "rodrigo@email.com", null));
		Aluno aluno12 = alunoRepository.save(new Aluno(
				null, "Thiago Rocha", "thiago@email.com", null));
		Aluno aluno13 = alunoRepository.save(new Aluno(
				null, "Victor Teles", "victor@email.com", null));
		Aluno aluno14 = alunoRepository.save(new Aluno(
				null, "Davi Ferreira", "davi@email.com", null));
		Aluno aluno15 = alunoRepository.save(new Aluno(
				null, "Gabriel Cota", "gabriel@email.com", null));

		// Inscrições
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno1, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno2, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno3, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno4, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno5, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno6, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno7, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno8, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno9, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno10, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno11, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno12, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno13, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno14, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno15, turma1));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno1, turma2));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno2, turma2));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno1, turma3));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno2, turma3));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno1, turma4));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno2, turma4));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno1, turma5));
		inscricaoRepository.save(new Inscricao(null, LocalDateTime.now(), aluno2, turma5));

		System.out.println("Banco populado com dados iniciais de Alunos, Professores, Turmas, Inscrições, e Disciplinas.");
	}
}