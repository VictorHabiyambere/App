package com.google.common.io;

import com.google.common.io.TempFileCreator;
import java.nio.file.attribute.FileAttribute;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda3 implements TempFileCreator.JavaNioCreator.PermissionSupplier {
    public final /* synthetic */ FileAttribute f$0;

    public /* synthetic */ TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda3(FileAttribute fileAttribute) {
        this.f$0 = fileAttribute;
    }

    public final FileAttribute get() {
        return TempFileCreator.JavaNioCreator.lambda$userPermissions$3(this.f$0);
    }
}
