package com.android.launcher3;

import android.content.SharedPreferences;
import android.preference.CheckBoxPreference;
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
        public static final String KEY_ICON_PACK = "pref_key_iconpack";
        public static final String KEY_SCROLL_WALLPAPER = "pref_key_scroll_wallpaper";
        public static final String KEY_HIDE_ICON_LABELS = "pref_key_hideIcons";

        private static final String TAG = "LauncherPreferences";

        public static class PrefsFragment  extends PreferenceFragment {
            private Preference mDefaultWorkspace;
            private Preference mShowSearchBar;
            private Preference mIconpack;
            private CheckBoxPreference mScrollWallpaper;
            private LauncherPreferencesActivity mContext;

            public PrefsFragment(LauncherPreferencesActivity context) {
                mContext = context;
            }

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                // Load the preferences from an XML resource
                addPreferencesFromResource(R.xml.preferences );
                mDefaultWorkspace = (Preference) findPreference(KEY_WORKSPACE_DEFAULT_PAGE);
                mShowSearchBar = (Preference) findPreference(KEY_SHOW_SEARCHBAR);
                mIconpack = (Preference) findPreference(KEY_ICON_PACK);
                mScrollWallpaper = (CheckBoxPreference) findPreference(KEY_SCROLL_WALLPAPER);
            }

            @Override
            public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
                    Preference preference) {
                if (preference == mDefaultWorkspace){
                    Log.w(TAG, "Burger");
                    return true;
                } else if (preference == mShowSearchBar){
                    Log.w(TAG, "Burger burger");
                    return true;
                } else if (preference == mIconpack){
                    IconPackHelper.pickIconPack(mContext, false);
                    Log.w(TAG, "Burger burger burger");
                    return true;
                } else if (preference == mScrollWallpaper){
                    Log.w(TAG, "Burger burger burger burger");
                    return true;
                }
                return false;
            }
        }

        private LauncherPreferences() {}

        public static boolean isLauncherPreference(String key) {
                return key.equals(KEY_WORKSPACE_DEFAULT_PAGE)
                                || key.equals(KEY_SHOW_SEARCHBAR)
                                || key.equals(KEY_ICON_PACK)
                                || key.equals(KEY_SCROLL_WALLPAPER)
                                || key.equals(KEY_HIDE_ICON_LABELS);
        }
}
