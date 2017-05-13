package ui;

import model.*;
import observer_pattern.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

import edu.buffalo.fractal.*;

/**
 * 
 * @author Brandon Maul
 * 
 * This UI Class specifies the interface for which the user will generate the fractals. It contains a menu bar
 * which is used for manipulation of the fractals and updates the displayed fractal in real time.
 * Within this menu bar is also a 'File' menu which can be used to reset the fractal to default
 * settings or exit the program entirely.
 *
 */
public class UI implements Observer{
	
	Model _model;
	JFrame _window;
	FractalPanel _fractalPanel;
	JMenuItem _currentWindowSize;
	JMenuItem _currentThreadCount;
	JMenuItem _currentEscapeDistance;
	JMenuItem _currentMaxEscapeTime;
	JMenuItem _currentZoomCoords;
	JMenuBar _menuBar;
	
	MouseEvent _zoomBox;
	
	SwingWorker<WorkerResult, Void>[] _workerArray;
	ComputePool _computePool;
	
	/**
	 * 
	 * @param m a Model object that this class will maintain a reference to, allowing the user inputs to affect the model.
	 * 
	 */
	public UI(Model m){
		_model = m;
		_workerArray = _model.getWorkers();
		_computePool = new ComputePool();
		_model.addObserver(this);
		initUI();
		
	}
	
	/**
	 * Initialization method for the interface. Creates the javax.swing elements. 
	 */
	public void initUI(){

		_window = new JFrame("Fractal Generator");
		_window.setSize(new Dimension(_model.getGridSize() / 2, _model.getGridSize() / 2));
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_menuBar = new JMenuBar();
		
		_fractalPanel = new FractalPanel();
		_fractalPanel.setSize(new Dimension(_model.getGridSize(), _model.getGridSize()));
		
		ZoomBoxListener listener = new ZoomBoxListener(_model, this, _fractalPanel);
		_fractalPanel.addMouseListener(listener);
		_fractalPanel.addMouseMotionListener(listener);
		
		_computePool.changePanel(_fractalPanel); //fractalPanel and computePool have relationship now. <3
		
		
		initFileMenu();
		initWindowMenu();
		initWorkerMenu();
		initFractalTypeMenu();
		initEscapeDistanceMenu();
		initMaxEscapeTimeMenu();
		initZoomMenu();
		initColorSchemeMenu();
		
		updateFractal();
		
		
		_window.setJMenuBar(_menuBar);
		_window.add(_fractalPanel);
		_window.setResizable(false);
		_window.setVisible(true);
		
	
	}

