package homepunk.work.mall.presentation.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class RecyclerClickListener implements RecyclerView.OnItemTouchListener {
    private final GestureDetector gestureDetector;
    private final GestureListener gestureListener;

    private final OnItemMotionEventListener listener;

    public RecyclerClickListener(Context context, OnItemMotionEventListener listener) {
        this.listener = listener;
        this.gestureListener = new GestureListener();
        this.gestureDetector = new GestureDetector(context, gestureListener);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {

        gestureListener.setRecyclerView(view);

        gestureDetector.onTouchEvent(e);

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private RecyclerView mRecyclerView;

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View view = findView(e);
            if (validate(view)) {
                int position = findPosition(view);
                listener.onItemClick(view, position);
            }
            return true;
        }


        private boolean validate(View view) {
            if (view != null && listener != null) {
                return true;
            } else {
                return false;
            }
        }

        private View findView(MotionEvent e) {
            View childView = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
            return childView;
        }

        private int findPosition(View view) {
            return mRecyclerView.getChildPosition(view);
        }

        public void setRecyclerView(RecyclerView mRecyclerView) {
            this.mRecyclerView = mRecyclerView;
        }
    }

    public interface OnItemMotionEventListener {
        public void onItemClick(View view, int position);

    }

    public static class SimpleItemMotionEventListener implements OnItemMotionEventListener{

        @Override
        public void onItemClick(View view, int position) {

        }
    }
}
