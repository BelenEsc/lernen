package lernen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
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

	JPanel panelGrande;

	public Lamina23() {

//define disposicion lamina

		setLayout(new BorderLayout());

//crear paneles

		panelGrande = new JPanel(); // contiene las cajas
		JPanel panelBoton = new JPanel(); // contiene el boton

//definir disposicion de la lamina q contiene las cajas 

		panelGrande.setLayout(new GridLayout(2, 3));

//crear el boton

		JButton botonMostrar = new JButton("Mostrars");

//definir la disposicion de la lamina q contiene el boton para q no ocupe todo el campo

		panelBoton.setLayout(new FlowLayout());

//anadir boton a su panel 

		panelBoton.add(botonMostrar);

//_________cajas__________		

// definir contenido de cajas 

		String[] elementosCajaTipo = { "Mensaje", "Confirmar", "Opcion", "Entrada" };
		String[] elementosCajaTipoMensaje = { "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE",
				"QUESTION_MESSAGE", "PLAIN_MESSAGE" };
		String[] elementosCajaMensaje = { "Cadena", "Icono", "Componente", "Otros", "Object[]" };
		String[] elementosCajaConfirmar = { "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION",
				"OK_CANCEL_OPTION" };
		String[] elementosCajaOpcion = { "String[]", "Icon[]", "Object[]" };
		String[] elementosCajaEntrada = { "Campo de Texto", "Combo" };

// crear cajas y poner borde 

		ponerBorde(crearCaja(elementosCajaTipo), "Tipo");
		ponerBorde(crearCaja(elementosCajaTipoMensaje), "Tipo de Mensaje");
		ponerBorde(crearCaja(elementosCajaMensaje), "Mensaje");
		ponerBorde(crearCaja(elementosCajaConfirmar), "Confirmar");
		ponerBorde(crearCaja(elementosCajaOpcion), "Opcion");
		ponerBorde(crearCaja(elementosCajaEntrada), "Entrada");

// creas botones radio 

		ButtonGroup grupoTipo = new ButtonGroup();
		ButtonGroup grupoTipoMensaje = new ButtonGroup();
		ButtonGroup grupoMensaje = new ButtonGroup();
		ButtonGroup grupoConfirmar = new ButtonGroup();
		ButtonGroup grupoOpcion = new ButtonGroup();
		ButtonGroup grupoEntrada = new ButtonGroup();

//anadir paneles a la lamina con disposiciones

		add(panelGrande, BorderLayout.CENTER);
		add(panelBoton, BorderLayout.SOUTH);

	}

	public Box ponerBorde(Box caja, String titulo) {

		Border borde = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo);
		caja.setBorder(borde);

		return caja;
	}

	public Box crearCaja(String[] opciones) {

		ButtonGroup grupo = new ButtonGroup();

		Box caja = Box.createVerticalBox();

		for (String x : opciones) {
			JRadioButton boton = new JRadioButton(x);
			grupo.add(boton);
			caja.add(boton);

		}
		caja.setOpaque(true);
		caja.setBackground(new Color(230, 230, 230));
		panelGrande.add(caja);
		return caja;

	}

}
