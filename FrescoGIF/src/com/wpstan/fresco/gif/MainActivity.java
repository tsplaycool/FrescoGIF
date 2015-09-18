package com.wpstan.fresco.gif;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends Activity {

	private List<String> mList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mList = new ArrayList<String>();
		// 14kb
		mList.add("https://s3.amazonaws.com/giphygifs/media/4aBQ9oNjgEQ2k/giphy.gif");
		// 8M
		mList.add("http://ta-ty-sho.com/wp-content/uploads/2015/04/gifki-gif-animatsia-multfilm-kot-v-sapogakh-i-t.gif");
		// 45kb
		mList.add("http://tupian.sucaitianxia.com/images/002/pic1077.jpg");
		mList.add("http://2.im.guokr.com/rVODbd1bZVLeUEUtgVyjzOtZmqq_YfoOB8_er2tIAb23AQAALAEAAEdJ.gif");
		// 800kb
		mList.add("http://bbs-img.25pp.com/data/attachment/forum/201410/21/21435336nmc4nng3l4a9n0.gif");
		mList.add("http://s1.dwstatic.com/group1/M00/68/97/7227c90985162c3de0635c1a7f468be4.gif");
		mList.add("http://s1.dwstatic.com/group1/M00/B1/50/4c08cc8c4e97e6c9e73f82156fa0a66b.gif");
		mList.add("https://www.gstatic.com/webp/animated/1.webp");
		mList.add("http://s1.dwstatic.com/group1/M00/B4/FD/a924c8594d704b29bb09dfb1363824bb.gif");
		mList.add("http://s1.dwstatic.com/group1/M00/06/C2/abfac00ce9d1c06142ff4b4d666bc629.gif");
		mList.add("http://s1.dwstatic.com/group1/M00/DC/B0/96bb4ca7719104fb15c72880fc3ed0d4.gif");
		mList.add("http://s1.dwstatic.com/group1/M00/FB/55/45cc721c7f35ee5b88b674b8095459e2.gif");
		mList.add("http://s1.dwstatic.com/group1/M00/4F/69/f331d13db5c67fbf63c44f9031cd2b48.gif");
		mList.add("http://s1.dwstatic.com/group1/M00/F6/50/16f0bb5f07995ff1c5d9f4406d0e18d3.gif");
		mList.add("http://s1.dwstatic.com/group1/M00/20/BB/8debc31922a3433639362421cf2a3d1e.gif");
		mList.add("http://s1.dwstatic.com/group1/M00/BC/ED/fbe10ba4f8f0618dcfd4bce9175be533.gif");
		mList.add("http://s1.dwstatic.com/group1/M00/40/4D/9e34745eb8e539b4462f4f635714f515.gif");
		mList.add("http://s1.dwstatic.com/group1/M00/2F/75/3decce1c4b5655d9c878cdf701d80490.gif");

		ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
				.build();
		Fresco.initialize(this, config);
		// for (int i = 0; i < mList.size(); i++) {
		// Fresco.getImagePipeline().prefetchToBitmapCache(
		// ImageRequestBuilder.newBuilderWithSource(
		// Uri.parse(mList.get(i))).build(), null);
		//
		// }
		setContentView(R.layout.activity_main);
		initViews();
	}

	protected Context mContext;
	protected PrefetchGIFListView mListview;

	private void initViews() {
		mContext = this;
		mListview = (PrefetchGIFListView) findViewById(R.id.listview);
		mListview.postDelayed(new Runnable() {

			@Override
			public void run() {

				mListview.setAdapter(new FrescoAdapter(mContext, mList));
			}
		}, 0);
	}

}
