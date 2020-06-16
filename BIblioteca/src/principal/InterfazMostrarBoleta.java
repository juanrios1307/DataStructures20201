package principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import biblioteca.Bibliotecario;
import biblioteca.Boleta;

public class InterfazMostrarBoleta extends JFrame {
	
	public InterfazMostrarBoleta(Boleta b) {
		this.setSize(500, 500 );
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Boleta");
		//this.setLocation(400, 150);
		//this.setBounds(400, 150, 500,500);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.gray);
		
		iniciarComponentes(b);
	}
	
	Bibliotecario bi=new Bibliotecario();
	
	private void iniciarComponentes(Boleta b1) {
		JPanel panel=new JPanel();
		//panel.setBackground(Color.green);
		panel.setLayout(null);
		this.getContentPane().add(panel);
		JLabel etiqueta=new JLabel();
		etiqueta.setText("Boleta");
		etiqueta.setBounds(85, 10, 300, 80);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setFont(new Font("arial",Font.ITALIC,35));
		panel.add(etiqueta);
		
		JLabel etiqueta2=new JLabel();
		etiqueta2.setText("Libro: "+b1.getNombreLibro());
		etiqueta2.setBounds(50, 80, 300, 30);
		etiqueta2.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta2);
		
		JLabel etiqueta3=new JLabel();
		etiqueta3.setText("Codigo de la Boleta: "+b1.getCodigoBoleta());
		etiqueta3.setBounds(50, 110, 300, 30);
		etiqueta3.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta3);
		
		JLabel etiqueta4=new JLabel();
		etiqueta4.setText("ISBN: "+b1.getCodigo());
		etiqueta4.setBounds(50, 140, 300, 30);
		etiqueta4.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta4);
		
		JLabel etiqueta5=new JLabel();
		etiqueta5.setText("Nombre: "+b1.getNombreUsuario());
		etiqueta5.setBounds(50, 170, 300, 30);
		etiqueta5.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta5);
		
		JLabel etiqueta8=new JLabel();
		etiqueta8.setText("Cedula: "+b1.getCedulaUsuario());
		etiqueta8.setBounds(50, 200, 300, 30);
		etiqueta8.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta8);
		
		JLabel etiqueta6=new JLabel();
		etiqueta6.setText("Fecha de prestamo: "+b1.getFechaPrestamo());
		etiqueta6.setBounds(50, 230, 300, 30);
		etiqueta6.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta6);
		
		JLabel etiqueta7=new JLabel();
		etiqueta7.setText("Fecha de entrega: "+b1.getFechaEntrega());
		etiqueta7.setBounds(50, 260, 300, 30);
		etiqueta7.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta7);
		
		JLabel lblprestamo=new JLabel();
		lblprestamo.setBounds(50, 300, 350, 20);
		lblprestamo.setHorizontalAlignment(SwingConstants.CENTER);
		lblprestamo.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(lblprestamo);
		
		JButton btnMain = new JButton();
		btnMain.setBounds(260, 340, 200,30);
		btnMain.setText("Menu");
		btnMain.setEnabled(true);
		btnMain.setFont(new Font("arial",3,20));
		btnMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InterfazMain i=new InterfazMain();
				i.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(btnMain);
		
		JButton devolverLibro=new JButton("Devolver libro");
		devolverLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((!bi.buscarLibro(b1.getCodigo()).isDisponible()) && bi.buscarBoleta(b1.getCodigoBoleta()).isEstado()) {
					bi.devolverLibro(b1.getCodigo(), b1.getCodigoBoleta());
					
					if (bi.buscarLibro(b1.getCodigo()).isDisponible()) {
						lblprestamo.setText("El libro fue entregado correctamente");
					}else {
						lblprestamo.setText("Hubo un problema al devolver el libro");
					}
				}else {
					lblprestamo.setText("El libro no estaba en prestamo o la boleta no concuerda");
				}
				
				
			}
		});
		devolverLibro.setBounds(30, 340, 200, 30);
		devolverLibro.setFont(new Font("arial",Font.BOLD,20));
		panel.add(devolverLibro);
		
	}
}
