package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Aeropuerto.Aeropuerto;
import Aeropuerto.Vuelo;
import Persona.Piloto;

public class InterfazAddPiloto extends JFrame{
public JPanel panel;
	
	public InterfazAddPiloto(Aeropuerto a,Vuelo v,boolean b,String li) {
		this.setSize(820, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Sistema Aeroportuario");
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.gray);
		
		
		iniciarComponentes(a,v,b,li);
	}

	
	public void iniciarComponentes(Aeropuerto a,Vuelo v,boolean b,String li) {
		
		colocarPaneles(a);
		colocarEtiquetas(a);
		addTxtAndButton(a,v,b,li);
		
	}
	
	
	
	private void colocarPaneles(Aeropuerto a) {
		panel=new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}
	
	
	private void colocarEtiquetas(Aeropuerto a) {
		
		JLabel etiqueta=new JLabel();
		etiqueta.setText("Agregar Piloto ");
		etiqueta.setBounds(150, 5, 300, 60);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setFont(new Font("arial",Font.ITALIC,25));
		panel.add(etiqueta);
		
		JLabel etiqueta2=new JLabel();
		etiqueta2.setText("Nombre: ");
		etiqueta2.setBounds(50, 80, 160, 30);
		etiqueta2.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta2);
		
		JLabel etiqueta3=new JLabel();
		etiqueta3.setText("Documento: ");
		etiqueta3.setBounds(50, 130, 160, 30);
		etiqueta3.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta3);
		
		JLabel etiqueta4=new JLabel();
		etiqueta4.setText("Nacionalidad: ");
		etiqueta4.setBounds(420, 80, 160, 30);
		etiqueta4.setFont(new Font("arial",Font.BOLD,18));
		panel.add(etiqueta4);
		
		JLabel etiqueta5=new JLabel();
		etiqueta5.setText("Edad: ");
		etiqueta5.setBounds(420, 130, 300, 30);
		etiqueta5.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta5);
		
		
		
		JLabel etiqueta7=new JLabel();
		etiqueta7.setText("Licencia : ");
		etiqueta7.setBounds(420, 180, 300, 30);
		etiqueta7.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta7);
		
		
		
	}
	
	private void addTxtAndButton(Aeropuerto a,Vuelo v,boolean b,String li) {
		
		JTextField nombre=new JTextField();
		nombre.setBounds(230, 80, 160, 30);
		panel.add(nombre);
		
		JTextField documento=new JTextField();
		documento.setBounds(230, 130, 160, 30);
		panel.add(documento);
		
		
		JTextField nacionalidad=new JTextField();
		nacionalidad.setBounds(600, 80, 160, 30);
		panel.add(nacionalidad);
		
		JTextField edad=new JTextField();
		edad.setBounds(600, 130, 160, 30);
		panel.add(edad);
		
		JCheckBoxMenuItem para3=new JCheckBoxMenuItem("Se encuentra contagiado?",false);
		para3.setBounds(130, 180, 250, 30);
		para3.setFont(new Font("arial",Font.ITALIC,15));
		para3.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(para3);
		
		JTextField licencia=new JTextField();
		licencia.setBounds(600, 180, 160, 30);
		licencia.setText(li);
		panel.add(licencia);
	
		
		JButton btnMain = new JButton();
		btnMain.setBounds(425, 290, 200,40);
		btnMain.setText("Cancelar y cerrar");
		btnMain.setEnabled(true);
		btnMain.setFont(new Font("arial",3,15));
		btnMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		panel.add(btnMain);
	
		JButton btnGuardar = new JButton();
		btnGuardar.setBounds(195, 290, 200,40);
		btnGuardar.setText("Confirmar");
		btnGuardar.setEnabled(true);
		btnGuardar.setFont(new Font("arial",3,20));
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Piloto p=new Piloto(nombre.getText(),documento.getText(),nacionalidad.getText(),
						Integer.parseInt(edad.getText()),para3.isSelected(),licencia.getText());
				
				
				
				
				
			
				Boolean bool;
				if(nombre.getText().equals("4256")) {
					bool=true;
				}else {
					bool=false;
				}
				
				a.addPiloto(p);
				a.addVuelo(v, bool);
					
					JOptionPane.showMessageDialog(null, "Vuelo y piloto añadidos correctamente");
					InterfazAeropuerto i1=new InterfazAeropuerto(a);
					i1.setVisible(true);
					setVisible(false);
				
				
				
				
				
				
			}
		});
		panel.add(btnGuardar);
	}
	
}
