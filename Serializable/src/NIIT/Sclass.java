package NIIT;

import java.io.Serializable;

public class Sclass implements Serializable {
	public transient Thread newThread;     //�������, ��� �����(����� ������������� ����������) �� ��������� �� c������������ �����
	private String studentID;
	private int sum;
}