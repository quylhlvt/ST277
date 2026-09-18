package com.duomaker.couplelove.vatar.databinding;
import com.duomaker.couplelove.vatar.R;
import com.duomaker.couplelove.vatar.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogColorPickerBindingImpl extends DialogColorPickerBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.mater, 1);
        sViewsWithIds.put(R.id.contrainColor, 2);
        sViewsWithIds.put(R.id.tvTitle, 3);
        sViewsWithIds.put(R.id.colorPickerView, 4);
        sViewsWithIds.put(R.id.hueSlider, 5);
        sViewsWithIds.put(R.id.contrain, 6);
        sViewsWithIds.put(R.id.view4, 7);
        sViewsWithIds.put(R.id.btnCancle, 8);
        sViewsWithIds.put(R.id.txtCancle, 9);
        sViewsWithIds.put(R.id.btnSave, 10);
        sViewsWithIds.put(R.id.txtSave, 11);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogColorPickerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private DialogColorPickerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.card.MaterialCardView) bindings[8]
            , (com.google.android.material.card.MaterialCardView) bindings[10]
            , (ir.kotlin.quyhcolorpicker.QuylhColorPicker) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (ir.kotlin.quyhcolorpicker.QuylhHueSlider) bindings[5]
            , (com.google.android.material.card.MaterialCardView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[11]
            , (android.view.View) bindings[7]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}