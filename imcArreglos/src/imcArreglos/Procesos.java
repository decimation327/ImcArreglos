package imcArreglos;

import javax.swing.JOptionPane;

public class Procesos {

	String mensaje;
	String nombres[];
	String telefono[];
	Double imcArray[];
	String resultadoImc[];

	public void menu() {
		
		int menu;

		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("*****************menu*****************\n"
					+ "1.registro\n" 
					+ "2.imprimir\n" 
					+ "3.salir\n" 
					+ "**************************************"));
			iniciar(menu);
		}while(menu != 3);
	}

	public void iniciar(int menu) {
		switch (menu) {
		case 1:ingresarDatos();break;
		case 2:imprimir();break;
		case 3:System.out.println("Bye Bye...");break;
		default:System.out.println("Ingrese una opcion valida");break;
		}
	}

	private void imprimir() {

		for (int i = 0; i < nombres.length; i++) {
			mensaje +="***********************Resultado************************";
			mensaje +="El nombre de la persona es: " +nombres[i];
			mensaje +="El telefono: "+ telefono[i] ;
			mensaje +="El resultado del examen es: "+ resultadoImc[i];
			mensaje +="Su porcentaje de imc es: "+imcArray[i];
			mensaje +="*********************************************************";
			System.out.println(mensaje);
		}
	}

	private String obtenerResultado(double imc) {

		String resultado = "";

		if (imc < 18) {resultado = "anorexia";} 
		else if (imc >= 18 && imc < 20) {resultado = "Delgades";} 
		else if (imc >= 20 && imc < 27) {resultado = "Normalidad";} 
		else if (imc >= 27 && imc < 30) {resultado= "Obesidad grado 1";} 
		else if (imc >= 30 && imc < 35) {resultado= "Obesidad grado 2";} 
		else if (imc >= 35 && imc < 40) {resultado= "Obesidad grado 3";} 
		else {resultado= "Obesidad morbida";}

		return resultado;
	}

	public void ingresarDatos() {
		double altura, peso;

		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de personas a registrar: "));

		nombres = new String[cantidad];
		telefono = new String[cantidad];
		resultadoImc = new String[cantidad];
		imcArray= new Double[cantidad];
		
		double imc = 0;

		String resultado;

		for (int i = 0; i < cantidad; i++) {
			nombres[i] = JOptionPane.showInputDialog("Ingrese su nombre: ");
			telefono[i] = JOptionPane.showInputDialog("Ingrese su numero de telefono:");
			peso = Double.parseDouble(JOptionPane.showInputDialog("ingrese su peso: "));
			altura = Double.parseDouble(JOptionPane.showInputDialog("ingrese su altura: "));
			
			imc = resultadoImc(peso, altura);
			imcArray[i]=imc;
			resultado = obtenerResultado(imc);
			resultadoImc[i] = resultado;
		}
	}

	private double resultadoImc(double peso, double altura) {

		double imc = 0;
		imc = peso / (altura * altura);
		return imc;
	}
}