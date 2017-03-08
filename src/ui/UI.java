package ui;

import model.*;
import observer_pattern.*;

import java.awt.*;

import javax.swing.*;

public class UI implements Observer{
	
	Model _model;
	JFrame _window;
	JPanel _generatePanel;
	JPanel _fractalPanel;
	JButton _generateButton;
	JMenuItem _currentEscapeDistance;
	JMenuBar _menuBar;
	
	public UI(Model m){
		_model = m;
		_model.addObserver(this);
		initUI();
		update();
		
	}
	
	public void initUI(){
		_window = new JFrame("Fractal Generator");
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		_menuBar = new JMenuBar();
		genFractalTypeMenu();
		genEscapeDistanceMenu();
		genColorSchemeMenu();
		
		_generatePanel = new JPanel();
		_generatePanel.setLayout(new CardLayout(150,200));
		_generateButton = new JButton("Generate Fractal");
		_generateButton.addActionListener(new GenerateButtonListener(_model));
		_generatePanel.add(_generateButton);
		
		_window.setJMenuBar(_menuBar);
		_window.add(_generatePanel);
		_window.setSize(600, 600);
		_window.setVisible(true);
	}

	public void genColorSchemeMenu() {
		JMenu colorSchemeMenu = new JMenu("Color Scheme");
		
		_menuBar.add(colorSchemeMenu);
	}

	public void genEscapeDistanceMenu() {
		JMenu escapeDistanceMenu = new JMenu("Ecape Distance");
		
		escapeDistanceMenu.addSeparator();
		_currentEscapeDistance = new JMenuItem();
		_currentEscapeDistance.setEnabled(false);
		escapeDistanceMenu.add(_currentEscapeDistance);
		
		escapeDistanceMenu.addSeparator();
		JButton escapeDistanceSetter = new JButton("Set Escape Distance");
		escapeDistanceSetter.addActionListener(new SetEscapeDistanceButtonListener(_model, this));
		escapeDistanceMenu.add(escapeDistanceSetter);
		
		_menuBar.add(escapeDistanceMenu);
	}

	public void genFractalTypeMenu() {

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
		
		
		fractal1.addActionListener(new FractalTypeMenuListener(_model, 1));
		fractal2.addActionListener(new FractalTypeMenuListener(_model, 2));
		fractal3.addActionListener(new FractalTypeMenuListener(_model, 3));
		fractal4.addActionListener(new FractalTypeMenuListener(_model, 4));
		
		fractalTypeMenu.add(fractal1);
		fractalTypeMenu.add(fractal2);
		fractalTypeMenu.add(fractal3);
		fractalTypeMenu.add(fractal4);
		
		fractal1.setSelected(true);
		
		_menuBar.add(fractalTypeMenu);
	}
	
	public void EscapeDistancePrompt(){
		int inputNum = 0;
		String input = JOptionPane.showInputDialog(_window,"Enter a Positive Integer: ");
		if(input != null){
			try {
				inputNum = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(_window, "That was not a valid input.");
				EscapeDistancePrompt();
			}
		}
		if(inputNum > 0){
			_model.setEscapeDistance(inputNum);
			update();
		}else if(inputNum < 0){
			JOptionPane.showMessageDialog(_window, "Please Enter a POSITIVE Integer... ");
		}
	}
	
	@Override
	public void update() {
		_currentEscapeDistance.setText("Current Escape Distance: " + _model.getEscapeDistance());
		
	}
	
}
