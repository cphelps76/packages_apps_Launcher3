package com.android.launcher3;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.app.Activity;

public final class LauncherPreferences {
 
        public static final String KEY_WORKSPACE_DEFAULT_PAGE = "pref_key_workspaceDefaultPage";

        public static final String KEY_SHOW_SEARCHBAR = "pref_key_showSearchBar";

        private static final String TAG = "LauncherPreferences";

        public static class PrefsFragment  extends PreferenceFragment {
            private SearchDropTargetBar mSearchDropTargetBar;
            private Preference mShowSearchBar;
            private LauncherPreferencesActivity mContext;

            public PrefsFragment(LauncherPreferencesActivity context) {
                mContext = context;
            }

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                // Load the preferences from an XML resource
                addPreferencesFromResource(R.xml.preferences );

                mShowSearchBar = (Preference) findPreference(KEY_SHOW_SEARCHBAR);
            }
            @Override
            public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
                    Preference preference) {
                if (preference == mShowSearchBar){
                    if (mSearchDropTargetBar != null) {
                        mSearchDropTargetBar.hideSearchBar(true);
                        return true;
                    }
                }
                return false;
            }
        }

        private LauncherPreferences() {}

        public static boolean isLauncherPreference(String key) {
                return key.equals(KEY_WORKSPACE_DEFAULT_PAGE)
                                || key.equals(KEY_SHOW_SEARCHBAR);
        }
}
