/*
 * Copyright (C) 2013 Moritz Heindl <lenidh[at]gmail[dot]com>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package lenidh.android.holochron;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import de.lenidh.libzeitmesser.stopwatch.SystemTime;
import de.lenidh.libzeitmesser.stopwatch.Watch;

public class App extends Application {

	private static Context context;
	private static String themePref;
	private static Watch watch;

	public static Watch getWatch() {
		return watch;
	}

	public static String getThemePreference() {
		return themePref;
	}

	public static void updateThemePreference() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		themePref = prefs.getString(context.getString(R.string.pref_key_theme),
		                            context.getString(R.string.pref_value_theme_light));
	}

	public static int convertToPx(int dp) {
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		return (int) ((dp * displayMetrics.density) + 0.5);
	}

	public static String getStringFromResource(int resId) {
		return context.getString(resId);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();

		watch = new Watch(new SystemTime() {

			@Override
			public long getTime() {
				return SystemClock.elapsedRealtime();
			}
		});

		updateThemePreference();
	}
}
