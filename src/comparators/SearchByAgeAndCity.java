package comparators;

import java.util.Comparator;

import model.Aluno;

public class SearchByAgeAndCity implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		 if(o1.getCity().equals(o2.getCity()) && o1.getAge() == o2.getAge()){
	            return 0;
	        }
	        return 1;
	}

}
