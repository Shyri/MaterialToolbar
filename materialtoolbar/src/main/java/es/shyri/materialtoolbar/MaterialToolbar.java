package es.shyri.materialtoolbar;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

/**
 * Created by Shyri on 23/09/2015.
 *
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
        if (mMaterialToolbarContent != null)
            addView(mMaterialToolbarContent.getView());
    }

    public MaterialToolbarContent getContent() {
        return mMaterialToolbarContent;
    }

//       TODO in some near future
//    public void setBackgroundImage (int imageResource){
//        Bitmap b = BitmapFactory.decodeResource(getResources(), imageResource);
//        Matrix m = new Matrix();
//        m.setRectToRect(new RectF(0, 0, b.getWidth(), b.getHeight()), new RectF(0, 0, getWidth(), getHeight()), Matrix.ScaleToFit.CENTER);
//        setBackground(new BitmapDrawable(getResources(), Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, true)));
//        b.recycle();
//    }
}
