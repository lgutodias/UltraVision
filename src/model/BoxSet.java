/**
 * @author diego
 */

package model;

import interfaces.TV;

public final class BoxSet extends Titles implements TV<BoxSet> {
		
		//Attribute
		private int season;
		
		//Getters and Setters
		@Override
		public int getSeason() {
			return season;
		}
		@Override
		public BoxSet setSeason(int season) {
			this.season = season;
			return this;
		}
		@Override
		public String toString() {
			return "BoxSet [season=" + season + "]";
		}
		
				
		
	}
	
	


