package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzig extends zzgv {
    private final byte[] zza;
    private final DatagramPacket zzb;
    private Uri zzc;
    private DatagramSocket zzd;
    private MulticastSocket zze;
    private InetAddress zzf;
    private boolean zzg;
    private int zzh;

    public zzig() {
        throw null;
    }

    public zzig(int i) {
        super(true);
        this.zza = new byte[CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE];
        this.zzb = new DatagramPacket(this.zza, 0, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzif {
        if (i2 == 0) {
            return 0;
        }
        if (this.zzh == 0) {
            try {
                DatagramSocket datagramSocket = this.zzd;
                if (datagramSocket != null) {
                    datagramSocket.receive(this.zzb);
                    int length = this.zzb.getLength();
                    this.zzh = length;
                    zzg(length);
                } else {
                    throw null;
                }
            } catch (SocketTimeoutException e) {
                throw new zzif(e, 2002);
            } catch (IOException e2) {
                throw new zzif(e2, 2001);
            }
        }
        int length2 = this.zzb.getLength();
        int i3 = this.zzh;
        int min = Math.min(i3, i2);
        System.arraycopy(this.zza, length2 - i3, bArr, i, min);
        this.zzh -= min;
        return min;
    }

    public final long zzb(zzhh zzhh) throws zzif {
        this.zzc = zzhh.zza;
        String host = this.zzc.getHost();
        if (host != null) {
            int port = this.zzc.getPort();
            zzi(zzhh);
            try {
                this.zzf = InetAddress.getByName(host);
                InetSocketAddress inetSocketAddress = new InetSocketAddress(this.zzf, port);
                if (this.zzf.isMulticastAddress()) {
                    this.zze = new MulticastSocket(inetSocketAddress);
                    this.zze.joinGroup(this.zzf);
                    this.zzd = this.zze;
                } else {
                    this.zzd = new DatagramSocket(inetSocketAddress);
                }
                this.zzd.setSoTimeout(8000);
                this.zzg = true;
                zzj(zzhh);
                return -1;
            } catch (SecurityException e) {
                throw new zzif(e, 2006);
            } catch (IOException e2) {
                throw new zzif(e2, 2001);
            }
        } else {
            throw null;
        }
    }

    public final Uri zzc() {
        return this.zzc;
    }

    public final void zzd() {
        this.zzc = null;
        MulticastSocket multicastSocket = this.zze;
        if (multicastSocket != null) {
            try {
                InetAddress inetAddress = this.zzf;
                if (inetAddress != null) {
                    multicastSocket.leaveGroup(inetAddress);
                    this.zze = null;
                } else {
                    throw null;
                }
            } catch (IOException e) {
            }
        }
        DatagramSocket datagramSocket = this.zzd;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.zzd = null;
        }
        this.zzf = null;
        this.zzh = 0;
        if (this.zzg) {
            this.zzg = false;
            zzh();
        }
    }
}
