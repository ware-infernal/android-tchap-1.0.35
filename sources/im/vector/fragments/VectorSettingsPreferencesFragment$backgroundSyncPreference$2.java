package im.vector.fragments;

import android.preference.CheckBoxPreference;
import android.preference.Preference;
import im.vector.util.PreferencesManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/preference/CheckBoxPreference;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: VectorSettingsPreferencesFragment.kt */
final class VectorSettingsPreferencesFragment$backgroundSyncPreference$2 extends Lambda implements Function0<CheckBoxPreference> {
    final /* synthetic */ VectorSettingsPreferencesFragment this$0;

    VectorSettingsPreferencesFragment$backgroundSyncPreference$2(VectorSettingsPreferencesFragment vectorSettingsPreferencesFragment) {
        this.this$0 = vectorSettingsPreferencesFragment;
        super(0);
    }

    public final CheckBoxPreference invoke() {
        Preference findPreference = this.this$0.findPreference(PreferencesManager.SETTINGS_ENABLE_BACKGROUND_SYNC_PREFERENCE_KEY);
        if (findPreference != null) {
            return (CheckBoxPreference) findPreference;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.preference.CheckBoxPreference");
    }
}
