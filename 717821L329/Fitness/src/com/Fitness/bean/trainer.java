package com.Fitness.bean;

public class trainer {
	String trainer_name;
    String training;
    String trainer_gender;
    int trainer_id;
     double fee;
	public trainer(String trainer_name, String training, String trainer_gender, int trainer_id, double fee) {
		super();
		this.trainer_name = trainer_name;
		this.training = training;
		this.trainer_gender = trainer_gender;
		this.trainer_id = trainer_id;
		this.fee = fee;
	}
	public String getTrainer_name() {
		return trainer_name;
	}
	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}
	public String getTraining() {
		return training;
	}
	public void setTraining(String training) {
		this.training = training;
	}
	public String getTrainer_gender() {
		return trainer_gender;
	}
	public void setTrainer_gender(String trainer_gender) {
		this.trainer_gender = trainer_gender;
	}
	public int getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
}
