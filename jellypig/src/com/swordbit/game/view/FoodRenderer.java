package com.swordbit.game.view;

import java.util.List;
import java.util.Iterator;
import com.swordbit.game.model.World;
import com.swordbit.game.model.food.Food;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// Food Renderer is a helper class that is controlled entirely by WorldRenderer

public class FoodRenderer {
	private World world;
	
	public FoodRenderer(World world) {
		this.world = world;
	}
	
	public void drawFood(SpriteBatch spriteBatch) {
		List<Food> foodList = world.getFood();	
		if (!(foodList == null)) 
			 drawFoodListItems(spriteBatch, foodList);
	}
	
	private void drawFoodListItems(SpriteBatch spriteBatch, 
									List<Food> foodList) {
		Iterator<Food> it = foodList.iterator();
		while (it.hasNext()) {
			Food foodItem = it.next();
			drawFoodItem(spriteBatch, foodItem);
		}	
	}
	
	public void drawFoodItem(SpriteBatch spriteBatch, Food food) {			
		spriteBatch.draw(food.foodTexture, 
						food.getBounds().x,
						food.getBounds().y, 
						food.getBounds().width,
						food.getBounds().height);
	}
}
