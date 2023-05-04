package lernen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class EjercicioDificil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco23 marco23 = new Marco23();
		marco23.setDefaultCloseOperation(3);
		marco23.setVisible(true);

	}

}

class Marco23 extends JFrame {
	public Marco23() {

		setTitle("Prueba de diálogos");
		setBounds(50, 50, 600, 500);
		JPanel laminaBase = new JPanel();
//		laminaBase.setLayout(new GridLayout(2,3));
//		add(laminaBase);
		Lamina23 lamina23 = new Lamina23();
		add(lamina23);
	}

}

class Lamina23 extends JPanel {
	public Lamina23() {

//define disposicion lamina

		setLayout(new BorderLayout());

//crear paneles

		JPanel panelGrande = new JPanel(); // contiene las cajas
		JPanel panelBoton = new JPanel(); // contiene el boton

//definir disposicion de la lamina q contiene las cajas 

		panelGrande.setLayout(new GridLayout(2, 3));

//crear el boton

		JButton botonMostrar = new JButton("Mostrar");

//definir la disposicion de la lamina q contiene el boton para q no ocupe todo el campo

		panelBoton.setLayout(new FlowLayout());

//anadir boton a su panel 

		panelBoton.add(botonMostrar);

//anadir paneles a la lamina con disposiciones

		add(panelGrande, BorderLayout.CENTER);
		add(panelBoton, BorderLayout.SOUTH);

// crear cajas 

		Box cajaTipo = Box.createHorizontalBox();

		cajaTipo.setOpaque(true);
		cajaTipo.setBackground(Color.YELLOW);
//		cajaTipo.setBorder(new TitledBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10),"Titulo",TitledBorder.LEADING,1));
		
		
		Box cajaConfirmar = Box.createHorizontalBox();
		Box cajaTipoMensaje = Box.createHorizontalBox();
		Box cajaMensaje = Box.createHorizontalBox();
		Box cajaOpcion = Box.createHorizontalBox();
		Box cajaEntrada = Box.createHorizontalBox();

		panelGrande.add(cajaTipo);
		panelGrande.add(cajaConfirmar);
		panelGrande.add(cajaTipoMensaje);
		panelGrande.add(cajaMensaje);
		panelGrande.add(cajaOpcion);
		panelGrande.add(cajaEntrada);

	}

}
