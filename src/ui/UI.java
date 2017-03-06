package ui;

import model.*;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UI {
	
	Model _model;
	JFrame _window;
	JPanel _generatePanel;
	JButton _generateButton;
	JMenuBar _menuBar;
	
	public UI(Model m){
		_model = m;
		genUI();
	}
	
	public void genUI(){
		_window = new JFrame("Fractal Generator");
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		_generatePanel = new JPanel();
		_generatePanel.setLayout(new CardLayout(100,100));
		_generateButton = new JButton("Generate Fractal");
		_generateButton.addActionListener(new generateButtonListener(_model));
		_generatePanel.add(_generateButton);
		
		_menuBar = new JMenuBar();
		genFractalTypeMenu();
		genEscapeDistanceMenu();
		genColorSchemeMenu();
		_menuBar.getAccessibleContext();
		
		_window.setJMenuBar(_menuBar);
		_window.add(_generatePanel);
		_window.setSize(1000, 500);
		_window.setVisible(true);
	}

	private void genColorSchemeMenu() {
		JMenu colorSchemeMenu = new JMenu("Color Scheme");
		
		_menuBar.add(colorSchemeMenu);
	}

	private void genEscapeDistanceMenu() {
		JMenu escapeDistanceMenu = new JMenu("Ecape Distance");
		
		escapeDistanceMenu.addSeparator();
		JMenuItem currentEscapeDistance = new JMenuItem("Current Escape Distance: " + _model.getEscapeDistance());
		escapeDistanceMenu.add(currentEscapeDistance);
		
		escapeDistanceMenu.addSeparator();
		JButton escapeDistanceSetter = new JButton("Set Escape Distance");
//		escapeDistanceSetter.addActionListener( ADD STUFF HERE YO );
		escapeDistanceMenu.add(escapeDistanceSetter);
		
		_menuBar.add(escapeDistanceMenu);
	}

	private void genFractalTypeMenu() {

		JMenu fractalTypeMenu = new JMenu("Fractal Type");
		
		fractalTypeMenu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem fractal1 = new JRadioButtonMenuItem("MandelBrot");
		JRadioButtonMenuItem fractal2 = new JRadioButtonMenuItem("Julia");
		JRadioButtonMenuItem fractal3 = new JRadioButtonMenuItem("Burning Ship");
		JRadioButtonMenuItem fractal4 = new JRadioButtonMenuItem("Multibrot");
		
		group.add(fractal1);
		group.add(fractal2);
		group.add(fractal3);
		group.add(fractal4);
		
		ActionListener al = new fractalTypeMenuActionListener(_model);
		
		fractal1.addActionListener(al);
		fractal2.addActionListener(al);
		fractal3.addActionListener(al);
		fractal4.addActionListener(al);
		
		fractalTypeMenu.add(fractal1);
		fractalTypeMenu.add(fractal2);
		fractalTypeMenu.add(fractal3);
		fractalTypeMenu.add(fractal4);
		
		
		_menuBar.add(fractalTypeMenu);
	}
	
}
