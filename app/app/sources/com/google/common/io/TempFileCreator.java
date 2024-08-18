package com.google.common.io;

import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.FileAttribute;
import java.util.EnumSet;
import java.util.Set;

@ElementTypesAreNonnullByDefault
abstract class TempFileCreator {
    static final TempFileCreator INSTANCE = pickSecureCreator();

    /* access modifiers changed from: package-private */
    public abstract File createTempDir();

    /* access modifiers changed from: package-private */
    public abstract File createTempFile(String str) throws IOException;

    private static TempFileCreator pickSecureCreator() {
        try {
            Class.forName("java.nio.file.Path");
            return new JavaNioCreator();
        } catch (ClassNotFoundException e) {
            try {
                if (((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null)).intValue() < ((Integer) Class.forName("android.os.Build$VERSION_CODES").getField("JELLY_BEAN").get((Object) null)).intValue()) {
                    return new ThrowingCreator();
                }
                return new JavaIoCreator();
            } catch (NoSuchFieldException e2) {
                return new ThrowingCreator();
            } catch (ClassNotFoundException e3) {
                return new ThrowingCreator();
            } catch (IllegalAccessException e4) {
                return new ThrowingCreator();
            }
        }
    }

    private static final class JavaNioCreator extends TempFileCreator {
        private static final PermissionSupplier directoryPermissions;
        private static final PermissionSupplier filePermissions;

        private interface PermissionSupplier {
            FileAttribute<?> get() throws IOException;
        }

        private JavaNioCreator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public File createTempDir() {
            try {
                return Files.createTempDirectory(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]), (String) null, new FileAttribute[]{directoryPermissions.get()}).toFile();
            } catch (IOException e) {
                throw new IllegalStateException("Failed to create directory", e);
            }
        }

        /* access modifiers changed from: package-private */
        public File createTempFile(String prefix) throws IOException {
            return Files.createTempFile(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]), prefix, (String) null, new FileAttribute[]{filePermissions.get()}).toFile();
        }

        static {
            Set<String> views = FileSystems.getDefault().supportedFileAttributeViews();
            if (views.contains("posix")) {
                filePermissions = new TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda0();
                directoryPermissions = new TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda1();
            } else if (views.contains("acl")) {
                PermissionSupplier userPermissions = userPermissions();
                directoryPermissions = userPermissions;
                filePermissions = userPermissions;
            } else {
                TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda2 tempFileCreator$JavaNioCreator$$ExternalSyntheticLambda2 = new TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda2();
                directoryPermissions = tempFileCreator$JavaNioCreator$$ExternalSyntheticLambda2;
                filePermissions = tempFileCreator$JavaNioCreator$$ExternalSyntheticLambda2;
            }
        }

        static /* synthetic */ FileAttribute lambda$static$2() throws IOException {
            throw new IOException("unrecognized FileSystem type " + FileSystems.getDefault());
        }

        private static PermissionSupplier userPermissions() {
            try {
                final ImmutableList<AclEntry> acl = ImmutableList.of(AclEntry.newBuilder().setType(AclEntryType.ALLOW).setPrincipal(FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName(StandardSystemProperty.USER_NAME.value())).setPermissions(EnumSet.allOf(AclEntryPermission.class)).setFlags(new AclEntryFlag[]{AclEntryFlag.DIRECTORY_INHERIT, AclEntryFlag.FILE_INHERIT}).build());
                return new TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda3(new FileAttribute<ImmutableList<AclEntry>>() {
                    public String name() {
                        return "acl:acl";
                    }

                    public ImmutableList<AclEntry> value() {
                        return ImmutableList.this;
                    }
                });
            } catch (IOException e) {
                return new TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda4(e);
            }
        }

        static /* synthetic */ FileAttribute lambda$userPermissions$3(FileAttribute attribute) throws IOException {
            return attribute;
        }

        static /* synthetic */ FileAttribute lambda$userPermissions$4(IOException e) throws IOException {
            throw new IOException("Could not find user", e);
        }
    }

    private static final class JavaIoCreator extends TempFileCreator {
        private static final int TEMP_DIR_ATTEMPTS = 10000;

        private JavaIoCreator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public File createTempDir() {
            File baseDir = new File(StandardSystemProperty.JAVA_IO_TMPDIR.value());
            String baseName = System.currentTimeMillis() + "-";
            for (int counter = 0; counter < TEMP_DIR_ATTEMPTS; counter++) {
                File tempDir = new File(baseDir, baseName + counter);
                if (tempDir.mkdir()) {
                    return tempDir;
                }
            }
            throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + baseName + "0 to " + baseName + 9999 + ')');
        }

        /* access modifiers changed from: package-private */
        public File createTempFile(String prefix) throws IOException {
            return File.createTempFile(prefix, (String) null, (File) null);
        }
    }

    private static final class ThrowingCreator extends TempFileCreator {
        private static final String MESSAGE = "Guava cannot securely create temporary files or directories under SDK versions before Jelly Bean. You can create one yourself, either in the insecure default directory or in a more secure directory, such as context.getCacheDir(). For more information, see the Javadoc for Files.createTempDir().";

        private ThrowingCreator() {
            super();
        }

        /* access modifiers changed from: package-private */
        public File createTempDir() {
            throw new IllegalStateException(MESSAGE);
        }

        /* access modifiers changed from: package-private */
        public File createTempFile(String prefix) throws IOException {
            throw new IOException(MESSAGE);
        }
    }

    private TempFileCreator() {
    }
}
