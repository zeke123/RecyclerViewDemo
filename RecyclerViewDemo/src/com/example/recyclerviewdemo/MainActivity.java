package com.example.recyclerviewdemo;

import java.util.ArrayList;

import com.example.recyclerviewdemo.RecyclerAdapter.OnRecyclerViewItemClickListener;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private RecyclerView mRecyclerView;

	private ArrayList<Person> personList = new ArrayList<Person>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initDatas();
		initViews();

	}

	private void initViews() {
		mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);

		// �½�������
		RecyclerAdapter adapter = new RecyclerAdapter(personList);
		// ���ü�����
		adapter.setListener(new OnRecyclerViewItemClickListener() {

			@Override
			public void onClick(View view, int position) {
				Toast.makeText(getApplicationContext(),
						personList.get(position).getName(), Toast.LENGTH_LONG)
						.show();
			}
		});
		// ����������
		mRecyclerView.setAdapter(adapter);

		// Ĭ�϶���Ч��
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		// ���ò��ֹ�����������������Ϊ�Ƿ����򲼾�
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
				LinearLayoutManager.HORIZONTAL, false));
		// ����ÿһ���װ�Σ������������ָ���
		mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
			Paint paint = new Paint();

			@Override
			public void onDraw(Canvas c, RecyclerView parent,RecyclerView.State state) {
				super.onDraw(c, parent, state);
			}

			@Override
			public void onDrawOver(Canvas c, RecyclerView parent,
					RecyclerView.State state) {
				super.onDrawOver(c, parent, state);
				paint.setColor(Color.LTGRAY);
				for (int i = 0, size = parent.getChildCount(); i < size; i++) {
					View child = parent.getChildAt(i);
					c.drawLine(child.getLeft(), child.getBottom(),
							child.getRight(), child.getBottom(), paint);
				}
			}

		});
		// �������Ч��
		mRecyclerView.setHasFixedSize(true);

	}

	private void initDatas() {
		Person person;

		for (int i = 0; i < 10; i++) {
			person = new Person();
			person.setImg(R.drawable.managerimg);
			person.setName("����" + i);
			personList.add(person);
		}
	}
}
