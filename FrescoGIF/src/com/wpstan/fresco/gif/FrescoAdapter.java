package com.wpstan.fresco.gif;

import java.util.List;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class FrescoAdapter extends BaseAdapter {
	private Context mContext;
	private List<String> mList;

	public FrescoAdapter(Context context, List<String> list) {
		mContext = context;
		mList = list;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(mContext)
				.inflate(R.layout.item, null);
		SimpleDraweeView view = (SimpleDraweeView) convertView
				.findViewById(R.id.view);
		ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(
				Uri.parse(mList.get(position))).build();
		DraweeController controller = Fresco.newDraweeControllerBuilder()
				.setImageRequest(imageRequest).setAutoPlayAnimations(true)
				.build();
		view.setController(controller);
		// Log.d("tanshuai", "url:" + mList.get(position));
		return convertView;
	}

}
