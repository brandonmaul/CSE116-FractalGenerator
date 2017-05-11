package model;

import javax.swing.SwingWorker;

import edu.buffalo.fractal.WorkerResult;

public class MultiThreadingTool extends SwingWorker<WorkerResult, Void>{
	
	private Model _model;
	
	public MultiThreadingTool(Model m){
		_model = m;
	}
	
	@Override
	protected WorkerResult doInBackground() throws Exception {
		return new WorkerResult(getProgress(), _model.generateFractal());
	}

}
