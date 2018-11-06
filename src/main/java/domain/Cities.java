package domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
public class Cities implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private int id;
  @Column(name="name")
  private String name;
  @Column(name="population")
  private int population;

  public Cities() {}

  public Cities(String name, int population) {
    this.name = name;
    this.population = population;
  }
  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

  public String getCityName() {
    return name;
  }

  public int getPopulation() {
    return population;
  }
  
  public void setName(String name) {
	  this.name = name;
  }
  
  public void setPopulation(int population) {
	  this.population = population;
  }

  public String toString() {
    return "The city " + name + " has a population of: " + population;
  }
}
