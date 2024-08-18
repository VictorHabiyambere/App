package com.google.android.gms.internal.ads;

import androidx.core.view.accessibility.AccessibilityEventCompat;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaus extends zzhbo implements zzhdf {
    /* access modifiers changed from: private */
    public static final zzaus zza;
    private static volatile zzhdm zzb;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzE;
    private String zzF = "";
    private String zzG = "D";
    private String zzH = "";
    private long zzI;
    private long zzJ;
    private long zzK;
    private String zzL = "";
    private long zzM;
    private long zzN = -1;
    private long zzO = -1;
    private zzauu zzP;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private long zzU = -1;
    private long zzV = -1;
    private String zzW = "D";
    private String zzX = "D";
    private long zzY = -1;
    private int zzZ = 1000;
    private int zzaA = 1000;
    private String zzaB = "D";
    private zzhca zzaC = zzbK();
    private int zzaD = 1000;
    private zzhca zzaE = zzbK();
    private zzaun zzaF;
    private String zzaG = "";
    private long zzaH = -1;
    private long zzaI = -1;
    private long zzaJ = -1;
    private long zzaK = -1;
    private long zzaL;
    private long zzaM = -1;
    private String zzaN = "";
    private zzauc zzaO;
    private zzaue zzaP;
    private long zzaQ = -1;
    private long zzaR = -1;
    private int zzaS;
    private long zzaT;
    private String zzaU = "";
    private int zzaV = 2;
    private boolean zzaW;
    private String zzaX = "";
    private long zzaY;
    private zzavh zzaZ;
    private int zzaa = 1000;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private long zzae = -1;
    private long zzaf = -1;
    private int zzag = 1000;
    private zzaup zzah;
    /* access modifiers changed from: private */
    public zzhca zzai = zzbK();
    private zzaur zzaj;
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private long zzap = -1;
    private long zzaq = -1;
    private long zzar = -1;
    private String zzas = "D";
    private long zzat = -1;
    private int zzau;
    private int zzav;
    private int zzaw;
    private zzavj zzax;
    private long zzay = -1;
    private int zzaz = 1000;
    private long zzba = -1;
    private String zzbb = "";
    private int zzc;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzu;
    private String zzv = "";
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        zzaus zzaus = new zzaus();
        zza = zzaus;
        zzhbo.zzca(zzaus.class, zzaus);
    }

    private zzaus() {
    }

    static /* synthetic */ void zzA(zzaus zzaus, long j) {
        zzaus.zzc |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        zzaus.zzJ = j;
    }

    static /* synthetic */ void zzB(zzaus zzaus, long j) {
        zzaus.zzc |= 134217728;
        zzaus.zzK = j;
    }

    static /* synthetic */ void zzC(zzaus zzaus, String str) {
        str.getClass();
        zzaus.zzc |= 268435456;
        zzaus.zzL = str;
    }

    static /* synthetic */ void zzD(zzaus zzaus, long j) {
        zzaus.zzc |= 536870912;
        zzaus.zzM = j;
    }

    static /* synthetic */ void zzE(zzaus zzaus, long j) {
        zzaus.zzc |= 1073741824;
        zzaus.zzN = j;
    }

    static /* synthetic */ void zzF(zzaus zzaus, long j) {
        zzaus.zzc |= Integer.MIN_VALUE;
        zzaus.zzO = j;
    }

    static /* synthetic */ void zzG(zzaus zzaus, long j) {
        zzaus.zzd |= 2;
        zzaus.zzQ = j;
    }

    static /* synthetic */ void zzH(zzaus zzaus, long j) {
        zzaus.zzd |= 4;
        zzaus.zzR = j;
    }

    static /* synthetic */ void zzI(zzaus zzaus, long j) {
        zzaus.zzd |= 8;
        zzaus.zzS = j;
    }

    static /* synthetic */ void zzJ(zzaus zzaus, long j) {
        zzaus.zzd |= 16;
        zzaus.zzT = j;
    }

    static /* synthetic */ void zzK(zzaus zzaus, long j) {
        zzaus.zzd |= 32;
        zzaus.zzU = j;
    }

    static /* synthetic */ void zzL(zzaus zzaus, long j) {
        zzaus.zzd |= 64;
        zzaus.zzV = j;
    }

    static /* synthetic */ void zzM(zzaus zzaus, String str) {
        str.getClass();
        zzaus.zzd |= 128;
        zzaus.zzW = str;
    }

    static /* synthetic */ void zzN(zzaus zzaus, String str) {
        str.getClass();
        zzaus.zzd |= 256;
        zzaus.zzX = str;
    }

    static /* synthetic */ void zzO(zzaus zzaus, zzavc zzavc) {
        zzaus.zzZ = zzavc.zza();
        zzaus.zzd |= 1024;
    }

    static /* synthetic */ void zzP(zzaus zzaus, zzavc zzavc) {
        zzaus.zzaa = zzavc.zza();
        zzaus.zzd |= 2048;
    }

    static /* synthetic */ void zzQ(zzaus zzaus, long j) {
        zzaus.zzd |= 4096;
        zzaus.zzab = j;
    }

    static /* synthetic */ void zzR(zzaus zzaus, long j) {
        zzaus.zzd |= 8192;
        zzaus.zzac = j;
    }

    static /* synthetic */ void zzS(zzaus zzaus, long j) {
        zzaus.zzd |= 16384;
        zzaus.zzad = j;
    }

    static /* synthetic */ void zzT(zzaus zzaus, zzavc zzavc) {
        zzaus.zzag = zzavc.zza();
        zzaus.zzd |= 131072;
    }

    static /* synthetic */ void zzU(zzaus zzaus, zzaup zzaup) {
        zzaup.getClass();
        zzaus.zzah = zzaup;
        zzaus.zzd |= 262144;
    }

    static /* synthetic */ void zzV(zzaus zzaus, zzaup zzaup) {
        zzaup.getClass();
        zzhca zzhca = zzaus.zzai;
        if (!zzhca.zzc()) {
            zzaus.zzai = zzhbo.zzbL(zzhca);
        }
        zzaus.zzai.add(zzaup);
    }

    static /* synthetic */ void zzX(zzaus zzaus, zzaur zzaur) {
        zzaur.getClass();
        zzaus.zzaj = zzaur;
        zzaus.zzd |= 524288;
    }

    static /* synthetic */ void zzY(zzaus zzaus, long j) {
        zzaus.zzd |= 2097152;
        zzaus.zzal = j;
    }

    static /* synthetic */ void zzZ(zzaus zzaus, long j) {
        zzaus.zzd |= 4194304;
        zzaus.zzam = j;
    }

    public static zzatp zza() {
        return (zzatp) zza.zzaZ();
    }

    static /* synthetic */ void zzaa(zzaus zzaus, long j) {
        zzaus.zzd |= 8388608;
        zzaus.zzan = j;
    }

    static /* synthetic */ void zzab(zzaus zzaus, long j) {
        zzaus.zzd |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        zzaus.zzaq = j;
    }

    static /* synthetic */ void zzac(zzaus zzaus, long j) {
        zzaus.zzd |= 134217728;
        zzaus.zzar = j;
    }

    static /* synthetic */ void zzad(zzaus zzaus, String str) {
        str.getClass();
        zzaus.zzd |= 268435456;
        zzaus.zzas = str;
    }

    static /* synthetic */ void zzae(zzaus zzaus, zzavc zzavc) {
        zzaus.zzaz = zzavc.zza();
        zzaus.zze |= 8;
    }

    static /* synthetic */ void zzaf(zzaus zzaus, zzavc zzavc) {
        zzaus.zzaA = zzavc.zza();
        zzaus.zze |= 16;
    }

    static /* synthetic */ void zzag(zzaus zzaus, long j) {
        zzaus.zze |= 512;
        zzaus.zzaH = j;
    }

    static /* synthetic */ void zzah(zzaus zzaus, long j) {
        zzaus.zze |= 1024;
        zzaus.zzaI = j;
    }

    static /* synthetic */ void zzai(zzaus zzaus, long j) {
        zzaus.zze |= 2048;
        zzaus.zzaJ = j;
    }

    static /* synthetic */ void zzaj(zzaus zzaus, long j) {
        zzaus.zze |= 4096;
        zzaus.zzaK = j;
    }

    static /* synthetic */ void zzak(zzaus zzaus, String str) {
        str.getClass();
        zzaus.zze |= 32768;
        zzaus.zzaN = str;
    }

    static /* synthetic */ void zzal(zzaus zzaus, zzauh zzauh) {
        zzaus.zzaS = zzauh.zza();
        zzaus.zze |= 1048576;
    }

    static /* synthetic */ void zzam(zzaus zzaus, String str) {
        str.getClass();
        zzaus.zze |= 4194304;
        zzaus.zzaU = str;
    }

    static /* synthetic */ void zzan(zzaus zzaus, zzatx zzatx) {
        zzaus.zzaV = zzatx.zza();
        zzaus.zze |= 8388608;
    }

    static /* synthetic */ void zzao(zzaus zzaus, boolean z) {
        zzaus.zze |= 16777216;
        zzaus.zzaW = z;
    }

    static /* synthetic */ void zzap(zzaus zzaus, long j) {
        zzaus.zze |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        zzaus.zzaY = j;
    }

    public static zzaus zze() {
        return zza;
    }

    public static zzaus zzf(byte[] bArr, zzhay zzhay) throws zzhcd {
        return (zzaus) zzhbo.zzbx(zza, bArr, zzhay);
    }

    static /* synthetic */ void zzj(zzaus zzaus, String str) {
        str.getClass();
        zzaus.zzc |= 1;
        zzaus.zzf = str;
    }

    static /* synthetic */ void zzk(zzaus zzaus, String str) {
        str.getClass();
        zzaus.zzc |= 2;
        zzaus.zzg = str;
    }

    static /* synthetic */ void zzl(zzaus zzaus, long j) {
        zzaus.zzc |= 4;
        zzaus.zzh = j;
    }

    static /* synthetic */ void zzm(zzaus zzaus, long j) {
        zzaus.zzc |= 16;
        zzaus.zzj = j;
    }

    static /* synthetic */ void zzn(zzaus zzaus, long j) {
        zzaus.zzc |= 32;
        zzaus.zzk = j;
    }

    static /* synthetic */ void zzo(zzaus zzaus, long j) {
        zzaus.zzc |= 1024;
        zzaus.zzp = j;
    }

    static /* synthetic */ void zzp(zzaus zzaus, long j) {
        zzaus.zzc |= 2048;
        zzaus.zzu = j;
    }

    static /* synthetic */ void zzq(zzaus zzaus, long j) {
        zzaus.zzc |= 8192;
        zzaus.zzw = j;
    }

    static /* synthetic */ void zzr(zzaus zzaus, long j) {
        zzaus.zzc |= 16384;
        zzaus.zzx = j;
    }

    static /* synthetic */ void zzs(zzaus zzaus, long j) {
        zzaus.zzc |= 32768;
        zzaus.zzy = j;
    }

    static /* synthetic */ void zzt(zzaus zzaus, long j) {
        zzaus.zzc |= 65536;
        zzaus.zzz = j;
    }

    static /* synthetic */ void zzu(zzaus zzaus, long j) {
        zzaus.zzc |= 524288;
        zzaus.zzC = j;
    }

    static /* synthetic */ void zzv(zzaus zzaus, long j) {
        zzaus.zzc |= 1048576;
        zzaus.zzD = j;
    }

    static /* synthetic */ void zzw(zzaus zzaus, long j) {
        zzaus.zzc |= 2097152;
        zzaus.zzE = j;
    }

    static /* synthetic */ void zzx(zzaus zzaus, String str) {
        str.getClass();
        zzaus.zzc |= 4194304;
        zzaus.zzF = str;
    }

    static /* synthetic */ void zzy(zzaus zzaus, String str) {
        str.getClass();
        zzaus.zzc |= 16777216;
        zzaus.zzH = str;
    }

    static /* synthetic */ void zzz(zzaus zzaus, long j) {
        zzaus.zzc |= 33554432;
        zzaus.zzI = j;
    }

    public final boolean zzaq() {
        return this.zzaW;
    }

    public final boolean zzar() {
        return (this.zzc & 4194304) != 0;
    }

    public final boolean zzas() {
        return (this.zze & 134217728) != 0;
    }

    public final zzatx zzc() {
        zzatx zzb2 = zzatx.zzb(this.zzaV);
        return zzb2 == null ? zzatx.DEVICE_IDENTIFIER_GLOBAL_ID : zzb2;
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzhbn zzhbn, Object obj, Object obj2) {
        zzhbn zzhbn2 = zzhbn.GET_MEMOIZED_IS_INITIALIZED;
        switch (zzhbn.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                zzhbu zzhbu = zzavb.zza;
                zzhbu zzhbu2 = zzavb.zza;
                zzhbu zzhbu3 = zzauy.zza;
                zzhbu zzhbu4 = zzave.zza;
                zzhbu zzhbu5 = zzatr.zza;
                zzhbu zzhbu6 = zzavb.zza;
                zzhbu zzhbu7 = zzhbu6;
                Class<zzaul> cls = zzaul.class;
                return zzbR(zza, "\u0001a\u0000\u0003\u0001Įa\u0000\u0003\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂU\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈV\u0019ဂZ\u001a᠌W\u001bဈ\u0016\u001cဇX\u001dဈ\u0018\u001eဈY\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌@EဉAFဂBGဂ8Hဂ9I᠌CJဂ)Kဈ\u0017L᠌DMဈEN\u001bO᠌FP\u001bQဉGRဈHSဂITဂJUဂKVဂLWဂMXဂNYဈOZဉP[ဉQ\\ဂR]ဂS^᠌TÉဉ[ĭဂ\\Įဈ]", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzaT", "zzD", "zzE", "zzaU", "zzaY", "zzaV", zzatw.zza, "zzF", "zzaW", "zzH", "zzaX", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzai", zzaup.class, "zzU", "zzV", "zzW", "zzX", "zzZ", zzhbu, "zzaa", zzhbu2, "zzah", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", zzhbu2, "zzaj", "zzak", "zzal", "zzam", "zzan", "zzaq", "zzar", "zzat", "zzau", zzhbu3, "zzav", zzhbu4, "zzas", "zzaw", zzhbu5, "zzax", "zzay", "zzao", "zzap", "zzaz", zzhbu6, "zzY", "zzG", "zzaA", zzhbu7, "zzaB", "zzaC", cls, "zzaD", zzhbu6, "zzaE", zzatu.class, "zzaF", "zzaG", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaN", "zzaO", "zzaP", "zzaQ", "zzaR", "zzaS", zzaug.zza, "zzaZ", "zzba", "zzbb"});
            case 3:
                return new zzaus();
            case 4:
                return new zzatp((zzato) null);
            case 5:
                return zza;
            case 6:
                zzhdm zzhdm = zzb;
                if (zzhdm == null) {
                    synchronized (zzaus.class) {
                        zzhdm = zzb;
                        if (zzhdm == null) {
                            zzhdm = new zzhbj(zza);
                            zzb = zzhdm;
                        }
                    }
                }
                return zzhdm;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzavh zzg() {
        zzavh zzavh = this.zzaZ;
        return zzavh == null ? zzavh.zzd() : zzavh;
    }

    public final String zzh() {
        return this.zzaU;
    }

    public final String zzi() {
        return this.zzF;
    }
}
