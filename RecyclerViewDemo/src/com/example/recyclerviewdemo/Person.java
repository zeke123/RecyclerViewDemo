package com.example.recyclerviewdemo;

public class Person 
{
	private int img;
	private String name;
	public int getImg()
	{
		return img;
	}
	public void setImg(int img)
	{
		this.img = img;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	@Override
	public String toString() 
	{
		return "Person [img=" + img + ", name=" + name + "]";
	}
}
