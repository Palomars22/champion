package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Champion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String name;
		int life, armor, damage;

		System.out.println("____________________________________________");
		System.out.println("Digite os dados do primeiro campeão:");
		System.out.println("--------------------------------------");
		System.out.println("Nome :");
		name = sc.next();
		System.out.println("Vida inicial :");
		life = sc.nextInt();
		System.out.println("Dano :");
		damage = sc.nextInt();
		System.out.println("Armadura : ");
		armor = sc.nextInt();
		Champion c1 = new Champion(name, life, damage, armor);

		System.out.println("____________________________________________");
		System.out.println("Digite os dados do segundo campeão:");
		System.out.println("--------------------------------------");
		System.out.println("Nome :");
		name = sc.next();
		System.out.println("Vida inicial :");
		life = sc.nextInt();
		System.out.println("Dano :");
		damage = sc.nextInt();
		System.out.println("Armadura : ");
		armor = sc.nextInt();
		Champion c2 = new Champion(name, life, damage, armor);

		System.out.println("____________________________________________");
		System.out.println("Quantos turnos você deseja executar?");
		int qtd = sc.nextInt();
//		Champion c1 = new Champion("DARIOS", 50, 8, 1);
//		Champion c2 = new Champion("FIORA", 40, 10, 2);
//	Champion c2 = new Champion("FIORA",40, 30, 10);
//	Champion c2 = new Champion("FIORA",60, 20, 2);

		int soma = 0, soma2 = 0;
		if (qtd > 1) {
			System.out.println("********************************");
			System.out.println("       INICIO DO COMBATE        ");
			System.out.println("********************************");
			for (int i = 1; i < qtd; i++) {

				System.out.println("       Resultados dos turnos       ");
				System.out.println("________________________________");
				c1.takeDamage(c2);
				c2.takeDamage(c1);

				System.out.println("________________________________");
				if (qtd > 1) {

					for (int j = 1; j < qtd; j++) {
						soma = c1.getLife() - c2.getAttack() + c1.getArmor();
						soma2 = c2.getLife() - c1.getAttack() + c2.getArmor();
						c1.setLife(soma);
						c2.setLife(soma2);
						if (soma > 0 && soma2 > 0) {
							if (c1.getArmor() > c2.getAttack()) {
								c1.setArmor(0);
								c1.setAttack(1);
							}
							if (c2.getArmor() > c1.getAttack()) {
								c1.setArmor(0);
								c1.setAttack(1);
							}
							System.out.println("________________________________");
							c1.takeDamage(c2);
							c2.takeDamage(c1);
							System.out.println("________________________________");
						}
					}

					qtd--;
				}
				qtd--;
			}
		} else {
			System.out.println("********************************");
			System.out.println("SEM TURNOS");
			System.out.println("********************************");
		}
		System.out.println("________________________________");
		System.out.println("total de Damages");
		System.out.println("________________________________");
		System.out.println(c1.status());
		System.out.println(c2.status());
		c2.status();
		System.out.println("********************************");
		System.out.println("       FIM DE COMBATE           ");
		System.out.println("********************************");
	}

}
