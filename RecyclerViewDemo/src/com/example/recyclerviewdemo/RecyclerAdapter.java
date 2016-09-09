package com.example.recyclerviewdemo;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.recyclerviewdemo.RecyclerAdapter.ItemViewHolder;

public class RecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> 
{
	private List<Person> personList;

	interface OnRecyclerViewItemClickListener 
	{
		void onClick(View view, int position);
	};

	private OnRecyclerViewItemClickListener listener;

	public void setListener(OnRecyclerViewItemClickListener listener)
	{
		this.listener = listener;
	}

	public RecyclerAdapter(List<Person> personList)
	{
		this.personList = personList;
	}

	@Override
	public int getItemCount() 
	{
		return personList.size();
	}

	public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) 
	{
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
		return new ItemViewHolder(view);
	}

	public void onBindViewHolder(final ItemViewHolder viewHolder,final int position) 
	{
		Person person = personList.get(position);
		viewHolder.img.setImageResource(person.getImg());
		viewHolder.name.setText(person.getName());
		viewHolder.itemView.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				if (listener != null)
				{
					listener.onClick(viewHolder.itemView, position);
				}
			}
		});
	}
	
	class ItemViewHolder extends RecyclerView.ViewHolder
	{
		ImageView img;
		TextView name;
		public ItemViewHolder(View itemView)
		{
			super(itemView);
			img = (ImageView) itemView.findViewById(R.id.img);
			name = (TextView) itemView.findViewById(R.id.name);
		}
	}
}
