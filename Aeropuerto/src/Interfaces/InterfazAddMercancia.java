package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Aeropuerto.Aeropuerto;
import Aeropuerto.Vuelo;
import Persona.Mercancia;
import tiquetes.Tiquete;

public class InterfazAddMercancia extends JFrame{
public JPanel panel;
	
	public InterfazAddMercancia (Aeropuerto a,Vuelo v) {
		this.setSize(500, 270);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Sistema Aeroportuario");
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.gray);
		
		
		iniciarComponentes(a,v);
	}

	
	public void iniciarComponentes(Aeropuerto a,Vuelo v) {
		
		colocarPaneles(a);
		colocarEtiquetas(a);
		addTxtAndButton(a,v);
		
	}
	Mercancia m=new Mercancia();
	
	private void colocarPaneles(Aeropuerto a) {
		panel=new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}
	
	
	private void colocarEtiquetas(Aeropuerto a) {
		
		JLabel etiqueta=new JLabel();
		etiqueta.setText("Agregar mercancia");
		etiqueta.setBounds(100, 5, 300, 60);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setFont(new Font("arial",Font.ITALIC,25));
		panel.add(etiqueta);
		
		
		
		
		JLabel etiqueta2=new JLabel();
		etiqueta2.setText("Lote: ");
		etiqueta2.setBounds(50, 80, 300, 30);
		etiqueta2.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta2);
		
		JLabel etiqueta3=new JLabel();
		etiqueta3.setText("Peso: ");
		etiqueta3.setBounds(50, 130, 300, 30);
		etiqueta3.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta3);
		
		
	
		
	}
	
	private void addTxtAndButton(Aeropuerto a,Vuelo v) {
		
		JTextField lote=new JTextField();
		lote.setBounds(270, 80, 170, 30);
		panel.add(lote);
		
		JTextField peso=new JTextField();
		peso.setBounds(270, 130, 170, 30);
		panel.add(peso);
		
		
		
		
		
		JButton btnMain = new JButton();
		btnMain.setBounds(260, 170, 200,40);
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
		btnGuardar.setBounds(30, 170, 200,40);
		btnGuardar.setText("Confirmar");
		btnGuardar.setEnabled(true);
		btnGuardar.setFont(new Font("arial",3,20));
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				m.setLote(lote.getText());
				m.setPeso(Double.parseDouble(peso.getText()));
				
				v.addMercancia(m);
				
				JOptionPane.showMessageDialog(null, "Mercancia creada correctamente");
				
				int k=JOptionPane.showConfirmDialog(null, "�Desea agregar mas mercancias ?");
				
				if(k==0) {
					peso.setText("");
					lote.setText("");
					
				}else {
					InterfazPedidoVuelo i1=new InterfazPedidoVuelo(a);
					i1.setVisible(true);
					setVisible(false);
				}
			
					
			}
		});
		panel.add(btnGuardar);
	}
	
}
