package movies;
import java.util.ArrayList;
import java.util.Collections;

public class Actor {
	private String name;
	ArrayList<Movie> movies=new ArrayList<Movie>();

	public Actor(String name) {  
		this.name = name;
		this.movies = new ArrayList();
	}
	
	public String getName(){               //getName
		return name;
	}
		
	public boolean actedIn(Movie m){     //acted in
		int i=0;
		while(i!=this.movies.size()){
			if(this.movies.get(i)==m){
				return true;
			}
			i=i+1;
		}
		return false;
	}
	
	public void addMovie(Movie m){       //addMovie
		this.movies.add(m);
		if(!m.actors.contains(this)){
		  m.addActor(this);
	 }
}
	
	public boolean actedWith(Actor a){    //actedWith
		int i=0;
		while(i !=this.movies.size()){
			if(((Movie) this.movies.get(i)).getActors().contains(a)){
				return true;
			}
			i=i+1;
		}
		return false;
	}
	
	public boolean equals(Actor a2){    //equals 
		if (this.name.equals(a2.name)){
			if(this.movies.size()==0&&a2.movies.size()==0){
				  return true;
			  } 
			if(this.movies.equals(a2.movies)){
				  return true;
			  }
			if(this.movies.size()==a2.movies.size()){
			int i=0,j=0;
			while(i!=this.movies.size()){
				j=0;
				while(j!=a2.movies.size()){
					if(this.movies.get(i)==a2.movies.get(j)){
						break;
					}
					if(j==a2.movies.size()){
						return false;
					}
					j=j+1;
				}
				i=i+1;	
			}
			return true;
		}
			if(this.movies.size()!=a2.movies.size()){
				return false;
			}
	}
			return false;	
}
	
	public String toString(){    //toString
		String s=name+" "+"(";
		if(this.movies.size()==0){
			return name+" "+"()";
		}
		if(this.movies.size()!=0){
			s+=this.movies.get(0).getName();
			int i=1;
			while(i!=this.movies.size()){
				s+=", "+this.movies.get(i).getName();
				i=i+1;
			}
			return s+")";
			
		}
		else{
			return "Error";
		}
	}
	
	
			
}
	
