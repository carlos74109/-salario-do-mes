package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entidades.Enums.Leveltrabalho;

public class Trabalho {
	
	private String nome;
	private Leveltrabalho level;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<HoraContrato> contrato = new ArrayList<>();
	
	public Trabalho() {
		super();
	}

	public Trabalho(String nome, Leveltrabalho level, Double salarioBase, Departamento departamento) {
		
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Leveltrabalho getLevel() {
		return level;
	}

	public void setLevel(Leveltrabalho level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContrato() {
		return contrato;
	}

		
	
	public void adicionarContrato(HoraContrato contratos) {
		contrato.add(contratos);
	}
	
	public void removerCOntrato(HoraContrato demContrato) {
		contrato.remove(demContrato);
	}
	
	
	public double ganhoMensal(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		
		for(HoraContrato c : contrato) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			
			if(ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		
		return soma;
	}
	
	@Override
	public String toString() {
		return "nome: " + getNome() + "Departamento: " + getDepartamento().nome;
	}
	
	
}
