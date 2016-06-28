package com.testfairy.samples.drawmefairy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import draw.me.fairy.R;

import com.testfairy.TestFairy;

/**
 * Created by gilt on 12/17/14.
 */
public class SplashScreenActivity extends Activity {

	public final static String TestFairyAppToken =  "c8177ba73365ddc1689ac12d4e0779d777f0ed5a"; //citidemo@testfairy.com

	private final String TAG = getClass().getSimpleName();
	private Animation.AnimationListener splashScreenAnimationListener = new Animation.AnimationListener() {
		@Override
		public void onAnimationStart(Animation animation) {

		}

		@Override
		public void onAnimationEnd(Animation animation) {

			Intent intent = new Intent(SplashScreenActivity.this, MenuActivity.class);
			startActivity(intent);
			finish();
		}

		@Override
		public void onAnimationRepeat(Animation animation) {

		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		TestFairy.begin(this, SplashScreenActivity.TestFairyAppToken);

		Log.d(TAG, "onCreate " + TAG);
		ImageView image = (ImageView) findViewById(R.id.about_image);

		RotateAnimation anim = new RotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		anim.setInterpolator(new LinearInterpolator());
		anim.setRepeatCount(0);
		anim.setDuration(3000);
		anim.setAnimationListener(splashScreenAnimationListener);
		image.startAnimation(anim);
	}
}