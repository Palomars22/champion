package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Champion {

	private String name;
	private int life, attack, armor;
	List<Integer> list = new ArrayList<>();
	List<Champion> list1 = new ArrayList<>();

	public Champion(String name, int life, int attack, int armor) {
		super();
		this.name = name;
		this.life = life;
		this.attack = attack;
		this.armor = armor;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public Champion() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	

	public void Champion(String name, int life, int attack, int armor) {
		int combate = 0;
		if (armor > attack) {
			attack = 1;
			armor = 0;
		combate=life-attack;
			
		}else {
			
			combate = life + armor - attack;
		}
		
			if(combate>0) {
				System.out.println(name + " :" + combate + " de vidas");
			}
		if(combate<=0) {

			combate = 0;
			System.out.println(name + " :" + combate + " de vidas (morreu)");
		}
		list.add(combate);
//		life=combate;

	}

	public void takeDamage(Champion other) {
		if (armor > other.attack) {
			other.setAttack(1);
			armor=0;
			Champion(name, life, other.attack, armor);

		} else {
			Champion(name, life, other.attack, armor);
		}
	}

	public String status() {
	
//	Stream<Champion>resultado=list1.stream().map(t ->t.Champion(name, life, attack, armor));
		Optional<Integer> situacao = list.stream().min((o1, o2) -> o1);

		String s = "";
		s="Nome :"+name;
		s="situacao de vida :"+situacao;
		
		
		return s;
	}

	@Override
	public String toString() {
		return "Champion [ name=" + name + ", life=" + life + "] \n";
	}

}
