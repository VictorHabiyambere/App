package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdum {
    public static final zzgbc zza;
    public static final zzgbc zzb;
    private final String zzc;
    private final zzdul zzd;
    private final zzdul zze;

    static {
        zzdul zzdul = zzdul.PUBLIC_API_CALL;
        zzdul zzdul2 = zzdul.PUBLIC_API_CALLBACK;
        zzdum zzdum = new zzdum("tqgt", zzdul, zzdul2);
        zzdul zzdul3 = zzdul.PUBLIC_API_CALL;
        zzdul zzdul4 = zzdul.DYNAMITE_ENTER;
        zzdum zzdum2 = new zzdum("l.dl", zzdul3, zzdul4);
        zzdul zzdul5 = zzdul.CLIENT_SIGNALS_START;
        zzdum zzdum3 = new zzdum("l.rcc", zzdul4, zzdul5);
        zzdul zzdul6 = zzdul.CLIENT_SIGNALS_END;
        zzdum zzdum4 = new zzdum("l.cs", zzdul5, zzdul6);
        zzdum zzdum5 = new zzdum("l.cts", zzdul6, zzdul.SERVICE_CONNECTED);
        zzdul zzdul7 = zzdul.GMS_SIGNALS_START;
        zzdul zzdul8 = zzdul.GMS_SIGNALS_END;
        zzdum zzdum6 = new zzdum("l.gs", zzdul7, zzdul8);
        zzdul zzdul9 = zzdul.GET_SIGNALS_SDKCORE_START;
        zzdum zzdum7 = new zzdum("l.jse", zzdul8, zzdul9);
        zzdul zzdul10 = zzdul.GET_SIGNALS_SDKCORE_END;
        zza = zzgbc.zzs(zzdum, zzdum2, zzdum3, zzdum4, zzdum5, zzdum6, zzdum7, new zzdum("l.gs-sdkcore", zzdul9, zzdul10), new zzdum("l.gs-pp", zzdul10, zzdul2));
        zzdul zzdul11 = zzdul.PUBLIC_API_CALL;
        zzdum zzdum8 = new zzdum("l.al", zzdul11, zzdul.PUBLIC_API_CALLBACK);
        zzdul zzdul12 = zzdul.DYNAMITE_ENTER;
        zzdum zzdum9 = new zzdum("l.dl", zzdul11, zzdul12);
        zzdul zzdul13 = zzdul.CLIENT_SIGNALS_START;
        zzdum zzdum10 = new zzdum("l.rcc", zzdul12, zzdul13);
        zzdul zzdul14 = zzdul.CLIENT_SIGNALS_END;
        zzdum zzdum11 = new zzdum("l.cs", zzdul13, zzdul14);
        zzdum zzdum12 = new zzdum("l.cts", zzdul14, zzdul.SERVICE_CONNECTED);
        zzdul zzdul15 = zzdul.GMS_SIGNALS_START;
        zzdul zzdul16 = zzdul.GMS_SIGNALS_END;
        zzdum zzdum13 = new zzdum("l.gs", zzdul15, zzdul16);
        zzdul zzdul17 = zzdul.GET_AD_DICTIONARY_SDKCORE_START;
        zzdum zzdum14 = new zzdum("l.jse", zzdul16, zzdul17);
        zzdul zzdul18 = zzdul.GET_AD_DICTIONARY_SDKCORE_END;
        zzdum zzdum15 = new zzdum("l.gad-js", zzdul17, zzdul18);
        zzdul zzdul19 = zzdul.HTTP_RESPONSE_READY;
        zzb = zzgbc.zzt(zzdum8, zzdum9, zzdum10, zzdum11, zzdum12, zzdum13, zzdum14, zzdum15, new zzdum("l.http", zzdul18, zzdul19), new zzdum("l.nml-js", zzdul19, zzdul.SERVER_RESPONSE_PARSE_START));
    }

    public zzdum(String str, zzdul zzdul, zzdul zzdul2) {
        this.zzc = str;
        this.zzd = zzdul;
        this.zze = zzdul2;
    }

    public final zzdul zza() {
        return this.zzd;
    }

    public final zzdul zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }
}
