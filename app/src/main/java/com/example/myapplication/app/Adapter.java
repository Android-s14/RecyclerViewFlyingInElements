package com.example.myapplication.app;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

	List<String> data = makeData();
	private MainActivity context;

	public Adapter(MainActivity mainActivity) {
		context = mainActivity;
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		TextView textView = new TextView(context);

		public ViewHolder(View itemView) {
			super(itemView);
			LinearLayout.LayoutParams params =
					new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
					                              ViewGroup.LayoutParams.WRAP_CONTENT);
			params.setMargins(10, 10, 10, 10);
			textView.setLayoutParams(params);
			((LinearLayout) itemView).addView(textView);
		}
	}

	private List<String> makeData() {
		List<String> data = new ArrayList<>();
		data.add("node1");
		data.add("node2");
		data.add("node3");
		data.add("node4");
		data.add("node5");
		data.add("node6");
		return data;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LinearLayout externalView = new LinearLayout(context);
		RecyclerView.LayoutParams params =
				new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				                              ViewGroup.LayoutParams.WRAP_CONTENT);
		params.setMargins(10, 10, 10, 10);
		externalView.setLayoutParams(params);
		return new ViewHolder(externalView);
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		String element = data.get(position);
		holder.textView.setText(element);
		holder.itemView.setX(-100);
		holder.itemView.setY(2000);
		holder.itemView.setRotation(30);
		holder.itemView.setAlpha(0f);

		holder.itemView.animate()
		               .alpha(1f)
		               .x(20f)
		               .y(20f * 2 * position)
		               .rotation(0f)
		               .setDuration(1000);
	}

	@Override
	public int getItemCount() {
		return data.size();
	}
}
