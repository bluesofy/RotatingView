package cn.byk.pandora.rotatingview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Created by Byk on 2018/9/20.
 **/
public class RotatingView extends ImageView {

    private final static int DURATION = 3_000;
    private final static int CIRCLE_COUNT = 1;
    private final static boolean INFINITY = false;

    private RotateAnimation mAnim;

    private boolean mIsInfinity;

    public RotatingView(Context context) {
        this(context, null);
    }

    public RotatingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RotatingView,
                defStyleAttr, 0);

        // Get Attrs
        int duration = a.getInt(R.styleable.RotatingView_duration, DURATION);
        int circles = a.getInt(R.styleable.RotatingView_circles, CIRCLE_COUNT);
        mIsInfinity = a.getBoolean(R.styleable.RotatingView_infinity, INFINITY);

        mAnim = new RotateAnimation(0f, 360f * circles, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        mAnim.setDuration(duration);
        switchInfinity(mIsInfinity);

        a.recycle();
    }

    public boolean isRotating() {
        return getAnimation() != null;
    }

    public boolean isInfinity() {
        return mIsInfinity;
    }

    public RotateAnimation switchInfinity(boolean flag) {
        if (flag) {
            mAnim.setRepeatMode(RotateAnimation.INFINITE);
            mAnim.setRepeatCount(Animation.INFINITE);
            mAnim.setInterpolator(new LinearInterpolator());
        } else {
            mAnim.setRepeatCount(0);
            mAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        return mAnim;
    }

    /**
     * Start Rotate
     */
    public void start() {
        startAnimation(mAnim);
    }

    /**
     * Start Anim Customized
     *
     * @param anim Customized Anim
     */
    public void start(Animation anim) {
        startAnimation(anim);
    }

    public void stop() {
        clearAnimation();
    }

}
