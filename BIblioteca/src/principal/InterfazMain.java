package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import biblioteca.*;

public class InterfazMain extends JFrame {
	
	public InterfazMain() {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Sistema bibliotecario");
		//this.setLocation(400, 150);
		//this.setBounds(400, 150, 500,500);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.gray);
		
		iniciarComponentes();
	}
	
	Libro l=new Libro();
	Boleta b=new Boleta();
	Bibliotecario bi=new Bibliotecario();
	
	private void iniciarComponentes() {
		JPanel panel=new JPanel();
		//panel.setBackground(Color.green);
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel etiqueta=new JLabel();
		etiqueta.setText("Biblioteca");
		etiqueta.setBounds(85, 10, 300, 50);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(etiqueta);
		
		JLabel lbladdBoleta=new JLabel();
		lbladdBoleta.setText("Añadir boleta");
		lbladdBoleta.setBounds(50,70,150,30);
		lbladdBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		lbladdBoleta.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(lbladdBoleta);

		
		JButton addBoleta=new JButton("Agregar boleta");
		addBoleta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfazAddBoleta i=new InterfazAddBoleta();
				i.setVisible(true);
				setVisible(false);
			}
		});
		addBoleta.setBounds(210, 70, 250, 30);
		addBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		addBoleta.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(addBoleta);
		
		
		JLabel lblcodBoleta=new JLabel();
		lblcodBoleta.setText("Codigo boleta: ");
		lblcodBoleta.setBounds(10, 130, 150, 30);
		lblcodBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		lblcodBoleta.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(lblcodBoleta);
		
		JTextField codBoleta=new JTextField();
		codBoleta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				b.setCodigoBoleta(Integer.parseInt(codBoleta.getText()));
			}
		});
		codBoleta.setBounds(170, 130, 150, 30);
		codBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		codBoleta.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(codBoleta);
		
		JButton buscarBoleta=new JButton("Buscar boleta");
		buscarBoleta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				b.setCodigoBoleta(Integer.parseInt(codBoleta.getText()));
				InterfazMostrarBoleta i= new InterfazMostrarBoleta(bi.buscarBoleta(b.getCodigoBoleta()));
				i.setVisible(true);
				setVisible(false);
			}
		});
		buscarBoleta.setBounds(340, 130, 130, 30);
		buscarBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		buscarBoleta.setFont(new Font("arial",Font.ITALIC,15));
		panel.add(buscarBoleta);
		
		
		JLabel lblcodLibro=new JLabel();
		lblcodLibro.setText("Codigo libro: ");
		lblcodLibro.setBounds(10, 180, 150, 30);
		lblcodLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblcodLibro.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(lblcodLibro);
		
		JTextField codLibro=new JTextField();
		codLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l.setCodigo(Integer.parseInt(codLibro.getText()));
			}
		});
		codLibro.setBounds(170, 180, 150, 30);
		codLibro.setHorizontalAlignment(SwingConstants.CENTER);
		codLibro.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(codLibro);
		
		JButton buscarlibro=new JButton("Buscar libro");
		buscarlibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				InterfazMostrarLibro i=new InterfazMostrarLibro(bi.buscarLibro(Integer.parseInt(codLibro.getText())));
				i.setVisible(true);
				setVisible(false);
			}
		});
		buscarlibro.setBounds(340, 180, 120, 30);
		buscarlibro.setHorizontalAlignment(SwingConstants.CENTER);
		buscarlibro.setFont(new Font("arial",Font.ITALIC,15));
		panel.add(buscarlibro);
		
	}
	
	
}
