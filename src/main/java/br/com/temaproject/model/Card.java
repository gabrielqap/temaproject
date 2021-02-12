package br.com.temaproject.model;

public class Card {
	private int id;
	
	private String name;
	
	private String description;
	
	private int attack;
	
	private int defense;
	
	private Class cardClass;
	
	private Type type;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class getCardClass() {
		return cardClass;
	}

	public void setCardClass(Class cardClass) {
		this.cardClass = cardClass;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
