package ui;

import model.*;
import javax.swing.*;

public class UI {
	
	Model _model;
	JFrame _window;
	JMenuBar _menuBar;
	
	public UI(Model m){
		_model = m;
		genUI();
	}
	
	public void genUI(){
		_window = new JFrame("Fractal Generator");
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		_menuBar = new JMenuBar();
		genFractalMenu();
		genEscapeDistanceMenu();
		genColorSchemeMenu();
		_menuBar.getAccessibleContext();
		
		_window.setJMenuBar(_menuBar);
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
		JButton escapeDistanceSetter = new JButton("Set Escape Distance");
//		escapeDistanceSetter.addActionListener( ADD STUFF HERE YO );
		escapeDistanceMenu.add(escapeDistanceSetter);
		
		_menuBar.add(escapeDistanceMenu);
	}

	private void genFractalMenu() {
		JMenu fractalTypeMenu = new JMenu("Fractal Type");
		
		fractalTypeMenu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem fractal1 = new JRadioButtonMenuItem("MandelBrot");
		JRadioButtonMenuItem fractal2 = new JRadioButtonMenuItem("Julia");
		JRadioButtonMenuItem fractal3 = new JRadioButtonMenuItem("Burning Ship");
		JRadioButtonMenuItem fractal4 = new JRadioButtonMenuItem("Multibrot");
//		rbMenuItem.setSelected(true);
//		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		
		group.add(fractal1);
		group.add(fractal2);
		group.add(fractal3);
		group.add(fractal4);
		
		fractalTypeMenu.add(fractal1);
		fractalTypeMenu.add(fractal2);
		fractalTypeMenu.add(fractal3);
		fractalTypeMenu.add(fractal4);
		
		_menuBar.add(fractalTypeMenu);
	}

}
