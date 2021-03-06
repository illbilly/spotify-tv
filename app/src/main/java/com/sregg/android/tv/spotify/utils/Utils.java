package com.sregg.android.tv.spotify.utils;

import android.content.Context;
import android.content.res.Resources;
import kaaes.spotify.webapi.android.models.AlbumSimple;
import kaaes.spotify.webapi.android.models.ArtistSimple;
import kaaes.spotify.webapi.android.models.Playlist;
import kaaes.spotify.webapi.android.models.Track;

/**
 * Created by simonreggiani on 15-02-04.
 */
public class Utils {
    public static String getUriFromSpotiyObject(Object spotifyObject) {
        String uri = null;
        if (spotifyObject instanceof Track) {
            uri = ((Track) spotifyObject).uri;
        } else if (spotifyObject instanceof Playlist) {
            uri = ((Playlist) spotifyObject).uri;
        } else if (spotifyObject instanceof AlbumSimple) {
            uri = ((AlbumSimple) spotifyObject).uri;
        } else if (spotifyObject instanceof ArtistSimple) {
            uri = ((ArtistSimple) spotifyObject).uri;
        }
        return uri;
    }

    public static String getIdFromUri(String uri) {
        return uri.split(":")[2];
    }

    public static int getResourceIdByName(Context context, String name, String type) {
        Resources resources = context.getResources();
        return resources.getIdentifier(name, type, context.getPackageName());
    }

    public static int getStringResourceIdByName(Context context, String name) {
        return getResourceIdByName(context, name, "string");
    }

    public static String getStringByName(Context context, String name) {
        return context.getString(getStringResourceIdByName(context, name));
    }

    public static String getTrackArtists(Track track) {
        StringBuilder artists = new StringBuilder();
        for (ArtistSimple artist : track.artists) {
            if (artists.length() > 0) {
                artists.append(", ");
            }
            artists.append(artist.name);
        }
        return artists.toString();
    }
}
