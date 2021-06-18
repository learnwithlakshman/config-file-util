package com.careerit.excel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Player {
	
	private long id;
	private String name;
	private String role;
	private double price;
	private String label;

}

/*
 *
 * public class Player {

	private long id;
	private String name;
	private String role;
	private double price;
	private String label;

	private Player(PlayerBuilder pb) {
		this.id = pb.id;
		this.name = pb.name;
		this.price = pb.price;
		this.role = pb.role;
		this.label = pb.label;
	}
	public static PlayerBuilder builder() {
		return new PlayerBuilder();
	}
	public static class PlayerBuilder {
		private long id;
		private String name;
		private String role;
		private double price;
		private String label;

		public PlayerBuilder id(long id) {
			this.id = id;
			return this;
		}

		public PlayerBuilder name(String name) {
			this.name = name;
			return this;
		}

		public PlayerBuilder role(String role) {
			this.role = role;
			return this;
		}

		public PlayerBuilder price(double price) {
			this.price = price;
			return this;
		}

		public PlayerBuilder label(String label) {
			this.label = label;
			return this;
		}

		public Player build() {
			return new Player(this);
		}
	}
}
 */
