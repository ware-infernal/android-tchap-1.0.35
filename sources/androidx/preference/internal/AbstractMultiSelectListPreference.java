package androidx.preference.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.DialogPreference;
import java.util.Set;

public abstract class AbstractMultiSelectListPreference extends DialogPreference {
    public abstract CharSequence[] getEntries();

    public abstract CharSequence[] getEntryValues();

    public abstract Set<String> getValues();

    public abstract void setValues(Set<String> set);

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbstractMultiSelectListPreference(Context context) {
        super(context);
    }
}
