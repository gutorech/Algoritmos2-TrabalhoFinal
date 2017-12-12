package datastructures;

import java.io.FileReader;
import java.util.Comparator;
import java.util.Scanner;
import model.Aluno;

public class ListaEncadeada<T> {
	
	public class Node { //classe Node dentro da classe ListaEncadeada
		private T dado;
		private Node next;
		private Node previous;
		
		public Node (T dado){ 
			this.dado = dado;
			this.next = next;
			this.previous = previous;
		}
		
		public void addAfter(T dado){ 
			Node novo = new Node(dado);
			Node prox = this.next;
			novo.previous = this;
			if(prox == null){
				tail = novo;
			}else{
				prox.previous = novo;
			}
			this.next = novo;
		}
		
		public void addBefore(T dado){ 
			Node novo = new Node(dado);
			Node ant = this.previous;
			novo.next = this;
			if(ant == null){
				head = novo;
			}else{
				ant.next = novo;
			}
			this.previous = novo;
		}
	}
	
	private Node head;
	private Node tail;
	
	public void append(T dado){
		Node novo = new Node(dado);
		if(tail != null){
			tail.next = novo;
		}else{
			head = novo;
		}
		novo.previous = tail;
		tail = novo;
	}
	
	public void addFirst(T dado){
		Node novo = new Node(dado);
		if(head != null){
			head.previous = novo;
		}else{
			tail = novo;
		}
		novo.next = head;
		head = novo;
	}
	
	public T search(T key, Comparator<T> cmp){
		 ListaEncadeada<T>.Node i = head;
	        while (i != null){
	        	if(cmp.compare(key, i.dado) == 0){
	                return i.dado;
	            }
	            i = i.next;
	        }
	        return null;
	}
	
	public void printObjects(){
		ListaEncadeada<T>.Node i = head;
		while (i != null){
			System.out.println(i.dado);
			i = i.next;
			}
	}
	
	public static ListaEncadeada<model.Aluno> loadFromFile(FileReader arquivo){
		Scanner s = new Scanner(arquivo);
	 	int c = 0;
	 	ListaEncadeada lista = new ListaEncadeada<Aluno>();
	 		
	 	while(s.hasNextLine()){
	 		String dados[] = s.nextLine().split(",");
	 		String id = dados[0];
	 		String name = dados[1];
	 		String email = dados[2];
	 		String age = dados[3];
	 		String gender = dados[4];
	 		String comp = dados[5];
	 		String city = dados[6];
	 		
	 		Aluno a =  new Aluno(id, name, email, age, gender, comp, city);
	 		if(c == 0){
	 			lista.addFirst(a);
	 		}else{
	 			lista.append(a);	 			
	 		}
	 		c++;
	 	}
		return lista;
	}
}
