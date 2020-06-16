package principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import biblioteca.Bibliotecario;
import biblioteca.Libro;

public class InterfazMostrarLibro extends JFrame{
	
	public JPanel panel;
	
	Bibliotecario bi=new Bibliotecario();
	
	public InterfazMostrarLibro(Libro libro) {
		this.setSize(500, 380);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Detalles Libro");
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.gray);
		
		iniciarComponentes(libro);
	}
	
	
	
	private void iniciarComponentes(Libro libro) {
		JPanel panel=new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		JLabel etiqueta=new JLabel();
		etiqueta.setText("Detalles Libro");
		etiqueta.setBounds(85, 10, 300, 80);
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setFont(new Font("arial",Font.ITALIC,35));
		panel.add(etiqueta);
		
		JLabel etiqueta2=new JLabel();
		etiqueta2.setText("Nombre: "+libro.getNombre());
		etiqueta2.setBounds(50, 80, 300, 30);
		etiqueta2.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta2);
		
		JLabel etiqueta3=new JLabel();
		etiqueta3.setText("Autor: "+libro.getAutor());
		etiqueta3.setBounds(50, 130, 300, 30);
		etiqueta3.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta3);
		
		JLabel etiqueta4=new JLabel();
		etiqueta4.setText("ISBN: "+libro.getCodigo());
		etiqueta4.setBounds(50, 180, 300, 30);
		etiqueta4.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta4);
		
		JLabel etiqueta5=new JLabel();
		etiqueta5.setText("Edición: "+libro.getEdicion());
		etiqueta5.setBounds(50, 230, 300, 30);
		etiqueta5.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta5);
		
		JLabel etiqueta8=new JLabel();
		etiqueta8.setText("Disponible: "+libro.isDisponible());
		etiqueta8.setBounds(50, 280, 300, 30);
		etiqueta8.setFont(new Font("arial",Font.BOLD,20));
		panel.add(etiqueta8);
		
		JButton btnMain = new JButton();
		btnMain.setBounds(260, 280, 200,40);
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
		
		
	}

}
