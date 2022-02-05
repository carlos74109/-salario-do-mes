package Principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entidades.Departamento;
import Entidades.HoraContrato;
import Entidades.Trabalho;
import Entidades.Enums.Leveltrabalho;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre como o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println("Data do trabalho: ");
		System.out.println("Nome do trabalhador: ");
		String nomeTrabalho = sc.nextLine();
		
		System.out.println("Level: ");
		String levelTrabalho = sc.nextLine();
		System.out.println("Salario base: ");
		double baseSalario = sc.nextDouble();
		
		Trabalho trabalho = new Trabalho(nomeTrabalho, Leveltrabalho.valueOf(levelTrabalho), baseSalario, new Departamento(nomeDepartamento));
	
		System.out.println("Quantos contratos o trabalhador vai ter? ");
		int qtdeContrato = sc.nextInt();
		
		for(int i =0; i<qtdeContrato; i++) {
			System.out.println("Entre com o contato " + (i+1)+": " + " Data: ");
			System.out.println("Data (DD/MM/YYYY");
			
			Date contratoData = sdf.parse(sc.next());
			System.out.println("valor por Hora: ");
			Double valorPorHora = sc.nextDouble();
			System.out.println("Duracao por hora: ");
			Integer hora = sc.nextInt();
			HoraContrato contrato = new HoraContrato(contratoData, valorPorHora, hora);
			trabalho.adicionarContrato(contrato);
		}
		
		
		System.out.println();
		System.out.println("mes e ano para calcular o salario (MM/YYYY)");
		String mesEano = sc.next();
		int mes = Integer.parseInt(mesEano.substring(0, 2));
		int ano = Integer.parseInt(mesEano.substring(3));
		
		
		
		System.out.println("Salario para "+ mesEano + ": " + String.format("%.2f", trabalho.ganhoMensal(ano, mes)));
		
		sc.close();
	}

}
