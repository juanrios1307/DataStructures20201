
package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Aeropuerto.Aeropuerto;
import Aeropuerto.Migracion;
import Aeropuerto.TorreDeControl;
import Aeropuerto.Vuelo;
import excepcion.ENoFecha;

public class InterfazTorreControl extends JFrame{

	public InterfazTorreControl(Vuelo v,boolean b,Aeropuerto a) {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Sistema Aeroportuario");
		//this.setLocation(400, 150);
		//this.setBounds(400, 150, 500,500);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.gray);
		
		iniciarComponentes(v, b,a);
	}
	
	public void iniciarComponentes(Vuelo v,boolean b,Aeropuerto a) {
		JPanel panel=new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		
		JLabel etiqueta=new JLabel();
		etiqueta.setText("Torre  de Control");
		etiqueta.setBounds(85, 10, 300, 50);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(etiqueta);
		
		JLabel etiqueta2=new JLabel();
		etiqueta2.setText("Vuelo: "+v.getVuelo());
		etiqueta2.setBounds(50, 80, 300, 30);
		etiqueta2.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta2);
		
		JLabel etiqueta3=new JLabel();
		etiqueta3.setText("Estado vuelo: "+v.getEstado());
		etiqueta3.setBounds(50, 110, 400, 30);
		etiqueta3.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta3);
		
		JLabel etiqueta4=new JLabel();
		etiqueta4.setText("Aerolinea: "+v.getAvion().getAerolinea());
		etiqueta4.setBounds(50, 140, 300, 30);
		etiqueta4.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta4);
		
		JLabel etiqueta5=new JLabel();
		etiqueta5.setText("Documento piloto: "+v.getPiloto().getDocumento());
		etiqueta5.setBounds(50, 170, 450, 30);
		etiqueta5.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta5);
		
		JLabel etiqueta8=new JLabel();
		etiqueta8.setText("Personal a bordo: "+v.getTiquetes().length+2);
		etiqueta8.setBounds(50, 200, 450, 30);
		etiqueta8.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta8);
		
		JLabel etiqueta6=new JLabel();
		etiqueta6.setText("Codigo "+(b?"destino: "+v.getCodAeroptLlegada():"origen: "+v.getCodAeroptSalida()));
		etiqueta6.setBounds(50, 230, 450, 30);
		etiqueta6.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta6);
		
		JLabel etiqueta7=new JLabel();
		try {
			etiqueta7.setText("Hora "+(b?"despegue: "+v.getHoraSalida():"aterrizaje: "+v.getHoraLlegada()));
		} catch (ENoFecha e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		etiqueta7.setBounds(50, 260, 400, 30);
		etiqueta7.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta7);
		
		
		JCheckBoxMenuItem para1=new JCheckBoxMenuItem("Plan de Vuelo",false);
		para1.setBounds(50,50, 130, 30);
		para1.setFont(new Font("arial",Font.ITALIC,15));
		para1.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		JCheckBoxMenuItem para2=new JCheckBoxMenuItem("Notam",false);
		para2.setBounds(190,50, 100, 30);
		para2.setFont(new Font("arial",Font.ITALIC,15));
		para2.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		JCheckBoxMenuItem para3=new JCheckBoxMenuItem("Metar",false);
		para3.setBounds(300,50, 120, 30);
		para3.setFont(new Font("arial",Font.ITALIC,15));
		para3.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		if(b) {
			panel.add(para1);
			panel.add(para2);
			panel.add(para3);
		}else {
			
		}
		JButton permitir=new JButton();
		permitir.setText("Permitir "+(b?"despegue":"aterrizaje"));
		permitir.setBounds(110, 300, 250, 30);
		permitir.setHorizontalAlignment(SwingConstants.CENTER);
		permitir.setFont(new Font("arial",Font.ITALIC,20));
		panel.add(permitir);
		permitir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TorreDeControl tc=new TorreDeControl(v);
				if(b) {
					tc.setPlanVuelo(para1.isSelected());
					tc.setNotam(para2.isSelected());
					tc.setMetar(para3.isSelected());
					
				}else {
					
				}
				
				if(b) {
					if(tc.isPlanVuelo()&&tc.isNotam()&&tc.isMetar()) {
						JOptionPane.showMessageDialog(null, tc.estadoVuelo());
						JOptionPane.showMessageDialog(null, "El avion despego");
						int bool=JOptionPane.showConfirmDialog(null, "Desea continuar operaciones?");
						if(bool==0) {
							InterfazPedidoVuelo i1=new InterfazPedidoVuelo(a);
							i1.setVisible(true);
							setVisible(false);
						}else {
							setVisible(false);
						}
					}else {
						JOptionPane.showMessageDialog(null, tc.estadoVuelo());
						JOptionPane.showMessageDialog(null, "El avion aun no tiene las condiciones para despegar");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "El avion aterrizo");
					tc.setAvionAproximando(true);
					
					InterfazMigracion i1=new InterfazMigracion(v,a,false);
					i1.setVisible(true);
					setVisible(false);
					
				}
	
			}
			
		});
		
		

	}
}
