package com.generic;

 public class Box {
	
	private Object object;

	public Object getObject() {
		return object;	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	
	public static void main(String[] args) {
		Box box = new Box();
		box.setObject("");
		box.setObject(Integer.MAX_VALUE);
	}
}
public class Box<T> {
	
	private T t;

	public T getObject() {
		return t;
	}

	public void setObject(T t) {
		this.t = t;
	}
	
	
	public static void main(String[] args) {
		
		Maker<String, Integer> chair = new Chair<String, Integer>("Star", 4);
		System.out.println("Key : "+chair.getKey()+" and value :"+ chair.getValue());
		
		Maker<String, Integer> chair2 = new Chair<String, Integer>("Star", 4);
		System.out.println("Key : "+chair2.getKey()+" and value :"+ chair2.getValue());
		
		System.out.println("Is equals : " + new Util().compare(chair, chair2));
		
		Maker<String, Integer> chair3 = new Chair<String, Integer>("Star", 4);
		System.out.println("Key : "+chair2.getKey()+" and value :"+ chair2.getValue());
		
		
	} 
}

interface Maker<K, V extends Number>{
	
	public K getKey();
	public V getValue();
}

class Chair<K, V extends Number> implements Maker<K, V>{

	private K key;
	private V value;
	
	public Chair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
}

class Util {
	
	public <K, V extends Number> boolean compare(Maker<K, V> m1, Maker<K, V> m2) {
		
		return m1.getKey().equals(m2.getKey()) && m1.getValue().equals(m2.getValue());
		
	}
}

