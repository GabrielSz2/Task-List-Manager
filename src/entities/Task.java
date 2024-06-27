package entities;

public class Task {

	private String task;
	private Boolean stats;
	
	public Task(String task) {
		this.task = task;
		this.stats = false;
	}

	public String getTask() {
		return task;
	}

	public boolean getStats() {
		return stats;
	}

	public void obtainTask(String task, Boolean stats){
		this.task = task;
		this.stats = stats;
	}
	
	public void concluded() {
		stats = true;
	}
	
	@Override
	public String toString() {
		if (stats == true) {
			return task + " [concluido]";
		}
		return task + " [pendente]";	
	}
	
}
