package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzsi extends zzea {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    zzsi() {
    }

    private static void zzo(int i, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i) * 4.656612875245797E-10d));
        if (floatToIntBits == zzd) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public final void zze(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        switch (this.zzb.zzd) {
            case 21:
                byteBuffer2 = zzj((i / 3) * 4);
                while (position < limit) {
                    zzo(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << Ascii.DLE) | ((byteBuffer.get(position + 2) & 255) << Ascii.CAN), byteBuffer2);
                    position += 3;
                }
                break;
            case 22:
                byteBuffer2 = zzj(i);
                while (position < limit) {
                    zzo((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << Ascii.DLE) | ((byteBuffer.get(position + 3) & 255) << Ascii.CAN), byteBuffer2);
                    position += 4;
                }
                break;
            case 1342177280:
                byteBuffer2 = zzj((i / 3) * 4);
                while (position < limit) {
                    zzo(((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << Ascii.DLE) | ((byteBuffer.get(position) & 255) << Ascii.CAN), byteBuffer2);
                    position += 3;
                }
                break;
            case 1610612736:
                byteBuffer2 = zzj(i);
                while (position < limit) {
                    zzo((byteBuffer.get(position + 3) & 255) | ((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << Ascii.DLE) | ((byteBuffer.get(position) & 255) << Ascii.CAN), byteBuffer2);
                    position += 4;
                }
                break;
            default:
                throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public final zzdx zzi(zzdx zzdx) throws zzdy {
        int i = zzdx.zzd;
        int i2 = zzgd.zza;
        if (i == 21 || i == 1342177280 || i == 22 || i == 1610612736) {
            return new zzdx(zzdx.zzb, zzdx.zzc, 4);
        }
        if (i == 4) {
            return zzdx.zza;
        }
        throw new zzdy("Unhandled input format:", zzdx);
    }
}
