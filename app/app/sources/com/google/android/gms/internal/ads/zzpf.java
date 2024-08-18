package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.HashMap;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzpf implements zzna, zzpg {
    private final Context zza;
    private final zzph zzb = new zzpd(zzpd.zza);
    private final PlaybackSession zzc;
    private final long zzd = SystemClock.elapsedRealtime();
    private final zzdb zze = new zzdb();
    private final zzcz zzf = new zzcz();
    private final HashMap zzg = new HashMap();
    private final HashMap zzh = new HashMap();
    private String zzi;
    private PlaybackMetrics.Builder zzj;
    private int zzk;
    private int zzl = 0;
    private int zzm = 0;
    private zzcj zzn;
    private zzpe zzo;
    private zzpe zzp;
    private zzpe zzq;
    private zzan zzr;
    private zzan zzs;
    private zzan zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;

    private zzpf(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        this.zzb.zzh(this);
    }

    public static zzpf zzb(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zzpf(context, mediaMetricsManager.createPlaybackSession());
    }

    private static int zzr(int i) {
        switch (zzgd.zzj(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        long j;
        long j2;
        int i;
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            builder.setAudioUnderrunCount(this.zzy);
            this.zzj.setVideoFramesDropped(this.zzw);
            this.zzj.setVideoFramesPlayed(this.zzx);
            Long l = (Long) this.zzg.get(this.zzi);
            PlaybackMetrics.Builder builder2 = this.zzj;
            if (l == null) {
                j = 0;
            } else {
                j = l.longValue();
            }
            builder2.setNetworkTransferDurationMillis(j);
            Long l2 = (Long) this.zzh.get(this.zzi);
            PlaybackMetrics.Builder builder3 = this.zzj;
            if (l2 == null) {
                j2 = 0;
            } else {
                j2 = l2.longValue();
            }
            builder3.setNetworkBytesRead(j2);
            PlaybackMetrics.Builder builder4 = this.zzj;
            if (l2 == null || l2.longValue() <= 0) {
                i = 0;
            } else {
                i = 1;
            }
            builder4.setStreamSource(i);
            this.zzc.reportPlaybackMetrics(this.zzj.build());
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j, zzan zzan, int i) {
        int i2;
        if (!zzgd.zzG(this.zzs, zzan)) {
            if (this.zzs == null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.zzs = zzan;
            zzx(0, j, zzan, i2);
        }
    }

    private final void zzu(long j, zzan zzan, int i) {
        int i2;
        if (!zzgd.zzG(this.zzt, zzan)) {
            if (this.zzt == null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.zzt = zzan;
            zzx(2, j, zzan, i2);
        }
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzv(zzdc zzdc, zzvo zzvo) {
        int zza2;
        int i;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zzvo != null && (zza2 = zzdc.zza(zzvo.zza)) != -1) {
            int i2 = 0;
            zzdc.zzd(zza2, this.zzf, false);
            zzdc.zze(this.zzf.zzd, this.zze, 0);
            zzbn zzbn = this.zze.zze.zzd;
            if (zzbn != null) {
                switch (zzgd.zzn(zzbn.zzb)) {
                    case 0:
                        i2 = 3;
                        break;
                    case 1:
                        i2 = 5;
                        break;
                    case 2:
                        i2 = 4;
                        break;
                    default:
                        i2 = 1;
                        break;
                }
            }
            builder.setStreamType(i2);
            zzdb zzdb = this.zze;
            if (zzdb.zzo != -9223372036854775807L && !zzdb.zzm && !zzdb.zzj && !zzdb.zzb()) {
                builder.setMediaDurationMillis(zzgd.zzu(this.zze.zzo));
            }
            if (true != this.zze.zzb()) {
                i = 1;
            } else {
                i = 2;
            }
            builder.setPlaybackType(i);
            this.zzz = true;
        }
    }

    private final void zzw(long j, zzan zzan, int i) {
        int i2;
        if (!zzgd.zzG(this.zzr, zzan)) {
            if (this.zzr == null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.zzr = zzan;
            zzx(1, j, zzan, i2);
        }
    }

    private final void zzx(int i, long j, zzan zzan, int i2) {
        int i3;
        String str;
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.zzd);
        if (zzan != null) {
            timeSinceCreatedMillis.setTrackState(1);
            switch (i2) {
                case 1:
                    i3 = 2;
                    break;
                default:
                    i3 = 1;
                    break;
            }
            timeSinceCreatedMillis.setTrackChangeReason(i3);
            String str2 = zzan.zzm;
            if (str2 != null) {
                timeSinceCreatedMillis.setContainerMimeType(str2);
            }
            String str3 = zzan.zzn;
            if (str3 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str3);
            }
            String str4 = zzan.zzk;
            if (str4 != null) {
                timeSinceCreatedMillis.setCodecName(str4);
            }
            int i4 = zzan.zzj;
            if (i4 != -1) {
                timeSinceCreatedMillis.setBitrate(i4);
            }
            int i5 = zzan.zzs;
            if (i5 != -1) {
                timeSinceCreatedMillis.setWidth(i5);
            }
            int i6 = zzan.zzt;
            if (i6 != -1) {
                timeSinceCreatedMillis.setHeight(i6);
            }
            int i7 = zzan.zzA;
            if (i7 != -1) {
                timeSinceCreatedMillis.setChannelCount(i7);
            }
            int i8 = zzan.zzB;
            if (i8 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i8);
            }
            String str5 = zzan.zze;
            if (str5 != null) {
                int i9 = zzgd.zza;
                String[] split = str5.split("-", -1);
                String str6 = split[0];
                if (split.length >= 2) {
                    str = split[1];
                } else {
                    str = null;
                }
                Pair create = Pair.create(str6, str);
                timeSinceCreatedMillis.setLanguage((String) create.first);
                if (create.second != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) create.second);
                }
            }
            float f = zzan.zzu;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzz = true;
        this.zzc.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzy(zzpe zzpe) {
        if (zzpe == null) {
            return false;
        }
        return zzpe.zzc.equals(this.zzb.zze());
    }

    public final LogSessionId zza() {
        return this.zzc.getSessionId();
    }

    public final void zzc(zzmy zzmy, String str) {
        zzvo zzvo = zzmy.zzd;
        if (zzvo == null || !zzvo.zzb()) {
            zzs();
            this.zzi = str;
            this.zzj = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3").setPlayerVersion("1.4.0-alpha01");
            zzv(zzmy.zzb, zzmy.zzd);
        }
    }

    public final void zzd(zzmy zzmy, String str, boolean z) {
        zzvo zzvo = zzmy.zzd;
        if ((zzvo == null || !zzvo.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    public final /* synthetic */ void zze(zzmy zzmy, zzan zzan, zziy zziy) {
    }

    public final void zzf(zzmy zzmy, int i, long j, long j2) {
        long j3;
        zzvo zzvo = zzmy.zzd;
        if (zzvo != null) {
            zzph zzph = this.zzb;
            zzdc zzdc = zzmy.zzb;
            HashMap hashMap = this.zzh;
            String zzf2 = zzph.zzf(zzdc, zzvo);
            Long l = (Long) hashMap.get(zzf2);
            Long l2 = (Long) this.zzg.get(zzf2);
            HashMap hashMap2 = this.zzh;
            long j4 = 0;
            if (l == null) {
                j3 = 0;
            } else {
                j3 = l.longValue();
            }
            hashMap2.put(zzf2, Long.valueOf(j3 + j));
            HashMap hashMap3 = this.zzg;
            if (l2 != null) {
                j4 = l2.longValue();
            }
            hashMap3.put(zzf2, Long.valueOf(j4 + ((long) i)));
        }
    }

    public final void zzg(zzmy zzmy, zzvk zzvk) {
        zzvo zzvo = zzmy.zzd;
        if (zzvo != null) {
            zzan zzan = zzvk.zzb;
            if (zzan != null) {
                zzpe zzpe = new zzpe(zzan, 0, this.zzb.zzf(zzmy.zzb, zzvo));
                switch (zzvk.zza) {
                    case 0:
                    case 2:
                        this.zzo = zzpe;
                        return;
                    case 1:
                        this.zzp = zzpe;
                        return;
                    case 3:
                        this.zzq = zzpe;
                        return;
                    default:
                        return;
                }
            } else {
                throw null;
            }
        }
    }

    public final /* synthetic */ void zzh(zzmy zzmy, int i, long j) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01ff, code lost:
        if (r8 != 1) goto L_0x0204;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(com.google.android.gms.internal.ads.zzct r19, com.google.android.gms.internal.ads.zzmz r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            int r2 = r20.zzb()
            if (r2 != 0) goto L_0x000c
            goto L_0x03f5
        L_0x000c:
            r2 = 0
            r3 = r2
        L_0x000e:
            int r4 = r20.zzb()
            r5 = 11
            if (r3 >= r4) goto L_0x0038
            int r4 = r1.zza(r3)
            com.google.android.gms.internal.ads.zzmy r6 = r1.zzc(r4)
            if (r4 != 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzph r4 = r0.zzb
            r4.zzk(r6)
            goto L_0x0035
        L_0x0026:
            if (r4 != r5) goto L_0x0030
            com.google.android.gms.internal.ads.zzph r4 = r0.zzb
            int r5 = r0.zzk
            r4.zzj(r6, r5)
            goto L_0x0035
        L_0x0030:
            com.google.android.gms.internal.ads.zzph r4 = r0.zzb
            r4.zzi(r6)
        L_0x0035:
            int r3 = r3 + 1
            goto L_0x000e
        L_0x0038:
            long r3 = android.os.SystemClock.elapsedRealtime()
            boolean r6 = r1.zzd(r2)
            if (r6 == 0) goto L_0x0051
            com.google.android.gms.internal.ads.zzmy r6 = r1.zzc(r2)
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x0051
            com.google.android.gms.internal.ads.zzdc r7 = r6.zzb
            com.google.android.gms.internal.ads.zzvo r6 = r6.zzd
            r0.zzv(r7, r6)
        L_0x0051:
            r6 = 2
            boolean r7 = r1.zzd(r6)
            r9 = 3
            r10 = 0
            r11 = 1
            if (r7 == 0) goto L_0x00cc
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x00cc
            com.google.android.gms.internal.ads.zzdp r7 = r19.zzo()
            com.google.android.gms.internal.ads.zzgbc r7 = r7.zza()
            int r12 = r7.size()
            r13 = r2
        L_0x006d:
            if (r13 >= r12) goto L_0x0095
            java.lang.Object r14 = r7.get(r13)
            com.google.android.gms.internal.ads.zzdo r14 = (com.google.android.gms.internal.ads.zzdo) r14
            r15 = r2
        L_0x0076:
            int r5 = r14.zzb
            int r16 = r13 + 1
            if (r15 >= r5) goto L_0x0090
            boolean r5 = r14.zzd(r15)
            if (r5 == 0) goto L_0x008b
            com.google.android.gms.internal.ads.zzan r5 = r14.zzb(r15)
            com.google.android.gms.internal.ads.zzae r5 = r5.zzq
            if (r5 == 0) goto L_0x008b
            goto L_0x0096
        L_0x008b:
            int r15 = r15 + 1
            r5 = 11
            goto L_0x0076
        L_0x0090:
            r13 = r16
            r5 = 11
            goto L_0x006d
        L_0x0095:
            r5 = r10
        L_0x0096:
            if (r5 == 0) goto L_0x00cc
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            int r12 = com.google.android.gms.internal.ads.zzgd.zza
            r12 = r2
        L_0x009d:
            int r13 = r5.zzb
            if (r12 >= r13) goto L_0x00c8
            com.google.android.gms.internal.ads.zzad r13 = r5.zza(r12)
            java.util.UUID r13 = r13.zza
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zzd
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00b1
            r5 = r9
            goto L_0x00c9
        L_0x00b1:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zze
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00bb
            r5 = r6
            goto L_0x00c9
        L_0x00bb:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zzc
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00c5
            r5 = 6
            goto L_0x00c9
        L_0x00c5:
            int r12 = r12 + 1
            goto L_0x009d
        L_0x00c8:
            r5 = r11
        L_0x00c9:
            r7.setDrmType(r5)
        L_0x00cc:
            r5 = 1011(0x3f3, float:1.417E-42)
            boolean r5 = r1.zzd(r5)
            if (r5 == 0) goto L_0x00da
            int r5 = r0.zzy
            int r5 = r5 + r11
            r0.zzy = r5
        L_0x00da:
            com.google.android.gms.internal.ads.zzcj r5 = r0.zzn
            r16 = 9
            if (r5 != 0) goto L_0x00e2
            goto L_0x029b
        L_0x00e2:
            android.content.Context r7 = r0.zza
            int r8 = r5.zzb
            r12 = 1001(0x3e9, float:1.403E-42)
            if (r8 != r12) goto L_0x00ef
            r7 = 20
            r8 = r2
            goto L_0x0275
        L_0x00ef:
            r8 = r5
            com.google.android.gms.internal.ads.zzjh r8 = (com.google.android.gms.internal.ads.zzjh) r8
            int r12 = r8.zze
            if (r12 != r11) goto L_0x00f8
            r12 = r11
            goto L_0x00f9
        L_0x00f8:
            r12 = r2
        L_0x00f9:
            int r8 = r8.zzi
            java.lang.Throwable r13 = r5.getCause()
            if (r13 == 0) goto L_0x03f6
            boolean r14 = r13 instanceof java.io.IOException
            r15 = 23
            if (r14 == 0) goto L_0x01f9
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzhx
            if (r8 == 0) goto L_0x0113
            com.google.android.gms.internal.ads.zzhx r13 = (com.google.android.gms.internal.ads.zzhx) r13
            int r7 = r13.zzd
            r8 = r7
            r7 = 5
            goto L_0x0275
        L_0x0113:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzhw
            if (r8 != 0) goto L_0x01f4
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzch
            if (r8 == 0) goto L_0x0120
            r8 = r2
            r7 = 11
            goto L_0x0275
        L_0x0120:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzhv
            if (r8 != 0) goto L_0x01c1
            boolean r12 = r13 instanceof com.google.android.gms.internal.ads.zzif
            if (r12 == 0) goto L_0x012a
            goto L_0x01c1
        L_0x012a:
            int r7 = r5.zzb
            r8 = 1002(0x3ea, float:1.404E-42)
            if (r7 != r8) goto L_0x0135
            r7 = 21
            r8 = r2
            goto L_0x0275
        L_0x0135:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzsm
            if (r7 == 0) goto L_0x018d
            java.lang.Throwable r7 = r13.getCause()
            if (r7 == 0) goto L_0x018b
            int r8 = com.google.android.gms.internal.ads.zzgd.zza
            boolean r8 = r7 instanceof android.media.MediaDrm.MediaDrmStateException
            if (r8 == 0) goto L_0x015a
            android.media.MediaDrm$MediaDrmStateException r7 = (android.media.MediaDrm.MediaDrmStateException) r7
            java.lang.String r7 = r7.getDiagnosticInfo()
            int r7 = com.google.android.gms.internal.ads.zzgd.zzk(r7)
            int r8 = zzr(r7)
            r17 = r8
            r8 = r7
            r7 = r17
            goto L_0x0275
        L_0x015a:
            int r8 = com.google.android.gms.internal.ads.zzgd.zza
            if (r8 < r15) goto L_0x0167
            boolean r8 = r7 instanceof android.media.MediaDrmResetException
            if (r8 == 0) goto L_0x0167
            r7 = 27
            r8 = r2
            goto L_0x0275
        L_0x0167:
            boolean r8 = r7 instanceof android.media.NotProvisionedException
            if (r8 == 0) goto L_0x0170
            r7 = 24
            r8 = r2
            goto L_0x0275
        L_0x0170:
            boolean r8 = r7 instanceof android.media.DeniedByServerException
            if (r8 == 0) goto L_0x0179
            r7 = 29
        L_0x0176:
            r8 = r2
            goto L_0x0275
        L_0x0179:
            boolean r8 = r7 instanceof com.google.android.gms.internal.ads.zzsw
            if (r8 == 0) goto L_0x0181
            r8 = r2
            r7 = r15
            goto L_0x0275
        L_0x0181:
            boolean r7 = r7 instanceof com.google.android.gms.internal.ads.zzsk
            if (r7 == 0) goto L_0x0188
            r7 = 28
            goto L_0x0176
        L_0x0188:
            r7 = 30
            goto L_0x0176
        L_0x018b:
            throw r10
        L_0x018d:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzhr
            if (r7 == 0) goto L_0x01bc
            java.lang.Throwable r7 = r13.getCause()
            boolean r7 = r7 instanceof java.io.FileNotFoundException
            if (r7 == 0) goto L_0x01bc
            java.lang.Throwable r7 = r13.getCause()
            if (r7 == 0) goto L_0x01ba
            java.lang.Throwable r7 = r7.getCause()
            int r8 = com.google.android.gms.internal.ads.zzgd.zza
            boolean r8 = r7 instanceof android.system.ErrnoException
            r12 = 31
            if (r8 == 0) goto L_0x01b6
            android.system.ErrnoException r7 = (android.system.ErrnoException) r7
            int r7 = r7.errno
            int r8 = android.system.OsConstants.EACCES
            if (r7 != r8) goto L_0x01b6
            r7 = 32
            goto L_0x0201
        L_0x01b6:
            r8 = r2
            r7 = r12
            goto L_0x0275
        L_0x01ba:
            throw r10
        L_0x01bc:
            r8 = r2
            r7 = r16
            goto L_0x0275
        L_0x01c1:
            com.google.android.gms.internal.ads.zzfs r7 = com.google.android.gms.internal.ads.zzfs.zzb(r7)
            int r7 = r7.zza()
            if (r7 != r11) goto L_0x01cf
            r8 = r2
            r7 = r9
            goto L_0x0275
        L_0x01cf:
            java.lang.Throwable r7 = r13.getCause()
            boolean r12 = r7 instanceof java.net.UnknownHostException
            if (r12 == 0) goto L_0x01db
            r8 = r2
            r7 = 6
            goto L_0x0275
        L_0x01db:
            boolean r7 = r7 instanceof java.net.SocketTimeoutException
            if (r7 == 0) goto L_0x01e3
            r8 = r2
            r7 = 7
            goto L_0x0275
        L_0x01e3:
            if (r8 == 0) goto L_0x01ef
            com.google.android.gms.internal.ads.zzhv r13 = (com.google.android.gms.internal.ads.zzhv) r13
            int r7 = r13.zzc
            if (r7 != r11) goto L_0x01ef
            r8 = r2
            r7 = 4
            goto L_0x0275
        L_0x01ef:
            r8 = r2
            r7 = 8
            goto L_0x0275
        L_0x01f4:
            r8 = r2
            r7 = 11
            goto L_0x0275
        L_0x01f9:
            if (r12 == 0) goto L_0x0204
            r7 = 35
            if (r8 == 0) goto L_0x0201
            if (r8 != r11) goto L_0x0204
        L_0x0201:
            r8 = r2
            goto L_0x0275
        L_0x0204:
            if (r12 == 0) goto L_0x020b
            if (r8 != r9) goto L_0x020b
            r7 = 15
            goto L_0x0201
        L_0x020b:
            if (r12 == 0) goto L_0x0213
            if (r8 != r6) goto L_0x0213
            r8 = r2
            r7 = r15
            goto L_0x0275
        L_0x0213:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zztt
            if (r7 == 0) goto L_0x0223
            com.google.android.gms.internal.ads.zztt r13 = (com.google.android.gms.internal.ads.zztt) r13
            java.lang.String r7 = r13.zzd
            int r7 = com.google.android.gms.internal.ads.zzgd.zzk(r7)
            r8 = r7
            r7 = 13
            goto L_0x0275
        L_0x0223:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzto
            r8 = 14
            if (r7 == 0) goto L_0x0237
            com.google.android.gms.internal.ads.zzto r13 = (com.google.android.gms.internal.ads.zzto) r13
            java.lang.String r7 = r13.zzb
            int r7 = com.google.android.gms.internal.ads.zzgd.zzk(r7)
            r17 = r8
            r8 = r7
            r7 = r17
            goto L_0x0275
        L_0x0237:
            boolean r7 = r13 instanceof java.lang.OutOfMemoryError
            if (r7 == 0) goto L_0x023e
            r7 = r8
            r8 = r2
            goto L_0x0275
        L_0x023e:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzqr
            if (r7 == 0) goto L_0x024e
            com.google.android.gms.internal.ads.zzqr r13 = (com.google.android.gms.internal.ads.zzqr) r13
            int r7 = r13.zza
            r8 = 17
            r17 = r8
            r8 = r7
            r7 = r17
            goto L_0x0275
        L_0x024e:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzqu
            if (r7 == 0) goto L_0x025e
            com.google.android.gms.internal.ads.zzqu r13 = (com.google.android.gms.internal.ads.zzqu) r13
            int r7 = r13.zza
            r8 = 18
            r17 = r8
            r8 = r7
            r7 = r17
            goto L_0x0275
        L_0x025e:
            boolean r7 = r13 instanceof android.media.MediaCodec.CryptoException
            if (r7 == 0) goto L_0x0272
            android.media.MediaCodec$CryptoException r13 = (android.media.MediaCodec.CryptoException) r13
            int r7 = r13.getErrorCode()
            int r8 = zzr(r7)
            r17 = r8
            r8 = r7
            r7 = r17
            goto L_0x0275
        L_0x0272:
            r7 = 22
            r8 = r2
        L_0x0275:
            android.media.metrics.PlaybackSession r12 = r0.zzc
            android.media.metrics.PlaybackErrorEvent$Builder r13 = new android.media.metrics.PlaybackErrorEvent$Builder
            r13.<init>()
            long r14 = r0.zzd
            long r14 = r3 - r14
            android.media.metrics.PlaybackErrorEvent$Builder r13 = r13.setTimeSinceCreatedMillis(r14)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r13.setErrorCode(r7)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r7.setSubErrorCode(r8)
            android.media.metrics.PlaybackErrorEvent$Builder r5 = r7.setException(r5)
            android.media.metrics.PlaybackErrorEvent r5 = r5.build()
            r12.reportPlaybackErrorEvent(r5)
            r0.zzz = r11
            r0.zzn = r10
        L_0x029b:
            boolean r5 = r1.zzd(r6)
            if (r5 == 0) goto L_0x02c8
            com.google.android.gms.internal.ads.zzdp r5 = r19.zzo()
            boolean r7 = r5.zzb(r6)
            boolean r8 = r5.zzb(r11)
            boolean r5 = r5.zzb(r9)
            if (r7 != 0) goto L_0x02b9
            if (r8 != 0) goto L_0x02b9
            if (r5 == 0) goto L_0x02c8
            r5 = r11
        L_0x02b9:
            if (r7 != 0) goto L_0x02be
            r0.zzw(r3, r10, r2)
        L_0x02be:
            if (r8 != 0) goto L_0x02c3
            r0.zzt(r3, r10, r2)
        L_0x02c3:
            if (r5 != 0) goto L_0x02c8
            r0.zzu(r3, r10, r2)
        L_0x02c8:
            com.google.android.gms.internal.ads.zzpe r5 = r0.zzo
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02e0
            com.google.android.gms.internal.ads.zzpe r5 = r0.zzo
            com.google.android.gms.internal.ads.zzan r7 = r5.zza
            int r8 = r7.zzt
            r12 = -1
            if (r8 == r12) goto L_0x02e0
            int r5 = r5.zzb
            r0.zzw(r3, r7, r2)
            r0.zzo = r10
        L_0x02e0:
            com.google.android.gms.internal.ads.zzpe r5 = r0.zzp
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02f3
            com.google.android.gms.internal.ads.zzpe r5 = r0.zzp
            com.google.android.gms.internal.ads.zzan r7 = r5.zza
            int r5 = r5.zzb
            r0.zzt(r3, r7, r2)
            r0.zzp = r10
        L_0x02f3:
            com.google.android.gms.internal.ads.zzpe r5 = r0.zzq
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x0306
            com.google.android.gms.internal.ads.zzpe r5 = r0.zzq
            com.google.android.gms.internal.ads.zzan r7 = r5.zza
            int r5 = r5.zzb
            r0.zzu(r3, r7, r2)
            r0.zzq = r10
        L_0x0306:
            android.content.Context r5 = r0.zza
            com.google.android.gms.internal.ads.zzfs r5 = com.google.android.gms.internal.ads.zzfs.zzb(r5)
            int r5 = r5.zza()
            switch(r5) {
                case 0: goto L_0x0327;
                case 1: goto L_0x0324;
                case 2: goto L_0x0322;
                case 3: goto L_0x0320;
                case 4: goto L_0x031e;
                case 5: goto L_0x031c;
                case 6: goto L_0x0313;
                case 7: goto L_0x031a;
                case 8: goto L_0x0313;
                case 9: goto L_0x0317;
                case 10: goto L_0x0315;
                default: goto L_0x0313;
            }
        L_0x0313:
            r13 = r11
            goto L_0x0328
        L_0x0315:
            r13 = 7
            goto L_0x0328
        L_0x0317:
            r13 = 8
            goto L_0x0328
        L_0x031a:
            r13 = r9
            goto L_0x0328
        L_0x031c:
            r13 = 6
            goto L_0x0328
        L_0x031e:
            r13 = 5
            goto L_0x0328
        L_0x0320:
            r13 = 4
            goto L_0x0328
        L_0x0322:
            r13 = r6
            goto L_0x0328
        L_0x0324:
            r13 = r16
            goto L_0x0328
        L_0x0327:
            r13 = r2
        L_0x0328:
            int r5 = r0.zzm
            if (r13 == r5) goto L_0x0348
            r0.zzm = r13
            android.media.metrics.PlaybackSession r5 = r0.zzc
            android.media.metrics.NetworkEvent$Builder r7 = new android.media.metrics.NetworkEvent$Builder
            r7.<init>()
            android.media.metrics.NetworkEvent$Builder r7 = r7.setNetworkType(r13)
            long r12 = r0.zzd
            long r12 = r3 - r12
            android.media.metrics.NetworkEvent$Builder r7 = r7.setTimeSinceCreatedMillis(r12)
            android.media.metrics.NetworkEvent r7 = r7.build()
            r5.reportNetworkEvent(r7)
        L_0x0348:
            int r5 = r19.zzf()
            if (r5 == r6) goto L_0x0350
            r0.zzu = r2
        L_0x0350:
            r5 = r19
            com.google.android.gms.internal.ads.zzmt r5 = (com.google.android.gms.internal.ads.zzmt) r5
            com.google.android.gms.internal.ads.zzjh r5 = r5.zzC()
            r7 = 10
            if (r5 != 0) goto L_0x035f
            r0.zzv = r2
            goto L_0x0368
        L_0x035f:
            boolean r2 = r1.zzd(r7)
            if (r2 == 0) goto L_0x0368
            r0.zzv = r11
        L_0x0368:
            int r2 = r19.zzf()
            boolean r5 = r0.zzu
            if (r5 == 0) goto L_0x0372
            r5 = 5
            goto L_0x03bf
        L_0x0372:
            boolean r5 = r0.zzv
            if (r5 == 0) goto L_0x0379
            r5 = 13
            goto L_0x03bf
        L_0x0379:
            r5 = 4
            if (r2 != r5) goto L_0x037f
            r5 = 11
            goto L_0x03bf
        L_0x037f:
            r8 = 12
            if (r2 != r6) goto L_0x03a1
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x039f
            if (r2 == r6) goto L_0x039f
            if (r2 != r8) goto L_0x038d
            r5 = r6
            goto L_0x03bf
        L_0x038d:
            boolean r2 = r19.zzv()
            if (r2 != 0) goto L_0x0395
            r5 = 7
            goto L_0x03bf
        L_0x0395:
            int r2 = r19.zzg()
            if (r2 == 0) goto L_0x039d
            r5 = r7
            goto L_0x03bf
        L_0x039d:
            r5 = 6
            goto L_0x03bf
        L_0x039f:
            r5 = r6
            goto L_0x03bf
        L_0x03a1:
            if (r2 != r9) goto L_0x03b5
            boolean r2 = r19.zzv()
            if (r2 != 0) goto L_0x03aa
            goto L_0x03bf
        L_0x03aa:
            int r2 = r19.zzg()
            if (r2 == 0) goto L_0x03b3
            r5 = r16
            goto L_0x03bf
        L_0x03b3:
            r5 = r9
            goto L_0x03bf
        L_0x03b5:
            if (r2 != r11) goto L_0x03bd
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x03bd
            r5 = r8
            goto L_0x03bf
        L_0x03bd:
            int r5 = r0.zzl
        L_0x03bf:
            int r2 = r0.zzl
            if (r2 == r5) goto L_0x03e2
            r0.zzl = r5
            r0.zzz = r11
            android.media.metrics.PlaybackSession r2 = r0.zzc
            android.media.metrics.PlaybackStateEvent$Builder r5 = new android.media.metrics.PlaybackStateEvent$Builder
            r5.<init>()
            int r6 = r0.zzl
            android.media.metrics.PlaybackStateEvent$Builder r5 = r5.setState(r6)
            long r6 = r0.zzd
            long r3 = r3 - r6
            android.media.metrics.PlaybackStateEvent$Builder r3 = r5.setTimeSinceCreatedMillis(r3)
            android.media.metrics.PlaybackStateEvent r3 = r3.build()
            r2.reportPlaybackStateEvent(r3)
        L_0x03e2:
            r2 = 1028(0x404, float:1.44E-42)
            boolean r3 = r1.zzd(r2)
            if (r3 == 0) goto L_0x03f5
            com.google.android.gms.internal.ads.zzph r3 = r0.zzb
            com.google.android.gms.internal.ads.zzmy r1 = r1.zzc(r2)
            r3.zzg(r1)
            return
        L_0x03f5:
            return
        L_0x03f6:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpf.zzi(com.google.android.gms.internal.ads.zzct, com.google.android.gms.internal.ads.zzmz):void");
    }

    public final void zzj(zzmy zzmy, zzvf zzvf, zzvk zzvk, IOException iOException, boolean z) {
    }

    public final /* synthetic */ void zzk(zzmy zzmy, int i) {
    }

    public final void zzl(zzmy zzmy, zzcj zzcj) {
        this.zzn = zzcj;
    }

    public final void zzm(zzmy zzmy, zzcs zzcs, zzcs zzcs2, int i) {
        if (i == 1) {
            this.zzu = true;
            i = 1;
        }
        this.zzk = i;
    }

    public final /* synthetic */ void zzn(zzmy zzmy, Object obj, long j) {
    }

    public final void zzo(zzmy zzmy, zzix zzix) {
        this.zzw += zzix.zzg;
        this.zzx += zzix.zze;
    }

    public final /* synthetic */ void zzp(zzmy zzmy, zzan zzan, zziy zziy) {
    }

    public final void zzq(zzmy zzmy, zzdv zzdv) {
        zzpe zzpe = this.zzo;
        if (zzpe != null) {
            zzan zzan = zzpe.zza;
            if (zzan.zzt == -1) {
                zzal zzb2 = zzan.zzb();
                zzb2.zzac(zzdv.zzc);
                zzb2.zzI(zzdv.zzd);
                this.zzo = new zzpe(zzb2.zzad(), 0, zzpe.zzc);
            }
        }
    }
}
