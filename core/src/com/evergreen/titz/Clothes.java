package com.evergreen.titz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Clothes {
	public enum EnumHeadWear {
		METAL_HELM("Metal helm", "metal_helm_male.png"),
		GOLD_HELM("Gold Helm", "golden_helm_male.png"),
		CHAINHAT("Chain Hat", "chainhat_male.png");
		
		public final String name, path;
		
		private Texture texture;
		
		/**
		 * Returns the texture, lazy-loaded
		 */
		public Texture getTexture() {
			if(texture == null)
				texture = new Texture(Gdx.files.internal("head/" + path));
			return texture;
		}
		
		EnumHeadWear(String name, String path) {
			this.name = name;
			this.path = path;
		}
	}
	
	public enum EnumChestWear {
		LEATHER_JACKET("Leather Jacket", "chest_male_leather.png"),
		GOLD("Gold", "chest_male_gold.png");
		
		public final String name, path;
		
		private Texture texture;
		
		/**
		 * Returns the texture, lazy-loaded
		 */
		public Texture getTexture() {
			if(texture == null)
				texture = new Texture(Gdx.files.internal("chest/" + path));
			return texture;
		}
		
		EnumChestWear(String name, String path) {
			this.name = name;
			this.path = path;
		}
	}
	
	public enum EnumLegWear {
		METAL_PANTS("Metal pants", "metal_pants_male.png"),
		GOLD_PANTS("Gold Pants", "golden_greaves_male.png");
		
		public final String name, path;
		
		private Texture texture;
		
		/**
		 * Returns the texture, lazy-loaded
		 */
		public Texture getTexture() {
			if(texture == null)
				texture = new Texture(Gdx.files.internal("legs/" + path));
			return texture;
		}
		
		EnumLegWear(String name, String path) {
			this.name = name;
			this.path = path;
		}
	}
	
	public enum EnumFootWear {
		METAL_BOOTS("Metal boots", "metal_boots_male.png");
		
		public final String name, path;
		
		private Texture texture;
		
		/**
		 * Returns the texture, lazy-loaded
		 */
		public Texture getTexture() {
			if(texture == null)
				texture = new Texture(Gdx.files.internal("feet/" + path));
			return texture;
		}
		
		EnumFootWear(String name, String path) {
			this.name = name;
			this.path = path;
		}
	}
}