package NIIT;

import java.io.Serializable;

public class Sclass implements Serializable {
	public transient Thread newThread;     //помните, что поток(поток параллельного исполнения) по умолчанию не cериализуемый класс
	private String studentID;
	private int sum;
}