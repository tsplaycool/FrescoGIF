package com.wpstan.fresco.gif;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;

public class PrefetchGIFListView extends ListView {
	private int lastPrefetch;
	private final int NUM = 3;

	public PrefetchGIFListView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public PrefetchGIFListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public PrefetchGIFListView(Context context) {
		super(context);
	}

	private void init() {
		setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				Log.d("tanshuai", "prefetch num:"
						+ (firstVisibleItem + visibleItemCount));
				int index = firstVisibleItem + visibleItemCount;
				if (getAdapter() != null
						&& index + NUM < getAdapter().getCount()
						&& index + NUM != lastPrefetch)
					// for (int i = 0; i < NUM; i++) {
					// Fresco.getImagePipeline().prefetchToDiskCache(
					// ImageRequestBuilder.newBuilderWithSource(
					// Uri.parse(getAdapter().getItem(index + NUM)
					// .toString())).build(), null);

					// }

					lastPrefetch = index + NUM;
			}
		});
	}
}
