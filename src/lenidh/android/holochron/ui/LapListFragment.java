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

package lenidh.android.holochron.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import lenidh.android.holochron.App;
import lenidh.android.holochron.R;

public class LapListFragment extends ListFragment {
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		int currentApi = Build.VERSION.SDK_INT;
		ListView list = this.getListView();
		if(!App.getThemePreference().equals(getString(R.string.pref_value_theme_classic))) {
			list.setDivider(null);
		}
		list.setCacheColorHint(Color.TRANSPARENT);
		if (currentApi >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			list.setFadingEdgeLength(App.convertToPx(8));
			list.setVerticalFadingEdgeEnabled(true);
		} else {
			list.setVerticalFadingEdgeEnabled(false);
		}
		list.setSelector(android.R.color.transparent);
		list.setPadding(0, 0, 0, App.convertToPx(8));
		list.setClipToPadding(false);
	}
}