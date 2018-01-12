# Copyright (C) 2017 GENIVI Alliance
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS_append := ":${THISDIR}/${PN}"

INPUT_EXAMPLE_DESKTOP_FILE="EGLWLInputEventExample.desktop"
MOCK_NAVIGATION_DESKTOP_FILE="EGLWLMockNavigation.desktop"

SRC_URI_append = "                         \
    file://${INPUT_EXAMPLE_DESKTOP_FILE}   \
    file://${MOCK_NAVIGATION_DESKTOP_FILE} \
    "

FILES_${PN} += "\
    /usr/share/applications/* \
    /usr/share/wayland-protocols/stable/ivi-application/ivi-application.xml \
    "

do_install_append() {
  install -Dm 0644 ${WORKDIR}/${INPUT_EXAMPLE_DESKTOP_FILE}   \
                   ${D}/usr/share/applications/${INPUT_EXAMPLE_DESKTOP_FILE}

  install -Dm 0644 ${WORKDIR}/${MOCK_NAVIGATION_DESKTOP_FILE} \
                   ${D}/usr/share/applications/${MOCK_NAVIGATION_DESKTOP_FILE}
}

