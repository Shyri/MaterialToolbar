package es.shyri.materialtoolbar;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

/**
 * Created by Shyri on 23/09/2015.
 */
public class MaterialToolbar extends Toolbar {
    MaterialToolbarContent mMaterialToolbarContent;

    public MaterialToolbar(Context context) {
        super(context);
    }

    public MaterialToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaterialToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setContent (MaterialToolbarContent materialToolbarContent) {
        if (mMaterialToolbarContent != null) {
            removeView(this.mMaterialToolbarContent.getView());
        }
        mMaterialToolbarContent = materialToolbarContent;

        addView(mMaterialToolbarContent.getView());
    }

    public MaterialToolbarContent getMaterialToolbarContent() {
        return mMaterialToolbarContent;
    }

    public void setMaterialToolbarContent(MaterialToolbarContent mMaterialToolbarContent) {
        this.mMaterialToolbarContent = mMaterialToolbarContent;
    }
}
