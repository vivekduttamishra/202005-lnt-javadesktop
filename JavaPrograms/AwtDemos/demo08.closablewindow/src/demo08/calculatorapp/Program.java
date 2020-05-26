package demo08.calculatorapp;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator calc=new Calculator("Simple Calculator");
		
		Calculator calc2=new Calculator("Advanced Calculator");
		
		calc2.setMainWindow(true);
		
		
		calc.setVisible(true);
		calc2.setVisible(true);
	}

}
