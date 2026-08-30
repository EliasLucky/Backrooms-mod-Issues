package com.skittle.backrooms.world.features;

import java.lang.reflect.Field;
import java.util.List;

import com.skittle.backrooms.utils.Utils;

import net.minecraft.world.gen.structure.template.Template;

public class TemplateUnwrapper
{
	private List<Template.BlockInfo> blockInfoList;
	private List<Template.EntityInfo> entityInfoList;
	
	public TemplateUnwrapper(Template template_)
	{
		try
		{
			Field field = Utils.getSecureField(Template.class, 0);
			if (field.getType() == List.class) {
				this.blockInfoList = (List<Template.BlockInfo>)field.get(template_);
			}
			Field f = Utils.getSecureField(Template.class, 1);
			if (f.getType() == List.class) {
				this.entityInfoList = (List<Template.EntityInfo>)f.get(template_);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Template.BlockInfo> getBlockInfoList() {
		return this.blockInfoList;
	}
	
	public List<Template.EntityInfo> getEntityInfoList() {
		return this.entityInfoList;
	}
}
