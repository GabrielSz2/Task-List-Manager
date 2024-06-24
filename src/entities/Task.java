package entities;

import entities.enums.Stats;

public class Task {

	private String task;
	private Stats stats;
	
	public Task(String task, Stats stats) {
		this.task = task;
		this.stats = stats;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	
	
	
	
	
}
