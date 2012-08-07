package com.dreamfish.uibox;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MonthView extends View {

	Context mContext;
	int mViewSizeWidth;
	int mViewSizeHeight;
	ArrayList<DayItem> mItems = null;
	int mDayCount = 1; // default

	// for drawing DayItems
	int mDayItemWidth;
	int mDayItemHeight;

	Paint mColumnPaint;
	Paint mTempPaint;
	Paint mHightLightPaint;

	int mCurrentDay = 1;

	public MonthView(Context context) {
		super(context);
		mContext = context;
		initPaint();
	}

	public MonthView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initPaint();
	}

	public MonthView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		initPaint();
	}

	private void initPaint() {
		mColumnPaint = new Paint();
		mColumnPaint.setColor(Color.GRAY);
		mColumnPaint.setStyle(Style.STROKE);
		mColumnPaint.setStrokeWidth(1);
		mColumnPaint.setAlpha(100);

		mTempPaint = new Paint();
		mTempPaint.setColor(Color.BLACK);

		mHightLightPaint = new Paint();
		mHightLightPaint.setColor(Color.YELLOW);
		mHightLightPaint.setStyle(Style.STROKE);
		mHightLightPaint.setAlpha(150);
		mHightLightPaint.setStrokeWidth(4);
	}

	public void setData(ArrayList<DayItem> data, int dayCount, int currentDay) {
		mItems = data;
		mDayCount = dayCount;
		mCurrentDay = currentDay;
	}

	@Override
	protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld) {
		super.onSizeChanged(xNew, yNew, xOld, yOld);

		mViewSizeWidth = xNew;
		mViewSizeHeight = yNew;

		mDayItemWidth = mViewSizeWidth / mDayCount;
		mDayItemHeight = mViewSizeHeight;
	}


	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);

		// Draw day columns
		for (int i = 1; i <= mDayCount; i++) {
			canvas.drawLine((i * mDayItemWidth), 0, (i * mDayItemWidth),
					mViewSizeWidth, mColumnPaint);
		}

		if (mItems != null) {
			for (DayItem item : mItems) {
				canvas.drawText(String.valueOf(item.DayOfMonth),
						(item.DayOfMonth * mDayItemWidth - 1) + 2, 10,
						mTempPaint);
			}
		}

		// Draw highlight for selected day
		canvas.drawRect(mCurrentDay * mDayItemWidth + 1, 0, (mCurrentDay + 1)
				* mDayItemWidth + 1, mViewSizeHeight, mHightLightPaint);

	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		final int action = ev.getAction();
		final float x = ev.getX();
		final float y = ev.getY();

		switch (action) {
		case MotionEvent.ACTION_DOWN:
			doCalculateCurrentDay(x);
			invalidate();
			break;

		}

		return true;
	}

	void doCalculateCurrentDay(float x) {
		mCurrentDay = ((int) (x / mDayItemWidth)) == 0 ? 1
				: ((int) (x / mDayItemWidth));
	}

}
