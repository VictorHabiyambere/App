package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.common.net.HttpHeaders;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzakf {
    static final String[] zza = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int zzb = 0;

    public static zzcc zza(zzfu zzfu) {
        String str;
        String str2;
        int zzd = zzfu.zzd() + zzfu.zzg();
        int zzg = zzfu.zzg();
        int i = (zzg >> 24) & 255;
        zzcc zzcc = null;
        if (i == 169 || i == 253) {
            int i2 = zzg & ViewCompat.MEASURED_SIZE_MASK;
            if (i2 == 6516084) {
                int zzg2 = zzfu.zzg();
                if (zzfu.zzg() == 1684108385) {
                    zzfu.zzL(8);
                    String zzz = zzfu.zzz(zzg2 - 16);
                    zzcc = new zzahk("und", zzz, zzz);
                } else {
                    zzfk.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzajo.zzf(zzg)));
                }
            } else {
                if (i2 != 7233901) {
                    if (i2 != 7631467) {
                        if (i2 != 6516589) {
                            if (i2 != 7828084) {
                                if (i2 == 6578553) {
                                    zzcc = zze(zzg, "TDRC", zzfu);
                                } else if (i2 == 4280916) {
                                    zzcc = zze(zzg, "TPE1", zzfu);
                                } else if (i2 == 7630703) {
                                    zzcc = zze(zzg, "TSSE", zzfu);
                                } else if (i2 == 6384738) {
                                    zzcc = zze(zzg, "TALB", zzfu);
                                } else if (i2 == 7108978) {
                                    zzcc = zze(zzg, "USLT", zzfu);
                                } else if (i2 == 6776174) {
                                    zzcc = zze(zzg, "TCON", zzfu);
                                } else if (i2 == 6779504) {
                                    zzcc = zze(zzg, "TIT1", zzfu);
                                }
                            }
                        }
                        zzcc = zze(zzg, "TCOM", zzfu);
                    }
                }
                zzcc = zze(zzg, "TIT2", zzfu);
            }
            return zzcc;
        }
        if (zzg == 1735291493) {
            try {
                int zzb2 = zzb(zzfu);
                if (zzb2 <= 0 || zzb2 > 192) {
                    str2 = null;
                } else {
                    str2 = zza[zzb2 - 1];
                }
                if (str2 != null) {
                    zzcc = new zzahz("TCON", (String) null, zzgbc.zzn(str2));
                } else {
                    zzfk.zzf("MetadataUtil", "Failed to parse standard genre code");
                }
            } finally {
                zzfu.zzK(zzd);
            }
        } else if (zzg == 1684632427) {
            zzcc = zzd(1684632427, "TPOS", zzfu);
        } else if (zzg == 1953655662) {
            zzcc = zzd(1953655662, "TRCK", zzfu);
        } else if (zzg == 1953329263) {
            zzcc = zzc(1953329263, "TBPM", zzfu, true, false);
        } else if (zzg == 1668311404) {
            zzcc = zzc(1668311404, "TCMP", zzfu, true, true);
        } else if (zzg == 1668249202) {
            int zzg3 = zzfu.zzg();
            if (zzfu.zzg() == 1684108385) {
                int zzg4 = zzfu.zzg() & ViewCompat.MEASURED_SIZE_MASK;
                if (zzg4 == 13) {
                    str = "image/jpeg";
                } else if (zzg4 == 14) {
                    str = "image/png";
                    zzg4 = 14;
                } else {
                    str = null;
                }
                if (str == null) {
                    zzfk.zzf("MetadataUtil", "Unrecognized cover art flags: " + zzg4);
                } else {
                    zzfu.zzL(4);
                    int i3 = zzg3 - 16;
                    byte[] bArr = new byte[i3];
                    zzfu.zzG(bArr, 0, i3);
                    zzcc = new zzahc(str, (String) null, 3, bArr);
                }
            } else {
                zzfk.zzf("MetadataUtil", "Failed to parse cover art attribute");
            }
        } else if (zzg == 1631670868) {
            zzcc = zze(1631670868, "TPE2", zzfu);
        } else if (zzg == 1936682605) {
            zzcc = zze(1936682605, "TSOT", zzfu);
        } else if (zzg == 1936679276) {
            zzcc = zze(1936679276, "TSOA", zzfu);
        } else if (zzg == 1936679282) {
            zzcc = zze(1936679282, "TSOP", zzfu);
        } else if (zzg == 1936679265) {
            zzcc = zze(1936679265, "TSO2", zzfu);
        } else if (zzg == 1936679791) {
            zzcc = zze(1936679791, "TSOC", zzfu);
        } else if (zzg == 1920233063) {
            zzcc = zzc(1920233063, "ITUNESADVISORY", zzfu, false, false);
        } else if (zzg == 1885823344) {
            zzcc = zzc(1885823344, "ITUNESGAPLESS", zzfu, false, true);
        } else if (zzg == 1936683886) {
            zzcc = zze(1936683886, "TVSHOWSORT", zzfu);
        } else if (zzg == 1953919848) {
            zzcc = zze(1953919848, "TVSHOW", zzfu);
        } else if (zzg == 757935405) {
            int i4 = -1;
            int i5 = -1;
            String str3 = null;
            String str4 = null;
            while (zzfu.zzd() < zzd) {
                int zzd2 = zzfu.zzd();
                int zzg5 = zzfu.zzg();
                int zzg6 = zzfu.zzg();
                zzfu.zzL(4);
                if (zzg6 == 1835360622) {
                    str3 = zzfu.zzz(zzg5 - 12);
                } else {
                    int i6 = zzg5 - 12;
                    if (zzg6 == 1851878757) {
                        str4 = zzfu.zzz(i6);
                    } else {
                        if (zzg6 == 1684108385) {
                            i5 = zzg5;
                        }
                        if (zzg6 == 1684108385) {
                            i4 = zzd2;
                        }
                        zzfu.zzL(i6);
                    }
                }
            }
            if (str3 != null) {
                if (str4 != null) {
                    if (i4 != -1) {
                        zzfu.zzK(i4);
                        zzfu.zzL(16);
                        zzcc = new zzaht(str3, str4, zzfu.zzz(i5 - 16));
                    }
                }
            }
        }
        return zzcc;
        zzfk.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzajo.zzf(zzg));
        return zzcc;
    }

    private static int zzb(zzfu zzfu) {
        int zzg = zzfu.zzg();
        if (zzfu.zzg() == 1684108385) {
            zzfu.zzL(8);
            switch (zzg - 16) {
                case 1:
                    return zzfu.zzm();
                case 2:
                    return zzfu.zzq();
                case 3:
                    return zzfu.zzo();
                case 4:
                    if ((zzfu.zzf() & 128) == 0) {
                        return zzfu.zzp();
                    }
                    break;
            }
        }
        zzfk.zzf("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static zzahr zzc(int i, String str, zzfu zzfu, boolean z, boolean z2) {
        int zzb2 = zzb(zzfu);
        if (z2) {
            zzb2 = Math.min(1, zzb2);
        }
        if (zzb2 < 0) {
            zzfk.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzajo.zzf(i)));
            return null;
        } else if (z) {
            return new zzahz(str, (String) null, zzgbc.zzn(Integer.toString(zzb2)));
        } else {
            return new zzahk("und", str, Integer.toString(zzb2));
        }
    }

    private static zzahz zzd(int i, String str, zzfu zzfu) {
        int zzg = zzfu.zzg();
        if (zzfu.zzg() == 1684108385 && zzg >= 22) {
            zzfu.zzL(10);
            int zzq = zzfu.zzq();
            if (zzq > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzq);
                String sb2 = sb.toString();
                int zzq2 = zzfu.zzq();
                if (zzq2 > 0) {
                    sb2 = sb2 + DomExceptionUtils.SEPARATOR + zzq2;
                }
                return new zzahz(str, (String) null, zzgbc.zzn(sb2));
            }
        }
        zzfk.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzajo.zzf(i)));
        return null;
    }

    private static zzahz zze(int i, String str, zzfu zzfu) {
        int zzg = zzfu.zzg();
        if (zzfu.zzg() == 1684108385) {
            zzfu.zzL(8);
            return new zzahz(str, (String) null, zzgbc.zzn(zzfu.zzz(zzg - 16)));
        }
        zzfk.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzajo.zzf(i)));
        return null;
    }
}
