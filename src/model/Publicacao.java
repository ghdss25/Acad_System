package model;

public class Publicacao {
	
	private int PUBL_ID;
	private String PUBL_TITULO;
	private java.sql.Date PUBL_DATAPUBLICADA;
	private String PUBL_TIPO;
	private int ALU_RA;
	
	
	public int getPUBL_ID() {
		return PUBL_ID;
	}
	public void setPUBL_ID(int PUBL_ID) {
		this.PUBL_ID = PUBL_ID;
	}
	public String getPUBL_TITULO() {
		return PUBL_TITULO;
	}
	public void setPUBL_TITULO(String PUBL_TITULO) {
		this.PUBL_TITULO = PUBL_TITULO;
	}
	public java.sql.Date getPUBL_DATAPUBLICADA() {
		return PUBL_DATAPUBLICADA;
	}
	public void setPUBL_DATAPUBLICADA(java.sql.Date PUBL_DATAPUBLICADA) {
		this.PUBL_DATAPUBLICADA = PUBL_DATAPUBLICADA;
	}
	public String getPUBL_TIPO() {
		return PUBL_TIPO;
	}
	public void setPUBL_TIPO(String PUBL_TIPO) {
		this.PUBL_TIPO = PUBL_TIPO;
	}
	public int getALU_RA() {
		return ALU_RA;
	}
	public void setALU_RA(int ALU_RA) {
		this.ALU_RA = ALU_RA;
	}
	

}