	/**
	 * Sub-initialization method for the 'File' menu in the menu bar. 
	 */
	public void initFileMenu(){
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem newFractal = new JMenuItem("Clear");
		newFractal.addActionListener(new ClearButtonListener(this));
		
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
	            System.exit(0);
	        }
		});
		
		fileMenu.add(newFractal);
		fileMenu.add(exit);
		
		_menuBar.add(fileMenu);
	}
	
	/**
	 * Sub-initialization method for the 'Window' menu in the menu bar. 
	 */
	public void initWindowMenu(){
		JMenu windowMenu = new JMenu("Size");
		
		windowMenu.addSeparator();
		_currentWindowSize = new JMenuItem();
		_currentWindowSize.setEnabled(false);
		windowMenu.add(_currentWindowSize);
		
		windowMenu.addSeparator();
		JButton windowSizeSetter = new JButton("Set Fractal Size");
		windowSizeSetter.addActionListener(new SetWindowSizeListener(this));
		windowSizeSetter.setEnabled(false); //TURNED THIS OFF BECAUSE I DONT WANT TO IMPLEMENT IT YET
		windowMenu.add(windowSizeSetter);
		
		_menuBar.add(windowMenu);
	}
	
	/**
	 * Sub-initialization method for the 'Window' menu in the menu bar. 
	 */
	public void initWorkerMenu(){
		JMenu windowMenu = new JMenu("Workers");
		
		windowMenu.addSeparator();
		_currentThreadCount = new JMenuItem();
		_currentThreadCount.setEnabled(false);
		windowMenu.add(_currentThreadCount);
		
		windowMenu.addSeparator();
		JButton threadCountSetter = new JButton("Set Worker Count");
		threadCountSetter.addActionListener(new SetWorkerCountListener(_model, this));
		windowMenu.add(threadCountSetter);
		
		_menuBar.add(windowMenu);
	}
	
	/**
	 * Sub-initialization method for the 'Fractal Type' menu in the menu bar. 
	 */
	public void initFractalTypeMenu() {

		JMenu fractalTypeMenu = new JMenu("Fractal Type");
		
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem fractal1 = new JRadioButtonMenuItem("Mandelbrot");
		JRadioButtonMenuItem fractal2 = new JRadioButtonMenuItem("Julia");
		JRadioButtonMenuItem fractal3 = new JRadioButtonMenuItem("Burning Ship");
		JRadioButtonMenuItem fractal4 = new JRadioButtonMenuItem("Multibrot");
		
		group.add(fractal1);
		group.add(fractal2);
		group.add(fractal3);
		group.add(fractal4);
		
		
		fractal1.addActionListener(new FractalTypeMenuListener(_model, this));
		fractal2.addActionListener(new FractalTypeMenuListener(_model, this));
		fractal3.addActionListener(new FractalTypeMenuListener(_model, this));
		fractal4.addActionListener(new FractalTypeMenuListener(_model, this));
		
		fractalTypeMenu.add(fractal1);
		fractalTypeMenu.add(fractal2);
		fractalTypeMenu.add(fractal3);
		fractalTypeMenu.add(fractal4);
		
		fractal1.setSelected(true);
		
		_menuBar.add(fractalTypeMenu);
	}
	
	/**
	 * Sub-initialization method for the 'Escape Distance' menu in the menu bar. 
	 */
	public void initEscapeDistanceMenu() {
		JMenu escapeDistanceMenu = new JMenu("Escape Distance");
		
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
	
	/**
	 * Sub-initialization method for the 'Color Scheme' menu in the menu bar. 
	 */
	public void initColorSchemeMenu() {
		JMenu colorSchemeMenu = new JMenu("Color");
		
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem colorScheme1 = new JRadioButtonMenuItem("Rainbow");
		JRadioButtonMenuItem colorScheme2 = new JRadioButtonMenuItem("Blues");
		JRadioButtonMenuItem colorScheme3 = new JRadioButtonMenuItem("Grey");
		JRadioButtonMenuItem colorScheme4 = new JRadioButtonMenuItem("Hawaii");
		
		group.add(colorScheme1);
		group.add(colorScheme2);
		group.add(colorScheme3);
		group.add(colorScheme4);
		
		colorScheme1.addActionListener(new ColorSchemeMenuListener(_model, this, ColorModelFactory.createRainbowColorModel(_model.getMaxPasses() + 1)));
		colorScheme2.addActionListener(new ColorSchemeMenuListener(_model, this, ColorModelFactory.createBluesColorModel(_model.getMaxPasses() + 1)));
		colorScheme3.addActionListener(new ColorSchemeMenuListener(_model, this, ColorModelFactory.createGrayColorModel(_model.getMaxPasses() + 1)));
		colorScheme4.addActionListener(new ColorSchemeMenuListener(_model, this, ColorModelFactory.createLamaColorModel(_model.getMaxPasses() + 1)));
		
		colorSchemeMenu.add(colorScheme1);
		colorSchemeMenu.add(colorScheme2);
		colorSchemeMenu.add(colorScheme3);
		colorSchemeMenu.add(colorScheme4);
		
		colorScheme1.doClick();
		
		_menuBar.add(colorSchemeMenu);
	}
	
	/**
	 * Sub-initialization method for the 'Max Escape Time' menu in the menu bar. 
	 */
	public void initMaxEscapeTimeMenu() {
		JMenu maxEscapeTimeMenu = new JMenu("Max Escape Time");
		
		maxEscapeTimeMenu.addSeparator();
		_currentMaxEscapeTime = new JMenuItem();
		_currentMaxEscapeTime.setEnabled(false);
		maxEscapeTimeMenu.add(_currentMaxEscapeTime);
		
		maxEscapeTimeMenu.addSeparator();
		JButton maxEscapeTimeSetter = new JButton("Set Maximum Escape Time");
		maxEscapeTimeSetter.addActionListener(new SetEscapeTimeButtonListener(_model, this));
		maxEscapeTimeMenu.add(maxEscapeTimeSetter);
		
		_menuBar.add(maxEscapeTimeMenu);
	}
	
	/**
	 * Sub-initialization method for the 'Zoom' menu in the menu bar. 
	 */
	private void initZoomMenu() {
		JMenu zoomMenu = new JMenu("Zoom");
		
		zoomMenu.addSeparator();
		JButton zoomResetButton = new JButton("Reset Zoom");
		zoomResetButton.addActionListener(new ResetZoomListener(_model, this));
		zoomMenu.add(zoomResetButton);
		
		_menuBar.add(zoomMenu);
		
	}
	
	/**
	 * Method that displays the prompt for entering an escape distance, then checks to see if it was valid.
	 * 
	 * If input is valid, calls _model.setEscapeDistance() to update the escape distance in the model.
	 */
	public void escapeDistancePrompt(){
		int inputNum = 0;
		String input = JOptionPane.showInputDialog(_window,"Enter a Positive Integer: ");
		if(input != null){
			try {
				inputNum = Integer.parseInt(input);
				if(inputNum > 0){
					_model.setEscapeDistance(inputNum);
					updateFractal();
				}else if(inputNum < 0){
					JOptionPane.showMessageDialog(_window, "Please Enter a POSITIVE Integer... ");
					escapeDistancePrompt();
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(_window, "That was not a valid input.");
				escapeDistancePrompt();
			}
		}
	}
	
	public void setWindowSizePrompt() {
		int inputNum = 0;
		String input = JOptionPane.showInputDialog(_window,"Enter a Positive Integer: ");
		if(input != null){
			try {
				inputNum = Integer.parseInt(input);
				if(inputNum > 0){
					_model.setGridSize(inputNum);
					updateFractal();
				}else if(inputNum < 0){
					JOptionPane.showMessageDialog(_window, "Please Enter a POSITIVE Integer... ");
					setWindowSizePrompt();
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(_window, "That was not a valid input.");
				setWindowSizePrompt();
			}
		}
	}
	
	/**
	 * Method that displays the prompt for entering the max escape time, then checks to see if it was valid.
	 * 
	 * If input is valid, calls _model.setMaxEscapeTime() to update the model.
	 */
	public void maxEscapeTimePrompt() {
		int inputNum = 0;
		String input = JOptionPane.showInputDialog(_window,"Enter a Integer between 1 and 255: ");
		if(input != null){
			try {
				inputNum = Integer.parseInt(input);
				if(inputNum >= 1 && inputNum <= 255){
					_model.setMaxEscapeTime(inputNum);
					updateFractal();
				}else if(inputNum < 1 || inputNum > 255){
					JOptionPane.showMessageDialog(_window, "Input must be between 1 and 255.");
					maxEscapeTimePrompt();
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(_window, "That was not a valid input.");
				maxEscapeTimePrompt();
			}
		}
	}
	
	/**
	 * Method that displays the prompt for entering the amount of threads to calculate the fractal with
	 * then checks to see if it was a valid input.
	 * 
	 * If input is valid, calls _model.setThreadCount() to update the model.
	 */
	public void workerCountPrompt() {
		int inputNum = 0;
		String input = JOptionPane.showInputDialog(_window,"Enter a number between 1 and 128: ");
		if(input != null){
			try {
				inputNum = Integer.parseInt(input);
				if(inputNum >= 1 && inputNum <= 128){
					_model.setWorkerCount(inputNum);
					updateFractal();
				}else{
					JOptionPane.showMessageDialog(_window, "Input must be between 1 and 128.");
					workerCountPrompt();
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(_window, "That was not a valid input.");
				workerCountPrompt();
			}
		}
	}
	
	/**
	 * Removes the FractalPanel object from display JFrame. Then goes ahead and resets the options to their default values.
	 */
	public void clearFractal(){
		_menuBar.getMenu(3).getItem(0).doClick();
		_menuBar.getMenu(7).getItem(0).doClick();
		_model.setEscapeDistance(2);
		_model.setMaxEscapeTime(255);
		_model.setDisplayRegion(0, 0, _model.getGridSize() - 1, _model.getGridSize() - 1);
		
		updateFractal();
	}
	
	/**
	 * Updates the display in the UI. Called whenever a change to the Model is made.
	 */
	public void updateFractal() {
		_computePool.clearPool();
		_currentWindowSize.setText("Current Fractal Size: " + _model.getGridSize() + " x " + _model.getGridSize());
		_currentThreadCount.setText("Current Number of Workers: " + _model.getWorkerCount());
		_currentEscapeDistance.setText("Current Escape Distance: " + _model.getEscapeDistance());
		_currentMaxEscapeTime.setText("Current Maximum Escape Time: " + _model.getEscapeTime());
		_fractalPanel.setIndexColorModel(_model.getColorModel());
		_computePool.generateFractal(_model.getGridSize(), _model.generateWorkerArray());
		
	}
}
