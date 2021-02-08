package model;



public class Aluno {
	
	private int ALU_RA;
	private String ALU_NOME;
	private String ALU_SEXO;
	private java.sql.Date ALU_DATANASC;
	private String ALU_CPF;
	private String ALU_FILIACAO;
	private String ALU_ENDERECO;
	private String ALU_TELEFONE;
	private java.sql.Date ALU_DATAMATRI;
	private String ALU_DISCCONC;
	private String ALU_DISCPEND;
	private int ALU_CRED;
	private String ALU_PROFIC;
	private String ALU_SISTEMA;
	private int USU_ID;
	private int ORIENT_ID;
	private int CUR_ID;
	
	private String ALU_CURSO; //PARA QUERY ESPECIAL DA BASE DE DADOS
	private String ALU_ORIENT;//PARA QUERY ESPECIAL DA BASE DE DADOS
	

	
	public int getALU_RA() {
		return ALU_RA;
	}
	public void setALU_RA(int ALU_RA) {
		this.ALU_RA = ALU_RA;
	}
	public String getALU_NOME() {
		return ALU_NOME;
	}
	public void setALU_NOME(String ALU_NOME) {
		this.ALU_NOME = ALU_NOME;
	}
	public String getALU_SEXO() {
		return ALU_SEXO;
	}
	public void setALU_SEXO(String ALU_SEXO) {
		this.ALU_SEXO = ALU_SEXO;
	}
	public java.sql.Date getALU_DATANASC() {
		return ALU_DATANASC;
	}
	public void setALU_DATANASC(java.sql.Date ALU_DATANASC) {
		this.ALU_DATANASC = ALU_DATANASC;
	}
	public String getALU_CPF() {
		return ALU_CPF;
	}
	public void setALU_CPF(String ALU_CPF) {
		this.ALU_CPF = ALU_CPF;
	}
	public String getALU_FILIACAO() {
		return ALU_FILIACAO;
	}
	public void setALU_FILIACAO(String ALU_FILIACAO) {
		this.ALU_FILIACAO = ALU_FILIACAO;
	}
	public String getALU_ENDERECO() {
		return ALU_ENDERECO;
	}
	public void setALU_ENDERECO(String ALU_ENDERECO) {
		this.ALU_ENDERECO = ALU_ENDERECO;
	}
	public String getALU_TELEFONE() {
		return ALU_TELEFONE;
	}
	public void setALU_TELEFONE(String ALU_TELEFONE) {
		this.ALU_TELEFONE = ALU_TELEFONE;
	}
	public java.sql.Date getALU_DATAMATRI() {
		return ALU_DATAMATRI;
	}
	public void setALU_DATAMATRI(java.sql.Date ALU_DATAMATRI) {
		this.ALU_DATAMATRI = ALU_DATAMATRI;
	}
	public String getALU_DISCCONC() {
		return ALU_DISCCONC;
	}
	public void setALU_DISCCONC(String ALU_DISCCONC) {
		this.ALU_DISCCONC = ALU_DISCCONC;
	}
	public String getALU_DISCPEND() {
		return ALU_DISCPEND;
	}
	public void setALU_DISCPEND(String ALU_DISCPEND) {
		this.ALU_DISCPEND = ALU_DISCPEND;
	}
	public int getALU_CRED() {
		return ALU_CRED;
	}
	public void setALU_CRED(int ALU_CRED) {
		this.ALU_CRED = ALU_CRED;
	}
	public String getALU_PROFIC() {
		return ALU_PROFIC;
	}
	public void setALU_PROFIC(String ALU_PROFIC) {
		this.ALU_PROFIC = ALU_PROFIC;
	}
	public String getALU_SISTEMA() {
		return ALU_SISTEMA;
	}
	public void setALU_SISTEMA(String ALU_SISTEMA) {
		this.ALU_SISTEMA = ALU_SISTEMA;
	}
	public int getUSU_ID() {
		return USU_ID;
	}
	public void setUSU_ID(int USU_ID) {
		this.USU_ID = USU_ID;
	}
	public int getORIENT_ID() {
		return ORIENT_ID;
	}
	public void setORIENT_ID(int ORIENT_ID) {
		this.ORIENT_ID = ORIENT_ID;
	}
	
	public int getCUR_ID() {
		return CUR_ID;
	}
	public void setCUR_ID(int CUR_ID) {
		this.CUR_ID = CUR_ID;
	}
	
	
	
	public String getALU_CURSO() {
		return ALU_CURSO;
	}
	public void setALU_CURSO(String ALU_CURSO) {
		this.ALU_CURSO = ALU_CURSO;
	}
	public String getALU_ORIENT() {
		return ALU_ORIENT;
	}
	public void setALU_ORIENT(String ALU_ORIENT) {
		this.ALU_ORIENT = ALU_ORIENT;
	}

}
