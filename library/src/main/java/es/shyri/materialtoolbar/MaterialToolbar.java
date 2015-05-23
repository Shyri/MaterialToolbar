package es.shyri.materialtoolbar;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import es.shyri.materialtoolbar.interfaces.MaterialToolbarMessageReceiver;


/**
 * Created by Shyri on 27/02/2015.
 */
public class MaterialToolbar extends Toolbar {
    MaterialToolbarContent mMaterialToolbarContent;
    MaterialToolbarMessageReceiver mMessageReceiver;

    public MaterialToolbar(Context context)
    {
        super(context);
    }

    public MaterialToolbar(Context context, AttributeSet attrs)
    {
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

        mMaterialToolbarContent.configureActionBar((ActionBarActivity) getContext());

        getMenu().clear();
        if (mMaterialToolbarContent.getMenuId() != null) {
            inflateMenu(mMaterialToolbarContent.getMenuId());
        } else {
            getMenu().clear();
        }

        if(materialToolbarContent.getActionbarBackground() != null){
            if (android.os.Build.VERSION.SDK_INT <= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                setBackgroundDrawable(materialToolbarContent.getActionbarBackground());
            }else{
                setBackground(materialToolbarContent.getActionbarBackground());
            }
        }
    }
    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
