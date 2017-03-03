package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Certificate;

public interface CertificateListView {
  void onCertificateListReloaded(List<Certificate> certificateList);

  void onCertificateListAppended(List<Certificate> certificateList);
}
