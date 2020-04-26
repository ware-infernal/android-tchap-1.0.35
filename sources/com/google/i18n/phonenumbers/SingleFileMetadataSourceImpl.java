package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import java.util.concurrent.atomic.AtomicReference;

final class SingleFileMetadataSourceImpl implements MetadataSource {
    private final MetadataLoader metadataLoader;
    private final String phoneNumberMetadataFileName;
    private final AtomicReference<SingleFileMetadataMaps> phoneNumberMetadataRef;

    SingleFileMetadataSourceImpl(String str, MetadataLoader metadataLoader2) {
        this.phoneNumberMetadataRef = new AtomicReference<>();
        this.phoneNumberMetadataFileName = str;
        this.metadataLoader = metadataLoader2;
    }

    SingleFileMetadataSourceImpl(MetadataLoader metadataLoader2) {
        this("/com/google/i18n/phonenumbers/data/SingleFilePhoneNumberMetadataProto", metadataLoader2);
    }

    public PhoneMetadata getMetadataForRegion(String str) {
        return MetadataManager.getSingleFileMetadataMaps(this.phoneNumberMetadataRef, this.phoneNumberMetadataFileName, this.metadataLoader).get(str);
    }

    public PhoneMetadata getMetadataForNonGeographicalRegion(int i) {
        return MetadataManager.getSingleFileMetadataMaps(this.phoneNumberMetadataRef, this.phoneNumberMetadataFileName, this.metadataLoader).get(i);
    }
}
