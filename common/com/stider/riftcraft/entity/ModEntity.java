package com.stider.riftcraft.entity;

import com.stider.riftcraft.core.helper.EntityHelper;

public class ModEntity {

	public static void init(){
		EntityHelper.registerEntity(EntityShadow.class, "Rift shadow", 0xFF0000, 0xFF0000);
	}
}
