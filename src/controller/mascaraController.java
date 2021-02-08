package controller;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class mascaraController {
	
	//fieldSessao = new JFormattedTextField(mascara.mascaraSessao());
	
	private MaskFormatter mascara = null;
	
	public MaskFormatter mascaraTelefone(){
			try {
				mascara = new MaskFormatter("(##)#####-####");
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		return mascara;
	}
	
	public MaskFormatter mascaraCPF(){
			try {
				mascara = new MaskFormatter("###.###.###-##");
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		return mascara;
	}
	
	public MaskFormatter mascaraData(){
		try {
			mascara = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	return mascara;
	}
	
	public MaskFormatter mascaraCredito(){
		try {
			mascara = new MaskFormatter("###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	return mascara;
	}
}
