package ui;

import model.*;
import observer_pattern.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import edu.buffalo.fractal.FractalPanel;

public class UI implements Observer{
	
	Model _model;
	JFrame _window;
	JPanel _generatePanel;
	FractalPanel _fractalPanel;
	JButton _generateButton;
	JMenuItem _currentEscapeDistance;
	JMenuBar _menuBar;
	
	public UI(Model m){
		_model = m;
		_model.addObserver(this);
		initUI();
	}
	
	public void initUI(){

		_window = new JFrame("Fractal Generator");
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		_menuBar = new JMenuBar();
		
		_fractalPanel = new FractalPanel();
		_fractalPanel.setVisible(false);
		
		_generatePanel = new JPanel();
		_generatePanel.setLayout(new CardLayout(150,200));
		_generateButton = new JButton("Generate Fractal");
		_generateButton.addActionListener(new GenerateButtonListener(this));
		_generatePanel.add(_generateButton);

		genFileMenu();
		genFractalTypeMenu();
		genEscapeDistanceMenu();
		genColorSchemeMenu();
		
		_window.setJMenuBar(_menuBar);
		_window.add(_generatePanel);
		_window.setSize(600, 600);
		_window.setVisible(true);
	}

	public void genFileMenu(){
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem newFractal = new JMenuItem("Clear");
		newFractal.addActionListener(new newFractalListener(this));
		fileMenu.add(newFractal);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
	            System.exit(0);
	        }
		});
		
		fileMenu.add(exit);
		
		_menuBar.add(fileMenu);
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
		
		
		fractal1.addActionListener(new FractalTypeMenuListener(_model, this, 1));
		fractal2.addActionListener(new FractalTypeMenuListener(_model, this, 2));
		fractal3.addActionListener(new FractalTypeMenuListener(_model, this, 3));
		fractal4.addActionListener(new FractalTypeMenuListener(_model, this, 4));
		
		fractalTypeMenu.add(fractal1);
		fractalTypeMenu.add(fractal2);
		fractalTypeMenu.add(fractal3);
		fractalTypeMenu.add(fractal4);
		
		fractal1.setSelected(true);
		
		_menuBar.add(fractalTypeMenu);
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

	public void genColorSchemeMenu() {
		JMenu colorSchemeMenu = new JMenu("Color Scheme");
		
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem colorScheme1 = new JRadioButtonMenuItem("Rainbow");
		JRadioButtonMenuItem colorScheme2 = new JRadioButtonMenuItem("Blues");
		JRadioButtonMenuItem colorScheme3 = new JRadioButtonMenuItem("Grey");
		JRadioButtonMenuItem colorScheme4 = new JRadioButtonMenuItem("Custom");
		
		group.add(colorScheme1);
		group.add(colorScheme2);
		group.add(colorScheme3);
		group.add(colorScheme4);
		
		colorScheme1.addActionListener(new ColorSchemeMenuListener(_model, this, ColorModelFactory.createRainbowColorModel(256)));
		colorScheme2.addActionListener(new ColorSchemeMenuListener(_model, this, ColorModelFactory.createBluesColorModel(256)));
		colorScheme3.addActionListener(new ColorSchemeMenuListener(_model, this, ColorModelFactory.createGrayColorModel(256)));
		colorScheme4.addActionListener(new ColorSchemeMenuListener(_model, this, ColorModelFactory.createLamaColorModel(256)));
		
		colorSchemeMenu.add(colorScheme1);
		colorSchemeMenu.add(colorScheme2);
		colorSchemeMenu.add(colorScheme3);
		colorSchemeMenu.add(colorScheme4);
		
		colorScheme1.doClick();
		
		_menuBar.add(colorSchemeMenu);
	}
	
	public void escapeDistancePrompt(){
		int inputNum = 0;
		String input = JOptionPane.showInputDialog(_window,"Enter a Positive Integer: ");
		if(input != null){
			try {
				inputNum = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(_window, "That was not a valid input.");
				escapeDistancePrompt();
			}
		}
		if(inputNum > 0){
			_model.setEscapeDistance(inputNum);
			update();
		}else if(inputNum < 0){
			JOptionPane.showMessageDialog(_window, "Please Enter a POSITIVE Integer... ");
			escapeDistancePrompt();
		}
	}
	
	public void displayFractal(){
		_generatePanel.setVisible(false);
		_window.remove(_generatePanel);
		_window.add(_fractalPanel);
		_fractalPanel.setVisible(true);
	}
	
	public void clearFractal(){
		_window.remove(_fractalPanel);
		_fractalPanel.setVisible(false);
		_window.add(_generatePanel);
		_generatePanel.setVisible(true);
	}
	
	public void update() {
		_currentEscapeDistance.setText("Current Escape Distance: " + _model.getEscapeDistance());
		_fractalPanel.setIndexColorModel(_model.getColorModel());
		_fractalPanel.updateImage(_model.generateFractal());
	}
	
}
