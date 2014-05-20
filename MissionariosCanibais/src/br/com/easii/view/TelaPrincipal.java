package br.com.easii.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import sun.util.BuddhistCalendar;
import br.com.easii.enums.PosicaoDoBarco;
import br.com.easii.find.AEstrela;
import br.com.easii.find.BuscaCega;
import br.com.easii.find.BuscaHeuristica;
import br.com.easii.problem.Estado;
import br.com.easii.problem.Solution;

public class TelaPrincipal {

	private JFrame frame;
	private BuscaCega buscaProfundidade;
	private BuscaCega buscaLargura;
	private BuscaHeuristica buscaHeuristica;
	private AEstrela aEstrela;
	private Solution solution;
	JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 639, 347);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblMissionarios = new JLabel("Missionarios = 03");
		lblMissionarios.setBounds(108, 15, 108, 29);
		frame.getContentPane().add(lblMissionarios);
		
		JLabel lblCanibais = new JLabel("Canibais = 03");
		lblCanibais.setBounds(348, 20, 89, 19);
		frame.getContentPane().add(lblCanibais);
		
		
		
		
		
		JButton btnNewButton = new JButton("Execute");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estado estadoInicial = new Estado(3, 3, PosicaoDoBarco.ESQUERDA, null, 0);
				buscaProfundidade = new BuscaCega(estadoInicial);
				buscaLargura = new BuscaCega(estadoInicial);
				buscaHeuristica = new BuscaHeuristica(estadoInicial);
				aEstrela = new AEstrela(estadoInicial);
				
				String str = " ";
				solution = buscaProfundidade.buscaEmProfundidade();
				str += "\n-----------------------------------------------------------------------------------------------\n"+
						"\tBusca em Profundidade\n" + solution.mostraCaminho();
				solution = buscaLargura.buscaEmLargura();
				str += "\n-----------------------------------------------------------------------------------------------\n"+
						"\tBusca em Largura\n" + solution.mostraCaminho();
				solution = buscaHeuristica.execute();
				str += "\n-----------------------------------------------------------------------------------------------\n"+
						"\tBusca Gulosa\n" + solution.mostraCaminho();
				solution = aEstrela.execute();
				str += "\n-----------------------------------------------------------------------------------------------\n"+
						"\tBusca A*\n" + solution.mostraCaminho() ;
				textArea.setText(str);
			}
		});
		
		btnNewButton.setBounds(548, 15, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
