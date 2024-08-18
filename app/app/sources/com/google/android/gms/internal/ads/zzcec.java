package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import androidx.work.Data;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcec extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzcea {
    private static final float[] zza = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean zzA;
    private volatile boolean zzB;
    private final zzceb zzb;
    private final float[] zzc;
    private final float[] zzd;
    private final float[] zze;
    private final float[] zzf;
    private final float[] zzg;
    private final float[] zzh;
    private final float[] zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;
    private int zzn;
    private SurfaceTexture zzo;
    private SurfaceTexture zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private final FloatBuffer zzt = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private final CountDownLatch zzu;
    private final Object zzv;
    private EGL10 zzw;
    private EGLDisplay zzx;
    private EGLContext zzy;
    private EGLSurface zzz;

    public zzcec(Context context) {
        super("SphericalVideoProcessor");
        int length = zza.length;
        this.zzt.put(zza).position(0);
        this.zzc = new float[9];
        this.zzd = new float[9];
        this.zze = new float[9];
        this.zzf = new float[9];
        this.zzg = new float[9];
        this.zzh = new float[9];
        this.zzi = new float[9];
        this.zzj = Float.NaN;
        this.zzb = new zzceb(context);
        this.zzb.zzb(this);
        this.zzu = new CountDownLatch(1);
        this.zzv = new Object();
    }

    private static final void zzh(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("SphericalVideoRenderer", str + ": glError " + glGetError);
        }
    }

    private static final void zzi(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static final void zzj(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static final void zzk(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static final int zzl(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzh("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            zzh("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            zzh("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            zzh("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", "Could not compile shader " + i + ":");
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                zzh("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzs++;
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    public final void run() {
        boolean z;
        String str;
        int i;
        String str2;
        EGLConfig eGLConfig;
        if (this.zzp != null) {
            this.zzw = (EGL10) EGLContext.getEGL();
            this.zzx = this.zzw.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.zzx == EGL10.EGL_NO_DISPLAY) {
                z = false;
            } else {
                if (!this.zzw.eglInitialize(this.zzx, new int[2])) {
                    z = false;
                } else {
                    int[] iArr = new int[1];
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    if (!this.zzw.eglChooseConfig(this.zzx, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr)) {
                        eGLConfig = null;
                    } else {
                        eGLConfig = iArr[0] > 0 ? eGLConfigArr[0] : null;
                    }
                    if (eGLConfig == null) {
                        z = false;
                    } else {
                        this.zzy = this.zzw.eglCreateContext(this.zzx, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                        EGLContext eGLContext = this.zzy;
                        if (eGLContext != null) {
                            if (eGLContext == EGL10.EGL_NO_CONTEXT) {
                                z = false;
                            } else {
                                this.zzz = this.zzw.eglCreateWindowSurface(this.zzx, eGLConfig, this.zzp, (int[]) null);
                                EGLSurface eGLSurface = this.zzz;
                                if (eGLSurface != null) {
                                    if (eGLSurface == EGL10.EGL_NO_SURFACE) {
                                        z = false;
                                    } else {
                                        EGL10 egl10 = this.zzw;
                                        EGLDisplay eGLDisplay = this.zzx;
                                        EGLSurface eGLSurface2 = this.zzz;
                                        if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.zzy)) {
                                            z = true;
                                        }
                                    }
                                }
                            }
                        }
                        z = false;
                    }
                }
            }
            zzbeg zzbeg = zzbep.zzbk;
            if (!((String) zzba.zzc().zza(zzbeg)).equals(zzbeg.zzm())) {
                str = (String) zzba.zzc().zza(zzbeg);
            } else {
                str = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}";
            }
            int zzl2 = zzl(35633, str);
            if (zzl2 == 0) {
                i = 0;
            } else {
                zzbeg zzbeg2 = zzbep.zzbl;
                if (!((String) zzba.zzc().zza(zzbeg2)).equals(zzbeg2.zzm())) {
                    str2 = (String) zzba.zzc().zza(zzbeg2);
                } else {
                    str2 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}";
                }
                int zzl3 = zzl(35632, str2);
                if (zzl3 == 0) {
                    i = 0;
                } else {
                    i = GLES20.glCreateProgram();
                    zzh("createProgram");
                    if (i != 0) {
                        GLES20.glAttachShader(i, zzl2);
                        zzh("attachShader");
                        GLES20.glAttachShader(i, zzl3);
                        zzh("attachShader");
                        GLES20.glLinkProgram(i);
                        zzh("linkProgram");
                        int[] iArr2 = new int[1];
                        GLES20.glGetProgramiv(i, 35714, iArr2, 0);
                        zzh("getProgramiv");
                        if (iArr2[0] != 1) {
                            Log.e("SphericalVideoRenderer", "Could not link program: ");
                            Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(i));
                            GLES20.glDeleteProgram(i);
                            zzh("deleteProgram");
                            i = 0;
                        } else {
                            GLES20.glValidateProgram(i);
                            zzh("validateProgram");
                        }
                    }
                }
            }
            this.zzq = i;
            GLES20.glUseProgram(i);
            zzh("useProgram");
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.zzq, "aPosition");
            GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, this.zzt);
            zzh("vertexAttribPointer");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            zzh("enableVertexAttribArray");
            int[] iArr3 = new int[1];
            GLES20.glGenTextures(1, iArr3, 0);
            zzh("genTextures");
            int i2 = iArr3[0];
            GLES20.glBindTexture(36197, i2);
            zzh("bindTextures");
            GLES20.glTexParameteri(36197, Data.MAX_DATA_BYTES, 9729);
            zzh("texParameteri");
            GLES20.glTexParameteri(36197, 10241, 9729);
            zzh("texParameteri");
            GLES20.glTexParameteri(36197, 10242, 33071);
            zzh("texParameteri");
            GLES20.glTexParameteri(36197, 10243, 33071);
            zzh("texParameteri");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.zzq, "uVMat");
            this.zzr = glGetUniformLocation;
            GLES20.glUniformMatrix3fv(glGetUniformLocation, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
            int i3 = this.zzq;
            if (!z || i3 == 0) {
                String concat = "EGL initialization failed: ".concat(String.valueOf(GLUtils.getEGLErrorString(this.zzw.eglGetError())));
                zzm.zzg(concat);
                zzu.zzo().zzw(new Throwable(concat), "SphericalVideoProcessor.run.1");
                zzg();
                this.zzu.countDown();
                return;
            }
            this.zzo = new SurfaceTexture(i2);
            this.zzo.setOnFrameAvailableListener(this);
            this.zzu.countDown();
            this.zzb.zzc();
            try {
                this.zzA = true;
                while (!this.zzB) {
                    while (this.zzs > 0) {
                        this.zzo.updateTexImage();
                        this.zzs--;
                    }
                    if (this.zzb.zze(this.zzc)) {
                        if (Float.isNaN(this.zzj)) {
                            float[] fArr = this.zzc;
                            float[] fArr2 = {0.0f, 1.0f, 0.0f};
                            float f = fArr[0];
                            float f2 = fArr2[0];
                            float f3 = fArr[1];
                            float f4 = fArr2[1];
                            float[] fArr3 = {(f * f2) + (f3 * f4) + (fArr[2] * 0.0f), (fArr[3] * f2) + (fArr[4] * f4) + (fArr[5] * 0.0f), (fArr[6] * f2) + (fArr[7] * f4) + (fArr[8] * 0.0f)};
                            this.zzj = -(((float) Math.atan2((double) fArr3[1], (double) fArr3[0])) - 2.8584073f);
                        }
                        zzk(this.zzh, this.zzj + this.zzk);
                    } else {
                        zzj(this.zzc, -1.5707964f);
                        zzk(this.zzh, this.zzk);
                    }
                    zzj(this.zzd, 1.5707964f);
                    zzi(this.zze, this.zzh, this.zzd);
                    zzi(this.zzf, this.zzc, this.zze);
                    zzj(this.zzg, this.zzl);
                    zzi(this.zzi, this.zzg, this.zzf);
                    GLES20.glUniformMatrix3fv(this.zzr, 1, false, this.zzi, 0);
                    GLES20.glDrawArrays(5, 0, 4);
                    zzh("drawArrays");
                    GLES20.glFinish();
                    this.zzw.eglSwapBuffers(this.zzx, this.zzz);
                    if (this.zzA) {
                        GLES20.glViewport(0, 0, this.zzn, this.zzm);
                        zzh("viewport");
                        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.zzq, "uFOVx");
                        int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.zzq, "uFOVy");
                        int i4 = this.zzn;
                        int i5 = this.zzm;
                        if (i4 > i5) {
                            GLES20.glUniform1f(glGetUniformLocation2, 0.87266463f);
                            GLES20.glUniform1f(glGetUniformLocation3, (((float) this.zzm) * 0.87266463f) / ((float) this.zzn));
                        } else {
                            GLES20.glUniform1f(glGetUniformLocation2, (((float) i4) * 0.87266463f) / ((float) i5));
                            GLES20.glUniform1f(glGetUniformLocation3, 0.87266463f);
                        }
                        this.zzA = false;
                    }
                    try {
                        synchronized (this.zzv) {
                            if (!this.zzB && !this.zzA && this.zzs == 0) {
                                this.zzv.wait();
                            }
                        }
                    } catch (InterruptedException e) {
                    }
                }
            } catch (IllegalStateException e2) {
                zzm.zzj("SphericalVideoProcessor halted unexpectedly.");
            } catch (Throwable th) {
                this.zzb.zzd();
                this.zzo.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                this.zzo = null;
                zzg();
                throw th;
            }
            this.zzb.zzd();
            this.zzo.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
            this.zzo = null;
            zzg();
            return;
        }
        zzm.zzg("SphericalVideoProcessor started with no output texture.");
        this.zzu.countDown();
    }

    public final void zza() {
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    public final SurfaceTexture zzb() {
        if (this.zzp == null) {
            return null;
        }
        try {
            this.zzu.await();
        } catch (InterruptedException e) {
        }
        return this.zzo;
    }

    public final void zzc(int i, int i2) {
        synchronized (this.zzv) {
            this.zzn = i;
            this.zzm = i2;
            this.zzA = true;
            this.zzv.notifyAll();
        }
    }

    public final void zzd(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zzn = i;
        this.zzm = i2;
        this.zzp = surfaceTexture;
    }

    public final void zze() {
        synchronized (this.zzv) {
            this.zzB = true;
            this.zzp = null;
            this.zzv.notifyAll();
        }
    }

    public final void zzf(float f, float f2) {
        int i = this.zzn;
        int i2 = this.zzm;
        if (i <= i2) {
            i = i2;
        }
        float f3 = (float) i;
        this.zzk -= (f * 1.7453293f) / f3;
        float f4 = this.zzl - ((f2 * 1.7453293f) / f3);
        this.zzl = f4;
        if (f4 < -1.5707964f) {
            this.zzl = -1.5707964f;
            f4 = -1.5707964f;
        }
        if (f4 > 1.5707964f) {
            this.zzl = 1.5707964f;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        EGLSurface eGLSurface = this.zzz;
        boolean z = false;
        if (!(eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE)) {
            z = this.zzw.eglDestroySurface(this.zzx, this.zzz) | this.zzw.eglMakeCurrent(this.zzx, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.zzz = null;
        }
        EGLContext eGLContext = this.zzy;
        if (eGLContext != null) {
            z |= this.zzw.eglDestroyContext(this.zzx, eGLContext);
            this.zzy = null;
        }
        EGLDisplay eGLDisplay = this.zzx;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = this.zzw.eglTerminate(eGLDisplay) | z;
        this.zzx = null;
        return eglTerminate;
    }
}
