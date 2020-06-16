package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Aeropuerto.Aeropuerto;
import Aeropuerto.Migracion;
import Aeropuerto.TorreDeControl;
import Aeropuerto.Vuelo;
import Mecanico.Mecanico;

public class InterfazMecanico extends JFrame{
	
	public InterfazMecanico(Vuelo v,Aeropuerto a) {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Sistema Aeroportuario");
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.gray);
		
		iniciarComponentes(v,a);
	}
	
	public void iniciarComponentes(Vuelo v,Aeropuerto a) {
		JPanel panel=new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel titulo=new JLabel();
		titulo.setText("MECANICO");
		titulo.setBounds(85, 10, 300, 50);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(titulo);
		
		JCheckBoxMenuItem para1=new JCheckBoxMenuItem("Plan de Vuelo",false);
		para1.setBounds(50,50, 120, 50);
		para1.setFont(new Font("arial",Font.ITALIC,15));
		para1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(para1);
		
		JCheckBoxMenuItem para2=new JCheckBoxMenuItem("Brujula",false);
		para2.setBounds(50,90, 120, 50);
		para2.setFont(new Font("arial",Font.ITALIC,15));
		para2.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(para2);
		
		JCheckBoxMenuItem para3=new JCheckBoxMenuItem("Extintores",false);
		para3.setBounds(50,130, 120, 50);
		para3.setFont(new Font("arial",Font.ITALIC,15));
		para3.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(para3);
		
		JCheckBoxMenuItem para4=new JCheckBoxMenuItem("Altimetro",false);
		para4.setBounds(50,180, 120, 50);
		para4.setFont(new Font("arial",Font.ITALIC,15));
		para4.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(para4);
		
		JCheckBoxMenuItem para5=new JCheckBoxMenuItem("Equipo de Emergencia",false);
		para5.setBounds(50,230, 170, 50);
		para5.setFont(new Font("arial",Font.ITALIC,15));
		para5.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(para5);
		
		JCheckBoxMenuItem para6=new JCheckBoxMenuItem("Equipo de Oxigeno",false);
		para6.setBounds(260,50, 150, 50);
		para6.setFont(new Font("arial",Font.ITALIC,15));
		para6.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(para6);
		
		JCheckBoxMenuItem para7=new JCheckBoxMenuItem("Peso-Balance",false);
		para7.setBounds(260,90, 150, 50);
		para7.setFont(new Font("arial",Font.ITALIC,15));
		para7.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(para7);
		
		JLabel aceitetxt=new JLabel();
		aceitetxt.setText("Nivel de aceite");
		aceitetxt.setBounds(260,140, 150, 30);
		aceitetxt.setHorizontalAlignment(SwingConstants.LEFT);
		aceitetxt.setFont(new Font("arial",0,12));
		panel.add(aceitetxt);
		
		JTextField aceite = new JTextField();
		aceite.setBounds(260,165, 150, 30);
		aceite.setFont(new Font("arial",Font.ITALIC,15));
		aceite.setHorizontalAlignment(SwingConstants.LEFT);
		aceite.setText("0");
		panel.add(aceite);
		
		JButton confirmar=new JButton();
		confirmar.setText("Confirmar");
		confirmar.setBounds(260,220, 150, 30);
		confirmar.setHorizontalAlignment(SwingConstants.CENTER);
		confirmar.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(confirmar);
		confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Mecanico m1=new Mecanico(v);
				m1.setAceite(Double.parseDouble(aceite.getText()));
				m1.setBrujula(para2.isSelected());
				m1.setExtintores(para3.isSelected());
				m1.setAltimetro(para4.isSelected());
				m1.setEquipoEmergencia(para5.isSelected());
				m1.setEquipoOxigeno(para6.isSelected());
				m1.setPesoBalance(para7.isSelected());
				
				if(m1.validacion() && m1.pesoAdecuado()&& m1.aceite()) {
					JOptionPane.showMessageDialog(null, "El avion esta en condiciones para salir");
					
					InterfazMigracion tc=new InterfazMigracion(v,a,true);
					tc.setVisible(true);
					setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "El avion no esta en condiciones para salir, por favor adecuelo");
					para1.setSelected(false);
					para2.setSelected(false);
					para3.setSelected(false);
					para4.setSelected(false);
					para5.setSelected(false);
					para6.setSelected(false);
					para7.setSelected(false);
					aceite.setText("0");
					
				}
			}
			
		});
		
		
			
		}

}
