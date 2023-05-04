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
import javax.swing.JRadioButton;
import javax.swing.border.Border;

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

// crear cajas 

		Box cajaTipo = Box.createVerticalBox();
		Box cajaTipoMensaje = Box.createVerticalBox();
		Box cajaMensaje = Box.createVerticalBox();
		Box cajaConfirmar = Box.createVerticalBox();
		Box cajaOpcion = Box.createVerticalBox();
		Box cajaEntrada = Box.createVerticalBox();

//		cajaTipo.setOpaque(true);
//		cajaTipo.setBackground(new Color(230, 230, 230));
// creas botones radio 

		JRadioButton boton1_1 = new JRadioButton("tamanio");
		JRadioButton boton1_2 = new JRadioButton("tamanio");
		JRadioButton boton1_3 = new JRadioButton("tamanio");
		JRadioButton boton1_4 = new JRadioButton("tamanio");

		JRadioButton boton2_1 = new JRadioButton("tamanio");
		JRadioButton boton2_2 = new JRadioButton("tamanio");
		JRadioButton boton2_3 = new JRadioButton("tamanio");
		JRadioButton boton2_4 = new JRadioButton("tamanio");
		JRadioButton boton2_5 = new JRadioButton("tamanio");
		JRadioButton boton2_6 = new JRadioButton("tamanio");

//		JRadioButton boton1_3 = new JRadioButton("tamanio");
//		JRadioButton boton1_4 = new JRadioButton("tamanio");
//		JRadioButton boton1_1 = new JRadioButton("tamanio");
//		JRadioButton boton1_2 = new JRadioButton("tamanio");
//		JRadioButton boton1_3 = new JRadioButton("tamanio");
//		JRadioButton boton1_4 = new JRadioButton("tamanio");
//		JRadioButton boton1_1 = new JRadioButton("tamanio");
//		JRadioButton boton1_2 = new JRadioButton("tamanio");
//		JRadioButton boton1_3 = new JRadioButton("tamanio");
//		JRadioButton boton1_4 = new JRadioButton("tamanio");

// anadir botones a las cajas 

		cajaTipo.add(boton1_1);
		cajaTipo.add(boton1_2);
		cajaTipo.add(boton1_3);
		cajaTipo.add(boton1_4);

		cajaTipoMensaje.add(boton2_1);

// anadir cajas a panel

		panelGrande.add(cajaTipo);
		panelGrande.add(cajaTipoMensaje);
		panelGrande.add(cajaMensaje);

		panelGrande.add(cajaConfirmar);
		panelGrande.add(cajaOpcion);
		panelGrande.add(cajaEntrada);

//anadir paneles a la lamina con disposiciones

		add(panelGrande, BorderLayout.CENTER);
		add(panelBoton, BorderLayout.SOUTH);

//		Border borde = BorderFactory.createLineBorder(Color.gray);
//		borde.isBorderOpaque();
//		cajaTipo.setBorder(borde);

	}

}
