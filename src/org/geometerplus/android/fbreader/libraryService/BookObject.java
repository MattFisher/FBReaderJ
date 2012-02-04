/*
 * Copyright (C) 2010-2012 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.android.fbreader.libraryService;

import android.os.Parcelable;
import android.os.Parcel;

import org.geometerplus.fbreader.library.Book;

public class BookObject implements Parcelable {
	final String Path;

	BookObject(String path) {
		Path = path;
	}

	BookObject(Book book) {
		this(book.File.getPath());
	}

	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeString(Path);
	}

	public int describeContents() {
		return 0;
	}

	public static final Parcelable.Creator<BookObject> CREATOR =
		new Parcelable.Creator<BookObject>() {
			public BookObject createFromParcel(Parcel parcel) {
				return new BookObject(parcel.readString());
			}

			public BookObject[] newArray(int size) {
				return new BookObject[size];
			}
		};
}
