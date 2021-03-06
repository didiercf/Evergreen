package com.evergreen.titz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Traits {
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
		GOLD("Gold armor", "chest_male_gold.png");
		
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
		GOLD_PANTS("Gold pants", "golden_greaves_male.png");
		
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
		METAL_BOOTS("Metal boots", "metal_boots_male.png"),
		GOLD_BOOTS("Gold boots", "golden_boots_male.png");
		
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

	public enum EnumSkins {
		LIGHT_MALE("Light", "light.png", Genders.MALE),
		TANNED_MALE("Tanned", "tanned.png", Genders.MALE),
		TANNED_MALE_2("Tanned 2", "tanned2.png", Genders.MALE),
		DARK_MALE("Dark", "dark.png", Genders.MALE),
		DARK_MALE_2("Dark 2", "dark2.png", Genders.MALE),
		DARK_ELF_MALE("Dark Elf", "darkelf.png", Genders.MALE),
		DARK_ELF_MALE_2("Dark Elf 2", "darkelf2.png", Genders.MALE),
		ORC_MALE("Orc", "orc.png", Genders.MALE),
		RED_ORC_MALE("Red Orc", "red_orc.png", Genders.MALE),
		SKELETON_MALE("Skeleton", "skeleton.png", Genders.MALE),
		DEFAULT_FEMALE("Tanned", "tanned.png", Genders.FEMALE);

		public final String name, path;
		public final Genders gender;

		private Texture texture;

		/**
		 * Returns the texture, lazy-loaded
		 */
		public Texture getTexture() {
			if (texture == null)
				texture = new Texture(Gdx.files.internal("body/" + gender.commonName + "/" + path));

			return texture;
		}

		EnumSkins(String name, String path, Genders gender) {
			this.name = name;
			this.path = path;
			this.gender = gender;
		}
	}
}
