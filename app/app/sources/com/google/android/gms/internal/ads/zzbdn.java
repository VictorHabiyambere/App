package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import androidx.core.view.PointerIconCompat;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbdn implements zzhbt {
    zzbdn() {
    }

    public final /* synthetic */ zzhbs zza(int i) {
        zzbdo zzbdo = zzbdo.UNKNOWN_EVENT_TYPE;
        switch (i) {
            case 0:
                return zzbdo.UNKNOWN_EVENT_TYPE;
            case 1:
                return zzbdo.AD_REQUEST;
            case 2:
                return zzbdo.AD_LOADED;
            case 3:
                return zzbdo.AD_FAILED_TO_LOAD;
            case 4:
                return zzbdo.AD_FAILED_TO_LOAD_NO_FILL;
            case 5:
                return zzbdo.AD_IMPRESSION;
            case 6:
                return zzbdo.AD_FIRST_CLICK;
            case 7:
                return zzbdo.AD_SUBSEQUENT_CLICK;
            case 8:
                return zzbdo.REQUEST_WILL_START;
            case 9:
                return zzbdo.REQUEST_DID_END;
            case 10:
                return zzbdo.REQUEST_WILL_UPDATE_SIGNALS;
            case 11:
                return zzbdo.REQUEST_DID_UPDATE_SIGNALS;
            case 12:
                return zzbdo.REQUEST_WILL_BUILD_URL;
            case 13:
                return zzbdo.REQUEST_DID_BUILD_URL;
            case 14:
                return zzbdo.REQUEST_WILL_MAKE_NETWORK_REQUEST;
            case 15:
                return zzbdo.REQUEST_DID_RECEIVE_NETWORK_RESPONSE;
            case 16:
                return zzbdo.REQUEST_WILL_PROCESS_RESPONSE;
            case 17:
                return zzbdo.REQUEST_DID_PROCESS_RESPONSE;
            case 18:
                return zzbdo.REQUEST_WILL_RENDER;
            case 19:
                return zzbdo.REQUEST_DID_RENDER;
            case 100:
                return zzbdo.AD_FAILED_TO_LOAD_INVALID_REQUEST;
            case 101:
                return zzbdo.AD_FAILED_TO_LOAD_NETWORK_ERROR;
            case 102:
                return zzbdo.AD_FAILED_TO_LOAD_TIMEOUT;
            case 103:
                return zzbdo.AD_FAILED_TO_LOAD_CANCELLED;
            case LocationRequestCompat.QUALITY_LOW_POWER /*104*/:
                return zzbdo.AD_FAILED_TO_LOAD_NO_ERROR;
            case 105:
                return zzbdo.AD_FAILED_TO_LOAD_NOT_FOUND;
            case 1000:
                return zzbdo.REQUEST_WILL_UPDATE_GMS_SIGNALS;
            case 1001:
                return zzbdo.REQUEST_DID_UPDATE_GMS_SIGNALS;
            case 1002:
                return zzbdo.REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS;
            case PointerIconCompat.TYPE_HELP /*1003*/:
                return zzbdo.REQUEST_FAILED_TO_BUILD_URL;
            case PointerIconCompat.TYPE_WAIT /*1004*/:
                return zzbdo.REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST;
            case 1005:
                return zzbdo.REQUEST_FAILED_TO_PROCESS_RESPONSE;
            case PointerIconCompat.TYPE_CELL /*1006*/:
                return zzbdo.REQUEST_FAILED_TO_UPDATE_SIGNALS;
            case PointerIconCompat.TYPE_CROSSHAIR /*1007*/:
                return zzbdo.REQUEST_FAILED_TO_RENDER;
            case 1100:
                return zzbdo.REQUEST_IS_PREFETCH;
            case 1101:
                return zzbdo.REQUEST_SAVED_TO_CACHE;
            case 1102:
                return zzbdo.REQUEST_LOADED_FROM_CACHE;
            case 1103:
                return zzbdo.REQUEST_PREFETCH_INTERCEPTED;
            case 1104:
                return zzbdo.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
            case 1105:
                return zzbdo.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
            case 1106:
                return zzbdo.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
            case 1107:
                return zzbdo.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
            case 1108:
                return zzbdo.REQUEST_FAILED_TO_LOAD_FROM_CACHE;
            case 10000:
                return zzbdo.BANNER_SIZE_INVALID;
            case 10001:
                return zzbdo.BANNER_SIZE_VALID;
            case 10002:
                return zzbdo.ANDROID_WEBVIEW_CRASH;
            case 10003:
                return zzbdo.OFFLINE_UPLOAD;
            case 10004:
                return zzbdo.DELAY_PAGE_LOAD_CANCELLED_AD;
            default:
                return null;
        }
    }
}
