package test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import comparators.SearchByAgeAndCity;
import comparators.SearchByEmail;
import comparators.SearchByName;
import datastructures.ListaEncadeada;
import model.Aluno;

public class ProgramaC_Alunos {

	private static final String name = "Patricia Johnston";
	private static final String email = "fergusonburgess@norsup.com";
	private static final int idade = 39;
	private static final String cidade = "Brazos";
	
	public static void main(String[] args) {
		FileReader arquivo = null;
		try {
			arquivo = new FileReader("data/alunos.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile(arquivo);
		Aluno busca = new Aluno(name, email, idade, cidade);
		
		
		
		System.out.println(lista.search(busca, new SearchByName()));
		System.out.println(lista.search(busca, new SearchByEmail()));
		System.out.println(lista.search(busca, new SearchByAgeAndCity()));
	}

}
