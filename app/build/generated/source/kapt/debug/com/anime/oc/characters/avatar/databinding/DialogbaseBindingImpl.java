package com.anime.oc.characters.avatar.databinding;
import com.anime.oc.characters.avatar.R;
import com.anime.oc.characters.avatar.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogbaseBindingImpl extends DialogbaseBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.contrainColor, 1);
        sViewsWithIds.put(R.id.tvTitle, 2);
        sViewsWithIds.put(R.id.txtContent, 3);
        sViewsWithIds.put(R.id.progressBar, 4);
        sViewsWithIds.put(R.id.txtPlease, 5);
        sViewsWithIds.put(R.id.bgEnd, 6);
        sViewsWithIds.put(R.id.bg, 7);
        sViewsWithIds.put(R.id.btnYes, 8);
        sViewsWithIds.put(R.id.txtYes, 9);
        sViewsWithIds.put(R.id.btnNo, 10);
        sViewsWithIds.put(R.id.txtNo, 11);
        sViewsWithIds.put(R.id.btnOk, 12);
        sViewsWithIds.put(R.id.txtOk, 13);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogbaseBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private DialogbaseBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (android.widget.ProgressBar) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[9]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
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