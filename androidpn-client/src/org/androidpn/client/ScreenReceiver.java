/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.androidpn.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * A broadcast receiver to handle the changes in network connectiion states.
 * 
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class ScreenReceiver extends BroadcastReceiver {

	private static final String LOGTAG = LogUtil
			.makeLogTag(ScreenReceiver.class);

	private NotificationService notificationService;

	public ScreenReceiver(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(LOGTAG, "ScreenReceiver.onReceive()...");
		String action = intent.getAction();
		Log.i(LOGTAG, "action=" + action);
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		Log.i("connect", "ScreenReceiver");
		if ( Intent.ACTION_SCREEN_ON.equals(action)) {
			
				Log.i("connect", "startconnect");
				notificationService.connect();
			
		}

	}

}
