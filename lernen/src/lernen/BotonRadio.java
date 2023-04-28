package lernen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BotonRadio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco6 marco5 = new Marco6();

	}

}

class Marco6 extends JFrame {

	public Marco6() {

		setBounds(50, 50, 200, 200);
		setTitle("botones de radio");
		setVisible(true);
		setDefaultCloseOperation(3);
		Lamina6 lamina6 = new Lamina6();
		add(lamina6);
	}
}

class Lamina6 extends JPanel {

	JPanel panelRadio;
	JLabel textField;
	ButtonGroup grupoBotones;

	public Lamina6() {

		setLayout(new BorderLayout());
		panelRadio = new JPanel();
		textField = new JLabel("aqui hay un texto x ");
		grupoBotones = new ButtonGroup();
		panelRadio.setLayout(new FlowLayout());

		crearBotones("chico", false, 12);
		crearBotones("mediano", false, 16);
		crearBotones("grande", false, 20);
		crearBotones("super grande", false, 24);

		add(textField, BorderLayout.NORTH);
		add(panelRadio, BorderLayout.SOUTH);
	}

	public void crearBotones(String nombre, boolean inicio, int tamanio) {

		JRadioButton boton = new JRadioButton(nombre, inicio);
		grupoBotones.add(boton);
		panelRadio.add(boton);

		ActionListener instrucciones = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				textField.setFont(new Font("", Font.PLAIN, tamanio));
			}
		};

		boton.addActionListener(instrucciones);

	}

//	JRadioButton botonRadio1;
//	JRadioButton botonRadio2;
//	JRadioButton botonRadio3;
//	JRadioButton botonRadio4;
//	JRadioButton botonRadio5;
//	JLabel textField;
//
//	public Lamina6() {
//
//		setLayout(new BorderLayout());
//
//		JPanel panelRadio = new JPanel();
//		JPanel panelTexto = new JPanel();
//
//		textField = new JLabel("aqui hay un texto");
//		panelTexto.add(textField);
//
////		Document docTexto = new ;
//
//		panelRadio.setLayout(new FlowLayout());
//
//		botonRadio1 = new JRadioButton("chico", false);
//		botonRadio2 = new JRadioButton("chico-mediano", false);
//		botonRadio3 = new JRadioButton("mediano", false);
//		botonRadio4 = new JRadioButton("medio grande", false);
//		botonRadio5 = new JRadioButton("grande", false);
//
//		ButtonGroup grupoBotones = new ButtonGroup();
//
//		grupoBotones.add(botonRadio1);
//		grupoBotones.add(botonRadio2);
//		grupoBotones.add(botonRadio3);
//		grupoBotones.add(botonRadio4);
//		grupoBotones.add(botonRadio5);
//
//		Instrucciones instrucciones = new Instrucciones();
//		botonRadio1.addActionListener(instrucciones);
//		botonRadio2.addActionListener(instrucciones);
//		botonRadio3.addActionListener(instrucciones);
//		botonRadio4.addActionListener(instrucciones);
//		botonRadio5.addActionListener(instrucciones);
//
//		// panelRadio.add(grupoBotones);//no se agrega el grupo a la lamina !!! el grupo
//		// solo sirve para usar la funcion de no poder marcar varios objetos al mismo
//		// tiempo, pero no es una lamina en si q se pueda agregar a la lamina panel
//
//		panelRadio.add(botonRadio1);
//		panelRadio.add(botonRadio2);
//		panelRadio.add(botonRadio3);
//		panelRadio.add(botonRadio4);
//		panelRadio.add(botonRadio5);
//
//		add(panelTexto, BorderLayout.NORTH);
//		add(panelRadio, BorderLayout.SOUTH);
//	}
//
//	class Instrucciones implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			int sizeFont = 0;
//			if (e.getSource() == botonRadio1) {
//				sizeFont = 8;
//			} else if (e.getSource() == botonRadio2) {
//				sizeFont = 12;
//			} else if (e.getSource() == botonRadio3) {
//				sizeFont = 16;
//			} else if (e.getSource() == botonRadio4) {
//				sizeFont = 20;
//			}else if (e.getSource()==botonRadio5) {
//				sizeFont = 24;}
//
//			textField.setFont(new Font("", Font.PLAIN, sizeFont));
//
//		}
//
//	}
}
