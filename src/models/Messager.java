package models;

import java.io.Serializable;

public class Messager implements Serializable{
	private static final long serialVersionUID = 1L;
	private String text;
	private Object obj1;
	private Object obj2;
	
	public Messager() {
		this.text = ""; 
	}
	
	public Messager(String text) {
		this.text = text;
	}
	 
	public Messager(String text, Object object) {
		this.text = text; 
		this.obj1 = object;
	}
	public Messager(String text, Object obj1, Object obj2 ) {
		this.text = text;
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	public String toString() {
		return "Messager[\n" +"\ttext='" + text +'\'' + '\n' +
				((obj1 != null) ? "\tObject1 = " + obj1 + '\n' : "") +
				((obj1 != null) ? "\tObject2 = " + obj2 + '\n' : "") +
				']';
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Object getObj1() {
		return obj1;
	}

	public void setObj1(Object obj1) {
		this.obj1 = obj1;
	}

	public Object getObj2() {
		return obj2;
	}

	public void setObj2(Object obj2) {
		this.obj2 = obj2;
	}
	
	
}
