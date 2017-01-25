package movies;
import java.util.ArrayList;

public class Movie{
	
	private String name;
	ArrayList<Actor> actors=new ArrayList<Actor>();
	private int year;

	public Movie(String name, int year) {
		this.name = name;
		this.year = year;
		this.actors = new ArrayList();
	}
	
	public String getName(){    //getName
		return name;
	}

	public int getYear(){      //getYear
		return year;
	}
	
	public void addActor(Actor a){  //addActor
		this.actors.add(a);	//already added a to the actor list of the Movie, now need to add the movie to its Actor's movie list
		if(!a.movies.contains(this)){
		a.addMovie(this);
		}
	}
	
	public ArrayList getActors(){   //getActor
		return actors;	
	}
	
	public boolean equals(Movie m){  //equals
		if(this.name.equals(m.name)&&this.year==m.year){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){   //toString
		String s=name+","+" "+year+System.lineSeparator();
		if(this.actors.size()==0){
			return name+","+" "+year;
		}
		if(this.actors.size()!=0){
			s+=this.actors.get(0).getName();
			int i=1;
			while(i!=this.actors.size()){
				s+=System.lineSeparator()+((Actor)this.actors.get(i)).getName();//In different class cannot use. to call the variable directly ,have to use get method.
			   i=i+1;	
			}
			return s;
		}
		else{
			return"Error";
		}
	}
}
