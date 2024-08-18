package com.google.common.io;

import com.google.common.io.TempFileCreator;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda0 implements TempFileCreator.JavaNioCreator.PermissionSupplier {
    public final FileAttribute get() {
        return PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-------"));
    }
}
