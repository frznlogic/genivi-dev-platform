#
#   Copyright (C) 2014-2015 Pelagicore AB
#
inherit qmake5

FILESEXTRAPATHS_append := ":${THISDIR}/${PN}"

OE_QMAKE_PATH_HEADERS = "${OE_QMAKE_PATH_QT_HEADERS}"

DEPENDS += "qtbase qtdeclarative"

SRC_URI = " \
    git://github.com/Pelagicore/qmldevinfo;branch=restructure_code;protocol=https \
    file://DeviceInfo.desktop \
"

SRCREV = "8f93323dcc73d9647a4d5db3c97b40d377034152"

LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9741c346eef56131163e13b9db1241b3"

PV = "1.0+git${SRCREV}"
PR = "r1"

S = "${WORKDIR}/git/"
B = "${WORKDIR}/build/"

do_configure_prepend() {
    export ENABLE_EXAMPLES=1
}

do_install_append() {
    install -Dm 0644 ${WORKDIR}/DeviceInfo.desktop \
        ${D}/usr/share/applications/DeviceInfo.desktop

    install -d ${D}/usr/lib/qt5/qml/com/pelagicore/qmldevinfo
    install -Dm 0644 ${S}/example/main.qml \
        ${D}/usr/lib/qt5/qml/com/pelagicore/qmldevinfo/
}

FILES_${PN} += " \
    /usr/lib/qt5/qml/com/pelagicore/qmldevinfo/* \
    /usr/share/applications/DeviceInfo.desktop \
"

FILES_${PN}-dbg += " \
    /usr/lib/qt5/qml/com/pelagicore/qmldevinfo/.debug \
"

PACKAGES = "${PN}-dbg ${PN}"
