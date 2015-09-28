package es.shyri.materialtoolbar;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * Created by Shyri on 27/02/2015.
 */

public class MaterialToolbarContent extends LinearLayout {
    Context mContext;
    View toolbarView;

    public MaterialToolbarContent(Context context, int layoutId) {
        super(context);
        this.mContext = context;
        LayoutInflater factory = LayoutInflater.from(this.mContext);
        this.toolbarView = factory.inflate(layoutId, this, true);
        this.toolbarView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public View getView() {
        return this.toolbarView;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);

        this.setMeasuredDimension(-1, -2);
        this.setLayoutParams(new Toolbar.LayoutParams(-1, -2));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
