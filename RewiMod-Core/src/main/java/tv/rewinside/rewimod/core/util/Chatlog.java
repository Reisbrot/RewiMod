/*
 * RewiMod, a Minecraft Client Enhancement
 * Copyright (C) rewinside.tv <https://rewinside.tv/>
 * Copyright (C) RewiMod team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package tv.rewinside.rewimod.core.util;

import java.util.Date;
import lombok.Getter;
import tv.rewinside.rewimod.core.RewiMod;

@Getter
public class Chatlog {

	private final String link;
	private final String user;
	private final Date creation;

	/**
	 * Constructs a new chatlog with all required information
	 *
	 * @param link the chatlog link
	 * @param user the user which has been reported
	 * @param creation the creation time
	 */
	public Chatlog(String link, String user, Date creation) {
		this.link = link;
		this.user = user;
		this.creation = creation;
	}

	/**
	 * Determines if a chatlog should be created or not
	 *
	 * @param message the message to check
	 * @param user the mod user
	 * @param sender the message sender
	 * @param serverIp the server ip
	 * @return if a chatlog should be created
	 */
	public static boolean shouldCreateChatlog(String message, String user, String sender, String serverIp) {
		if (user.equals(sender) || !serverIp.contains("rewinside.tv")) {
			return false;
		}

		for (String badWord : RewiMod.getInstance().getBlacklistedWords()) {
			if (message.contains(badWord)) {
				return true;
			}
		}

		return false;
	}

}
